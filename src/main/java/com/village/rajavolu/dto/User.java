package com.village.rajavolu.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * User: user
 * Date: 11/15/15
 * Time: 10:56 PM
 */
@NamedQueries({
        @NamedQuery(name = "User.findByEmailOrMobileNo", query ="from User user where user.emailId = ? and user.mobileNo = ?"),
        @NamedQuery(name = "User.findByUserMobileNo", query ="from User user where user.mobileNo=?"),
        @NamedQuery(name = "User.findByUserEmail", query ="from User user where user.emailId=?")
})
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "USER")
public class User extends BaseDto {

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String confirmPassword;

    private Date dateOfBirth;

    private String mobileNo;

    private String aadharNo;

    private String pinCode;

    @Column(name = "FIRST_NAME",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "LAST_NAME",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PASSWORD",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "CONFIRMPWD",nullable = false)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Column(name = "AADHAR_NO",nullable = false)
    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    @Column(name = "PIN_CODE",nullable = false)
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Column(name = "EMAIL_ID",nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "DOB",nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "MOBILE_NO",nullable = false)
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
