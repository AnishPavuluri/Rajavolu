package com.village.rajavolu.bean;

import com.village.rajavolu.Util.ValidationUtil;
import com.village.rajavolu.dto.User;
import com.village.rajavolu.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import java.util.List;


/**
 *
 * Created by Srinivas.V on 18/12/2015.
 */
@Component
public class RegisterValidate implements Validator {

    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterFrom.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterFrom registerFrom = (RegisterFrom) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.registerFrom.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.registerFrom.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty.registerFrom.emailId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.registerFrom.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.registerFrom.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.registerFrom.dateOfBirth");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "NotEmpty.registerFrom.mobileNo");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aadharNo", "NotEmpty.registerFrom.aadharNo");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pinCode", "NotEmpty.registerFrom.pinCode");

        if (null != registerFrom.getEmailId() && !StringUtils.isEmpty(registerFrom.getEmailId())) {
            if (!ValidationUtil.validEmailFormat(registerFrom.getEmailId())) {
                errors.rejectValue("emailId", "Diff.registerFrom.emailId");
            }
        }
        if (null != registerFrom.getMobileNo() && !StringUtils.isEmpty(registerFrom.getMobileNo()) && !StringUtils.isNumeric(ValidationUtil.validatePhoneNumber(registerFrom.getMobileNo()))) {
            if (!ValidationUtil.validNumberFormat(registerFrom.getMobileNo()) && !(registerFrom.getMobileNo().length() == 10)) {
                errors.rejectValue("mobileNo", "Diff.registerFrom.mobileNo");
            }
        }
        if (null != registerFrom.getMobileNo() && !StringUtils.isEmpty(registerFrom.getMobileNo()) &&
                StringUtils.isNumeric(ValidationUtil.validatePhoneNumber(registerFrom.getMobileNo())) && !(registerFrom.getMobileNo().length() == 10)
                && StringUtils.startsWith(registerFrom.getMobileNo(), "0")) {
            errors.rejectValue("mobileNo", "Valid.registerFrom.mobileNo");
        }
        if (null != registerFrom.getPassword() && null != registerFrom.getConfirmPassword() && !StringUtils.isEmpty(registerFrom.getPassword())) {
            if (!registerFrom.getPassword().equals(registerFrom.getConfirmPassword())) {
                errors.rejectValue("confirmPassword", "Diff.registerFrom.confirmPassword");
            }
        }
        if (null != registerFrom.getAadharNo() && !StringUtils.isEmpty(registerFrom.getAadharNo())) {
            if (registerFrom.getAadharNo().equals("12") && !StringUtils.isNumeric(registerFrom.getAadharNo())) {
                errors.rejectValue("aadharNo", "NotEmpty.registerFrom.aadharNo");
            }
        }
        if (null != registerFrom.getPinCode() && !StringUtils.isEmpty(registerFrom.getPinCode())) {
            if (registerFrom.getPinCode().equals("6") && !StringUtils.isNumeric(registerFrom.getPinCode())) {
                errors.rejectValue("pinCode", "NotEmpty.registerFrom.pinCode");
            }
        }
        if (!errors.hasErrors()) {
            List<User> user = userService.findByUserEmailOrMobile(registerFrom.getEmailId(), registerFrom.getMobileNo());
            for (User users : user) {
                if (users.getEmailId().equalsIgnoreCase(registerFrom.getEmailId())) {
                    errors.rejectValue("emailId", "already.registerFrom.emailId");
                } else if (users.getMobileNo().equalsIgnoreCase(registerFrom.getMobileNo())) {
                    errors.rejectValue("mobileNo", "already.registerFrom.mobileNo");
                }
            }
        }
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
