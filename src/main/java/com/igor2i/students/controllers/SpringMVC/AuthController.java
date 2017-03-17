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
public class AuthController {

    private static final Logger LOGGER = LogManager.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @RequestMapping(value = "/logut", method = RequestMethod.GET)
//    public ModelAndView logot() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userJSP", new User());
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView registrationPost(@ModelAttribute("userJSP") User user) {

        ModelAndView modelAndView = new ModelAndView();

        LOGGER.debug("postAuth req login " + user.getLogin() + "  pass "+ user.getPasswd());

        modelAndView.addObject("userJSP", user);

        if(userService.authorize(user.getLogin(), user.getPasswd())){
            LOGGER.debug("postAuth resp  Success");
            modelAndView.setViewName("index");
            return modelAndView;
        }else{
            LOGGER.debug("postAuth resp  fail");
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

}
