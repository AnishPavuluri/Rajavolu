package com.village.rajavolu.enums;

/**
 * User: Anish
 * Date: 4/27/14
 * Time: 12:31 AM
 */
public enum TemplateNames {
    templates("templates/"),
    registrationMail,
    forgotPasswordMail;

    TemplateNames(String path) {
        this.path = path;
    }

    TemplateNames() {

    }

    private String path;

    public String getPath() {
        return path;
    }
}
