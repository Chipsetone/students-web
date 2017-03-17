package com.igor2i.students.modules.pojo.university;

import com.igor2i.students.modules.pojo.university.objects.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {
    @Test
    public void getUserByLogin() throws Exception {
        Users users = new Users();

        User user = users.getByName("login1");

        assertNotNull(user);
        assertEquals("123", user.getPasswd());

    }

}