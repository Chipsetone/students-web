package com.igor2i.students.modules.pojo.university.objects;

import java.sql.Timestamp;

/**
 * Created by igor2i on 16.02.17.
 */
public class Lection {

    private int id;
    private String name;
    private String text;
    private String subject;
    private Timestamp dateTime;


    public Lection() {
    }

    public Lection(String name, String text, String subject, Timestamp dateTime) {
        this.name = name;
        this.text = text;
        this.subject = subject;
        this.dateTime = dateTime;
    }

    public Lection(int id, String name, String text, String subject, Timestamp dateTime) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.subject = subject;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", subject='" + subject + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
