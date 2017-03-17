package com.igor2i.students.modules.pojo.university;

import com.igor2i.students.modules.pojo.university.objects.Lection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by igor2i on 16.02.17.
 */
@Component
public class Lections implements WorkWithDB<Lection> {

    private static final String tableName = "lections";

    @Override
    public ArrayList<Lection> getAll() throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM " + tableName);

        ArrayList<Lection> lections = new ArrayList<>();

        while (resultSet.next()) {
            lections.add(new Lection(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("text"),
                    resultSet.getString("subject"),
                    resultSet.getTimestamp("dateTime")
            ));
        }
        return lections;
    }

    @Override
    public Lection getById(int id) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;

        String query = "SELECT * FROM " + tableName + " WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id));

        ResultSet resultSet = preparedStatement.executeQuery();
        Lection lection = null;

        while (resultSet.next()) {
            lection = new Lection(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("text"),
                    resultSet.getString("subject"),
                    resultSet.getTimestamp("dateTime")
            );
        }
        return lection;
    }

    @Override
    public Lection getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void setNewColumn(Lection lection) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "INSERT INTO " + tableName + " (`name`, `text`, `subject`, `dateTime`) " +
                "VALUES ( ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, lection.getName());
        preparedStatement.setString(2, lection.getText());
        preparedStatement.setString(3, lection.getSubject());
        preparedStatement.setTimestamp(4, lection.getDateTime());

        preparedStatement.execute();
    }

    @Override
    public void setUpdateById(int id, Lection lection) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "UPDATE " + tableName + " SET `name`=?,`text`=?,`subject`=?,`dateTime` = ?" +
                " WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, lection.getName());
        preparedStatement.setString(2, lection.getText());
        preparedStatement.setString(3, lection.getSubject());
        preparedStatement.setTimestamp(4, lection.getDateTime());

        preparedStatement.setInt(5, id);

        preparedStatement.execute();
    }

    public void delById(int id) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "DELETE FROM " + tableName + "  WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

}
