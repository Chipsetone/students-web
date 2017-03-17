package com.igor2i.students.controllers;

import com.igor2i.students.modules.pojo.university.objects.Lection;
import com.igor2i.students.services.LectionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by igor2i on 24.02.17.
 */
@WebServlet("/editLection")
@Component
public class LectionEditServlet extends HttpServlet{

    private static final Logger LOGGER = LogManager.getLogger(LectionEditServlet.class);

    @Autowired
    private LectionsService lectionsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        LOGGER.debug(idStr);
        if(idStr != null){
            LOGGER.debug("edit lection " + idStr);
            Lection lection = lectionsService.getById(new Integer(idStr));
            if(lection != null){
                LOGGER.debug("edit lection " + idStr);
                req.setAttribute("title", "edit lection " + lection.getName());
                req.setAttribute("id", lection.getId());
                req.setAttribute("name", lection.getName());
                req.setAttribute("text", lection.getText());
                req.setAttribute("subject", lection.getSubject());
                req.setAttribute("dateTime", lection.getDateTime());

                req.getRequestDispatcher("editLection.jsp").forward(req, resp);
            }

        }else {

            req.setAttribute("title", "Add new lection");

            req.getRequestDispatcher("editLection.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String text = req.getParameter("text");
        String subject = req.getParameter("subject");
        String dateTime = req.getParameter("dateTime").replace("T"," ").concat(":00");
        Lection lection = new Lection( name, text, subject, Timestamp.valueOf(dateTime));

        if(idStr != null){

            lectionsService.updateLection(new Integer(idStr),lection);

        }else {

            lectionsService.newLection(lection);

        }
        resp.sendRedirect("/lections");
    }
}
