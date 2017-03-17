package com.igor2i.students.modules.pojo.university;

import com.igor2i.students.modules.pojo.university.objects.UserRole;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Семакин Виктор
 */
@Component
public class UserRoleDao {
    private static final String TABLE_NAME = "students.public.user_role";


    public List<UserRole> getRolesByUserId(int userId) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE userid=?";
        ArrayList<UserRole> resultList = new ArrayList<>();

        Connection connection = ConnectionsMyDB.getDbCon().connection;

        try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultList.add(getUserRoleFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private UserRole getUserRoleFromResultSet(ResultSet resultSet) throws SQLException {
        return new UserRole(resultSet.getInt("id"),
                resultSet.getInt("userId"),
                resultSet.getString("rolename"));
    }
}
