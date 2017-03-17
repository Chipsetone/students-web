package com.igor2i.students.modules.pojo.university;

import com.igor2i.students.modules.pojo.university.objects.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentsMyBatisTest {
    @Test
    public void getById_myBatis() throws Exception {
        Students students = new Students();
        Student student = students.getById(9);

        assertNotNull(student);
        assertEquals("name2", student.getName());
    }

}