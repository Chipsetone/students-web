package com.igor2i.students.controllers.SpringMVC;

import com.igor2i.students.services.LectionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by igor2i on 10.03.17.
 */
@Controller
public class LectionController {

    private static final Logger LOGGER = LogManager.getLogger(LectionController.class);

    @Autowired
    private LectionsService lectionsService;


    @RequestMapping(value = "/lections", method = RequestMethod.GET)
    public ModelAndView registration() {

        ModelAndView modelAndView = new ModelAndView();

        LOGGER.debug("getLections");
        modelAndView.addObject("lections", lectionsService.getAllLections());

        modelAndView.setViewName("lections");
        return modelAndView;
    }



}
