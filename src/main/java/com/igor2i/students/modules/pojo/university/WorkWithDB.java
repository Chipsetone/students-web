package com.igor2i.students.modules.pojo.university;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by igor2i on 16.02.17.
 */
public interface WorkWithDB<T> {

    ArrayList<T> getAll() throws SQLException;

    T getById(int id) throws SQLException;

    T getByName(String name) throws SQLException;

    void setNewColumn(T object) throws SQLException;

    void setUpdateById(int id, T object) throws SQLException;
}
