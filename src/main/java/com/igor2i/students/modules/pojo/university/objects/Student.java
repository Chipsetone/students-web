package com.igor2i.students.modules.pojo.university.objects;

import java.util.Date;

/**
 * Created by igor2i on 16.02.17.
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private int male;
    private int idGroup;

    public Student(int id, String firstName, String lastName, Date dob, int male, int idGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.male = male;
        this.idGroup = idGroup;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", male=" + male +
                ", idGroup=" + idGroup +
                '}';
    }
}
