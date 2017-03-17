package com.igor2i.students.modules.pojo.university.objects;

import java.util.Date;

/**
 * Created by igor2i on 16.02.17.
 */
public class Journal {

    private int id;
    private int idStudent;
    private int idLection;
    private Date date;

    public Journal() {
    }

    public Journal(int id, int idStudent, int idLection, Date date) {
        this.id = id;
        this.idStudent = idStudent;
        this.idLection = idLection;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdLection() {
        return idLection;
    }

    public void setIdLection(int idLection) {
        this.idLection = idLection;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idLection=" + idLection +
                ", date=" + date +
                '}';
    }
}
