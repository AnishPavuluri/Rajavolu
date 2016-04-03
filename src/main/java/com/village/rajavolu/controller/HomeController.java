package com.village.rajavolu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: Anish
 * Date: 11/14/15
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    @RequestMapping( value = "/home", method = RequestMethod.GET)
    public ModelAndView showContacts() {
        return new ModelAndView("home", "message", "welcome to Rajavolu");
    }

    @RequestMapping( value = "/about", method = RequestMethod.GET)
    public ModelAndView aboutPage() {
        return new ModelAndView("about", "message", "welcome to Rajavolu");
    }
}
