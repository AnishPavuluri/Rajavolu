package com.village.rajavolu.util;

import com.village.rajavolu.Constants.StringConstants;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by sony on 15/12/2015.
 */
public class ValidationUtil {

    public static String validatePhoneNumber(String phoneNumber) {
        char actualNumber[] = {StringConstants.OPEN_BRACE, StringConstants.CLOSE_BRACE, StringConstants.DOT, StringConstants.HYPHEN, StringConstants.SPACE};
        if (StringUtils.containsAny(phoneNumber, actualNumber)) {
            return StringUtils.remove(StringUtils.remove(
                    StringUtils.remove(StringUtils.remove(StringUtils
                                    .deleteWhitespace(phoneNumber),
                            StringConstants.CLOSE_BRACE), StringConstants.OPEN_BRACE),
                    StringConstants.HYPHEN), StringConstants.DOT);
        } else {
            return phoneNumber;
        }
    }

    public static boolean validNumberFormat(String phoneNumber) {
        Pattern pattern = Pattern.compile(StringConstants.PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public static boolean validEmailFormat(String email) {
        Pattern pattern = Pattern.compile(StringConstants.EMAIL);
        Matcher matcher = pattern.matcher(email.toUpperCase());
        return matcher.find();

    }

    public static boolean validCorporateEmailFormat(String email) {
        Set domainNames = new HashSet();
        domainNames.add("gmail");
        domainNames.add("yahoo");
        domainNames.add("hotmail");
        domainNames.add("live");
        Pattern pattern = Pattern.compile(StringConstants.EMAIL);
        Matcher matcher = pattern.matcher(email.toUpperCase());
        if (matcher.find()) {
            String extendingEmail = email.substring(email.lastIndexOf('.') + 1, (email.length()));
            String domain = email.substring(email.lastIndexOf('@') + 1, ((email.length()) - (extendingEmail.length()) - 1));
            if (!domainNames.contains(domain)) {
                return false;
            } else {
                if (!(extendingEmail.equalsIgnoreCase("com") || extendingEmail.equalsIgnoreCase("org"))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /*public static void main(String[] args) {
        String ph = "00000";
        String no = validatePhoneNumber(ph);
        System.out.println("###### : " + StringUtils.isNumeric(validatePhoneNumber(ph)));
       // boolean nn = validNumberFormat(ph);
        boolean ee = validNumberFormat("94");
        //boolean ema = validCorporateEmailFormat("gmail@hotmail.org");
        System.out.println("###### : " + ee + " $$$$$$$$$$$$: "+no +"  *********: "+StringUtils.startsWith(ph, "0"));
    }*/
}