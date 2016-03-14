package com.village.rajavolu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * Created by Srinivas.V on 05/03/2016.
 */
@Controller
public class RouteMapController {

    @RequestMapping( value = "/map", method = RequestMethod.GET)
    public ModelAndView showContacts() {
        return new ModelAndView("map", "message", "routeMap");
    }

}
