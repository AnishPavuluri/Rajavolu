package com.village.rajavolu.controller;

import com.village.rajavolu.bean.LoginFrom;
import com.village.rajavolu.bean.LoginValidator;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 *
 * Created by Srinivas.V on 15/11/2015.
 */

@Controller
public class LoginController {

    @Autowired
    LoginValidator loginValidator;
    UserService userService;

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
            List<User> userData = userService.findByUserEmail(user);
            for (User userDetails : userData) {
                session.setAttribute("firstName", userDetails.getFirstName().substring(0, 1).toUpperCase() + userDetails.getFirstName().substring(1));
            }
            return new ModelAndView("home");
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
