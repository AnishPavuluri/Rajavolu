package com.village.rajavolu.controller;

import com.village.rajavolu.bean.RegisterFrom;
import com.village.rajavolu.bean.RegisterValidate;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.dto.UserVO;
import com.village.rajavolu.enums.TemplateNames;
import com.village.rajavolu.mail.MailService;
import com.village.rajavolu.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
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
import javax.validation.Valid;
import java.text.ParseException;

/**
 *
 * Created by Srinivas.V on 21/11/2015.
 */
@Controller
public class RegisterController {

    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

    @Autowired
    UserService userService;

    @Autowired
    RegisterValidate registerValidate;
    @Autowired
    MailService mailService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(registerValidate);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("register","registerCommandName",new RegisterFrom());
    }

    @RequestMapping(value = "registerBean", method = RequestMethod.POST)
    public ModelAndView newRegistration(@ModelAttribute("registerCommandName") @Valid RegisterFrom registerFrom, BindingResult bindingResult,HttpServletRequest request) throws ParseException {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }else{
            try{
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(userVO,registerFrom);
                User newUser = userService.registerUser(userVO);
                if(newUser != null ){
                    //HttpSession session = request.getSession(true);
                    mailService.sendMail(newUser.getEmailId(), null, TemplateNames.templates.getPath() + TemplateNames.registrationMail.name(), newUser);
                    request.setAttribute("newUser", "Registration Successful...");
                    request.getSession().setAttribute("user", newUser.getEmailId());
                    request.setAttribute("userName", newUser.getFirstName().substring(0, 1).toUpperCase() + newUser.getFirstName().substring(1));
                }

            }catch (Exception e){
               bindingResult.rejectValue("Whoops!","Whoops! error occured due to techical problem,try again.");
            }
            return new ModelAndView("register");
        }
    }
}
