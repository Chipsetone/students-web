package com.igor2i.students.modules.pojo.university;

import com.igor2i.students.modules.pojo.university.objects.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor2i on 23.02.17.
 */
@Component
public class Users implements WorkWithDB<User> {
    private static final Logger logger = LogManager.getLogger(Users.class);

    private static final String tableName = "students.public.user";
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("STUDENTS");


    @Override
    public ArrayList<User> getAll() throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM " + tableName);

        ArrayList<User> groupArrayList = new ArrayList<>();

        while (resultSet.next()) {
            groupArrayList.add(getUserFromResultSet(resultSet));
        }
        return groupArrayList;
    }

    @Override
    public User getById(int id) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;

        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id));

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return getUserFromResultSet(resultSet);
        }
        return null;
    }

    @Override
    public User getByName(String login) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("login"), login)
                )
        );

        List<User> users = em.createQuery(criteriaQuery).getResultList();

        return users.get(0);
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getBoolean("enabled"));
    }

    @Override
    public void setNewColumn(User user) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "INSERT INTO " + tableName + " (login,password) " +
                "VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPasswd());

        preparedStatement.execute();
    }

    @Override
    public void setUpdateById(int id, User user) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "UPDATE " + tableName + " SET passwd=?" +
                " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getPasswd());

        preparedStatement.execute();
    }


}
