package com.village.rajavolu.bean;

import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.apache.log4j.Logger;
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
    @Override
    public boolean supports(Class<?> clazz) {
        return ForgotForm.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.warn("*****validate*******");
        ForgotForm forgotForm = (ForgotForm) target;
        LOGGER.warn("*****validat---->"+forgotForm.getForgotPwd());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "forgotPwd", "NotEmpty.forgotForm.forgotPwd");
        if (!errors.hasErrors()) {
            List<User> user = userService.findByUserEmail(forgotForm.getForgotPwd());
            if(user.isEmpty()){
                errors.rejectValue("forgotPwd", "NotMatch.forgotForm.forgotPwd");
            }
        }
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
