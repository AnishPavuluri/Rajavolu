package com.village.rajavolu.bean;

import com.village.rajavolu.dto.User;
import com.village.rajavolu.enums.TemplateNames;
import com.village.rajavolu.mail.MailService;
import com.village.rajavolu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Srinivas.V on 26/03/2016.
 */
@Component
public class ForgotValidator implements Validator{

    private static final Logger LOGGER = Logger.getLogger(ForgotValidator.class);
    UserService userService;
    @Autowired
    MailService mailService;
    @Override
    public boolean supports(Class<?> clazz) {
        return ForgotForm.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ForgotForm forgotForm = (ForgotForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "forgotPwd", "NotEmpty.forgotForm.forgotPwd");
        if (!errors.hasErrors()) {
            List<User> users = userService.findByUserEmail(forgotForm.getForgotPwd());
            if (users.isEmpty()) {
                errors.rejectValue("forgotPwd", "NotMatch.forgotForm.forgotPwd");
            } else {
                mailService.sendMail(forgotForm.getForgotPwd(), null, TemplateNames.templates.getPath() + TemplateNames.forgotPasswordMail.name(), users);
            }
        }
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
