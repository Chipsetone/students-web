package com.igor2i.students.modules.pojo.university;


import com.igor2i.students.modules.pojo.university.objects.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor2i on 16.02.17.
 */
@Component
public class Students implements WorkWithDB<Student> {
    private static final Logger logger = LogManager.getLogger(Students.class);

    private static final String tableName = "students";


    @Override
    public ArrayList<Student> getAll() throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT * FROM " + tableName);

        ArrayList<Student> groupArrayList = new ArrayList<>();

        while (resultSet.next()) {
            groupArrayList.add(new Student(resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getDate("dob"),
                    resultSet.getInt("male"),
                    resultSet.getInt("idGroup")
            ));
        }
        return groupArrayList;
    }

    @Override
    public Student getById(int id) throws SQLException {
        SqlSessionFactory sqlSessionFactory;
        StudentsMaper studentsMaper;
        Student student = null;
        try(Reader reader = Resources.getResourceAsReader("META-INF/mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            studentsMaper = sqlSessionFactory.openSession().getMapper(StudentsMaper.class);
            student = studentsMaper.getStudentById(id);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student getByName(String login) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;

        String query = "SELECT * FROM " + tableName + " WHERE `firstName` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(login));

        ResultSet resultSet = preparedStatement.executeQuery();
        Student group = null;

        while (resultSet.next()) {
            group = new Student(resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getDate("dob"),
                    resultSet.getInt("male"),
                    resultSet.getInt("idGroup")
            );
        }
        return group;
    }

    @Override
    public void setNewColumn(Student student) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "INSERT INTO " + tableName + " (`firstName`, `lastName`, `dob`, `male`, `idGroup`) " +
                "VALUES ( ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setDate(3, new Date(student.getDob().getTime()));
        preparedStatement.setString(4, String.valueOf(student.getMale()));
        preparedStatement.setString(5, String.valueOf(student.getIdGroup()));

        preparedStatement.execute();
    }

    @Override
    public void setUpdateById(int id, Student student) throws SQLException {
        Connection connection = ConnectionsMyDB.getDbCon().connection;
        String query = "UPDATE " + tableName + " SET `firstName`=?,`lastName`=?,`dob`=?,`male` = ?,`idGroup`= ?" +
                " WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, String.valueOf(student.getDob()));
        preparedStatement.setString(4, String.valueOf(student.getMale()));
        preparedStatement.setString(5, String.valueOf(student.getIdGroup()));

        preparedStatement.setString(6, String.valueOf(id));

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
