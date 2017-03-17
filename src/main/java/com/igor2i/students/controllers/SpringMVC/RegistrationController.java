package com.igor2i.students.controllers.SpringMVC;

import com.igor2i.students.modules.pojo.university.objects.User;
import com.igor2i.students.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by igor2i on 06.03.17.
 */
@Controller
public class RegistrationController {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationFormPost(@ModelAttribute("userJSP") User user){
        ModelAndView modelAndView = new ModelAndView();

        LOGGER.debug("postRegistr req login " + user.getLogin() + "  pass "+ user.getPasswd());

        modelAndView.addObject("userJSP", user);

        if(userService.createUser(user.getLogin(), user.getPasswd())){
            LOGGER.debug("postRegistr resp  Success");
            modelAndView.setViewName("index");
            return modelAndView;
        }else{
            LOGGER.debug("postRegistr resp  fail");
            modelAndView.setViewName("registration");
            return modelAndView;
        }
    }

}
