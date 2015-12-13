package com.village.rajavolu.controller;

import com.village.rajavolu.bean.LoginFrom;
import com.village.rajavolu.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;

/**
 *
 * Created by sony on 15/11/2015.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLogin() {
        return new ModelAndView("login", "loginCommandName", new LoginFrom());
    }

    @RequestMapping(value = "loginFrom", method = RequestMethod.POST)
    public ModelAndView newLoginPage(@ModelAttribute("loginCommandName") @Valid LoginFrom loginFrom, BindingResult bindingResult) throws ParseException {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        } else {

            return new ModelAndView("login");
        }
    }
}
