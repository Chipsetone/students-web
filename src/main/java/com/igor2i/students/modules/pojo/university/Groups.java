package com.igor2i.students.modules.pojo.university;


import com.igor2i.students.modules.pojo.university.objects.Group;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by igor2i on 16.02.17.
 */
@Component
public class Groups implements WorkWithDB<Group> {

    private static final String tableName = "groups";


    @Override
    public ArrayList<Group> getAll() throws SQLException {

        Connection connection = ConnectionsMyDB.getDbCon().connection;
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("select * from " + tableName);

        ArrayList<Group> groupArrayList = new ArrayList<>();

        while (resultSet.next()) {
            groupArrayList.add(new Group(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("number")));
        }

        return groupArrayList;

    }

    @Override
    public Group getById(int id) throws SQLException {

        Connection connection = ConnectionsMyDB.getDbCon().connection;

        String query = "SELECT * FROM " + tableName + " WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id));

        ResultSet resultSet = preparedStatement.executeQuery();
        Group group = null;

        while (resultSet.next()) {
            group = new Group(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                    resultSet.getInt("number"));
        }
        return group;
    }

    @Override
    public Group getByName(String name) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;

        String query = "SELECT * FROM " + tableName + " WHERE `name` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(name));

        ResultSet resultSet = preparedStatement.executeQuery();
        Group group = null;

        while (resultSet.next()) {
            group = new Group(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("number"));
        }
        return group;
    }

    @Override
    public void setNewColumn(Group group) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "INSERT INTO " + tableName + " (`name`, `number`) VALUES ( ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, group.getName());
        preparedStatement.setString(2, String.valueOf(group.getNumber()));

        preparedStatement.execute();

    }

    @Override
    public void setUpdateById(int id, Group group) throws SQLException  {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "UPDATE " + tableName + " SET `name` = ?,`number` = ? WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, group.getName());
        preparedStatement.setString(2, String.valueOf(group.getNumber()));
        preparedStatement.setString(3, String.valueOf(id));

        preparedStatement.execute();
    }

}
