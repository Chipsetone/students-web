package com.igor2i.students.security;

import com.igor2i.students.modules.pojo.university.UserRoleDao;
import com.igor2i.students.modules.pojo.university.Users;
import com.igor2i.students.modules.pojo.university.objects.User;
import com.igor2i.students.modules.pojo.university.objects.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Семакин Виктор
 */
//@Component(value="customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
    private static final Logger logger = LogManager.getLogger(CustomUserDetailService.class);

    @Autowired
    private Users userDao = new Users();
    @Autowired
    private UserRoleDao userRoleDao = new UserRoleDao();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.getByName(username);
        } catch (SQLException e) {
            logger.error("Какая-то хрень при вытаскивании юзера из бд", e);
        }

        if(user == null) {
            logger.error("Не нашелся пользователь");
            throw new UsernameNotFoundException("Не нашелся пользователь");
        }
        logger.trace("пользователь судя по всему нашелся");

        List<UserRole> userRoles = userRoleDao.getRolesByUserId(user.getId().intValue());

        if (userRoles.size() <= 0) {
            logger.info("Для пользователя " + username + " не найдены роли =(");
        }
        logger.trace("Роли у этого пользователя походу тоже нормальные");

        return new CustomUserDetails(user, userRoles);
    }
}
