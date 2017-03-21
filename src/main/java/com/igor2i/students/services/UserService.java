package com.igor2i.students.services;

import com.igor2i.students.modules.pojo.university.Users;
import com.igor2i.students.modules.pojo.university.objects.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by igor2i on 23.02.17.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    private Users users;

    @Autowired
    public UserService(Users users) {
        this.users = users;
    }

    private int count = 0;

    public boolean authorize(String login, String pass){
        User user = users.getByName(login);
        if(user != null) {
            if (login.equals(user.getLogin()) && pass.equals(user.getPasswd())) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean createUser(String login, String pass){

        try {

            //Users users = new Users();
            User user = users.getByName(login);
            if(user == null) {

                user = new User();
                user.setLogin(login);
                user.setPasswd(pass);


                users.setNewColumn(user);

                user = users.getByName(login);
                if(user != null){

                    LOGGER.debug("user " + login + " success");
                    return true;
                }else {

                    LOGGER.debug("user " + login + " faild");
                    return false;
                }

            }else {
                LOGGER.debug("user " + login + " already this");
                return false;
            }


        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        return false;

    }

}
