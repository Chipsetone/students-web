package com.igor2i.students.modules.pojo.university;


import com.igor2i.students.modules.pojo.university.objects.Journal;

import java.util.ArrayList;

/**
 * Created by igor2i on 16.02.17.
 */
public class Journals implements WorkWithDB<Journal> {

    private static final String tableName = "journal";

    @Override
    public ArrayList<Journal> getAll(){
        return null;
    }

    @Override
    public Journal getById(int id) {
        return null;
    }

    @Override
    public Journal getByName(String name) {
        return null;
    }

    @Override
    public void setNewColumn(Journal journal) {
        ;
    }

    @Override
    public void setUpdateById(int id, Journal journal) {

    }
}
