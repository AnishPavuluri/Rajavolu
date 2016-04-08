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
 * This Controller class to handle the login request.
 * Created by Srinivas.V on 15/11/2015.
 */

@Controller
public class LoginController {

    @Autowired
    LoginValidator loginValidator;

    /**
     * This method to bind the properties
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(loginValidator);
    }

    /**
     * This method
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView viewLogin() {
        return new ModelAndView("login", "loginCommandName", new LoginFrom());
    }

    /**
     * This method handle the user login request
     * @param loginFrom
     * @param bindingResult
     * @param request
     * @return
     * @throws ParseException
     */
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

    /**
     * This method handle logout functionality
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }
}
