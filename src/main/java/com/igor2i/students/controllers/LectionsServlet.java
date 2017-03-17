package com.igor2i.students.controllers;

import com.igor2i.students.services.LectionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by igor2i on 24.02.17.
 */
//@WebServlet("/lections")
//@Component
public class LectionsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LectionsServlet.class);

    @Autowired
    private LectionsService lectionsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("getLections");

        req.setAttribute("lections", lectionsService.getAllLections());

        req.getRequestDispatcher("lections.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String typeAction = req.getParameter("type");
        LOGGER.debug("postLections "+ typeAction);

        if("del".equals(typeAction)){

            Integer idLection = new Integer(req.getParameter("id"));

            LOGGER.debug("post del" + idLection);
            lectionsService.delLection(idLection);

            resp.sendRedirect("/lection");
        }else if("add".equals(typeAction)){

            LOGGER.debug("post add");
            resp.sendRedirect("/editLection");

        }else if("edit".equals(typeAction)){

            LOGGER.debug("post edit " + req.getParameter("id"));
            resp.sendRedirect("/editLection?id=" + req.getParameter("id"));
        }
    }
}
