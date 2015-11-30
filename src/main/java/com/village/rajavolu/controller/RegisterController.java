package com.village.rajavolu.controller;

import com.village.rajavolu.bean.RegisterFrom;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * Created by sony on 21/11/2015.
 */
@Controller
public class RegisterController {

    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("register","registerCommandName",new RegisterFrom());
    }

    @RequestMapping(value = "registerBean", method = RequestMethod.POST)
    public ModelAndView newRegistration(@ModelAttribute("registerCommandName") @Valid RegisterFrom registerFrom, BindingResult bindingResult) throws ParseException {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }else{
            User user = new User();
            user.setFirstName(registerFrom.getFirstName());
            user.setLastName(registerFrom.getLastName());
            user.setEmailId(registerFrom.getEmailId());
            user.setPassword(registerFrom.getPassword());
            user.setConfirmPassword(registerFrom.getConfirmPassword());
            user.setDateOfBirth(registerFrom.getDateOfBirth());
            user.setMobileNo(registerFrom.getMobileNo());
            user.setAadharNo(registerFrom.getAadharNo());
            user.setPinCode(registerFrom.getPinCode());
            userService.createUser(user);
            return new ModelAndView("register");
        }
    }
}
