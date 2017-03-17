package com.igor2i.students.controllers;

import com.igor2i.students.services.UserService;
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

/**
 * Created by igor2i on 23.02.17.
 */
@Component
public class RegistrationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String passwd = req.getParameter("password");
        LOGGER.debug("postRegistr req login " + login + "  pass "+ passwd);
        if(userService.createUser(login, passwd)){
            LOGGER.debug("postRegistr resp  Success");
            resp.sendRedirect("/list");
        }else{
            LOGGER.debug("postRegistr resp  fail");
            resp.sendRedirect("/registration");
        }
    }
}
