package com.igor2i.students.modules.pojo.university.objects;

import java.util.Date;

/**
 * Created by igor2i on 16.02.17.
 */
public class Student {
    private int id;
    private Date birthdate;
    private char sex;
    private int idGroup;
    private String name;

    public Student(int id, String firstName, Date dob, int male, int idGroup) {
        this.id = id;
        this.name = firstName;
        this.birthdate = dob;
        this.sex = (char)male;
        this.idGroup = idGroup;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
