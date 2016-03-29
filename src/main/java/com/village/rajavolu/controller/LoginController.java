package com.village.rajavolu.controller;

import com.village.rajavolu.bean.LoginFrom;
import com.village.rajavolu.bean.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;

/**
 *
 * Created by Srinivas.V on 15/11/2015.
 */

@Controller
public class LoginController {

    @Autowired
    LoginValidator loginValidator;

    @InitBinder
    protected void initBin0der(WebDataBinder binder) {
        binder.setValidator(loginValidator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLogin() {
        return new ModelAndView("login", "loginCommandName", new LoginFrom());
    }

    @RequestMapping(value = "loginFrom", method = RequestMethod.POST)
    public ModelAndView newLoginPage(@ModelAttribute("loginCommandName") @Valid LoginFrom loginFrom, BindingResult bindingResult,HttpServletRequest request) throws ParseException {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        } else {
            HttpSession session = request.getSession(true);
            String user = request.getParameter("emailId");
            session.setAttribute("user", user);
            return new ModelAndView("home");
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

    /*@RequestMapping(value = "/forgotId",method = RequestMethod.GET,params = {"argName"})
    public ModelAndView forgotPassword(@ModelAttribute("loginCommandName") @Valid LoginFrom loginFrom, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return new ModelAndView("forgotId");
        }else {
            return new ModelAndView("login");
        }
    }*/
}
