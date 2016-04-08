package com.village.rajavolu.bean;

import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This validator class to validate the login functionality.
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

    /**
     * This validate method to handle the login validations.
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        LoginFrom loginFrom = (LoginFrom) target;
        List<User> user;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty.loginFrom.emailId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginFrom.password");

        if (!errors.hasErrors()) {
            if (loginFrom.getEmailId().matches("[7-9][0-9]{9}") && loginFrom.getEmailId().matches("\\d+")) {
                user = userService.findByUserMobileNo(loginFrom.getEmailId());
            } else {
                user = userService.findByUserEmail(loginFrom.getEmailId());
            }
            if (user.isEmpty()) {
                errors.rejectValue("password", "NotMatch.loginFrom.email");
            } else {
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpServletRequest request = requestAttributes.getRequest();
                for (User users : user) {
                    if (users.getEmailId().equalsIgnoreCase(loginFrom.getEmailId()) ||
                            users.getMobileNo().equalsIgnoreCase(loginFrom.getEmailId())) {
                        if (!users.getPassword().equals(loginFrom.getPassword())) {
                            errors.rejectValue("password", "NotSame.loginFrom.password");
                        }
                    }
                    HttpSession session = request.getSession(true);
                    session.setAttribute("firstName", users.getFirstName().substring(0, 1).toUpperCase() + users.getFirstName().substring(1));
                }
            }
        }
    }
    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
