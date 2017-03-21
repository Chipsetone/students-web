package com.igor2i.students.modules.pojo.university.objects;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by igor2i on 16.02.17.
 */
@Entity
@Table(name="lection", schema="public")
public class Lection {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
//    @Column(name = "subject")
    private String text;
    @Column(name = "subject")
    private String subject;
    @Column(name = "date")
    private Timestamp dateTime;

    @Column(name= "groupid")
    private int group_id;

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

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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
