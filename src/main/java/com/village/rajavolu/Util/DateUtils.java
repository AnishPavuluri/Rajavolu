package com.village.rajavolu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 3/29/16
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {

    public static String  convertDateToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
