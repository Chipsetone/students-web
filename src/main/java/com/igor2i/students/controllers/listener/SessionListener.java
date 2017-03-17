package com.igor2i.students.controllers.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by igor2i on 24.02.17.
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger LOGGER = LogManager.getLogger(SessionListener.class);


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.trace(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        LOGGER.trace(event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
