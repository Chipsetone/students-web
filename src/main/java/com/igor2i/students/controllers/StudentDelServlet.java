package com.igor2i.students.controllers;

import com.igor2i.students.modules.pojo.university.Students;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by igor2i on 23.02.17.
 */
@Component
public class StudentDelServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(StudentDelServlet.class);

    @Autowired
    private Students students;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("Del user");

        try {
            students.delById(new Integer(req.getParameter("id")));
        } catch (SQLException e) {
            LOGGER.error("Set new User failed");
            e.printStackTrace();
        }

        resp.sendRedirect("/list");
    }
}
