package com.village.rajavolu.bean;

import java.io.Serializable;

/**
 *
 * Created by Srinivas.V on 15/11/2015.
 */

public class LoginFrom implements Serializable {

    private String emailId;
    private String password;
    private String mobileNo;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
