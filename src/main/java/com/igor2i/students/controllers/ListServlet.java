package com.igor2i.students.controllers;

import com.igor2i.students.modules.pojo.university.Students;
import com.igor2i.students.modules.pojo.university.objects.Student;
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
import java.util.ArrayList;

/**
 * Created by igor2i on 23.02.17.
 */
@Component
public class ListServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ListServlet.class);

    @Autowired
    private Students students;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("getList");

        try {
            ArrayList<Student> studentsArr = students.getAll();
            req.setAttribute("list",studentsArr);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("lists.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("lists.jsp").forward(req, resp);
    }
}
