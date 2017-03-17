package com.igor2i.students.controllers.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by igor2i on 24.02.17.
 */
@WebListener
public class AppLoadListener implements ServletContextListener{

    private static final Logger LOGGER = LogManager.getLogger(AppLoadListener.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.trace("site started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.trace("site stopped");
    }
}
