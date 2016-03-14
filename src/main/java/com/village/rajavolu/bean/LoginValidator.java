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
 * Created by Srinivas.V on 31/12/2015.
 */
@Component
public class LoginValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(LoginValidator.class);

    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginFrom.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginFrom loginFrom = (LoginFrom) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty.loginFrom.emailId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginFrom.password");

        if (!errors.hasErrors()) {
           // List<User> user = userService.findByUserEmailAndPassword(loginFrom.getEmailId(), loginFrom.getPassword());
            List<User> user = userService.findByUserEmail(loginFrom.getEmailId());
            LOGGER.warn("********User info-->"+user);
            if (user.isEmpty()) {
                errors.rejectValue("password", "NotMatch.loginFrom.email");
            } else {
                for (User users : user) {
                    if (users.getEmailId().equalsIgnoreCase(loginFrom.getEmailId()) ||
                            users.getMobileNo().equalsIgnoreCase(loginFrom.getMobileNo())) {
                        if (!users.getPassword().equals(loginFrom.getPassword())) {
                            errors.rejectValue("password", "NotSame.loginFrom.password");
                        }
                    }
                }
            }
        }
    }
    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
