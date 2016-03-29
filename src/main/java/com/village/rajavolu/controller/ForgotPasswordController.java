package com.village.rajavolu.controller;

import com.village.rajavolu.bean.ForgotForm;
import com.village.rajavolu.bean.ForgotValidator;
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

import javax.validation.Valid;

/**
 *
 * Created by Srinivas.V on 26/03/2016.
 */

@Controller
public class ForgotPasswordController {

    private static final Logger LOGGER = Logger.getLogger(ForgotPasswordController.class);

    @Autowired
    ForgotValidator forgotValidator;

    @InitBinder
    protected void initBin0der(WebDataBinder binder) {
        binder.setValidator(forgotValidator);
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public ModelAndView forgotView() {
        return new ModelAndView("forgot", "forgotCommandName", new ForgotForm());
    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String forgotPassword(@ModelAttribute("forgotCommandName") @Valid ForgotForm forgotForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  "redirect:/forgot";
        }else {
            return "redirect:/login";
        }
    }

}
