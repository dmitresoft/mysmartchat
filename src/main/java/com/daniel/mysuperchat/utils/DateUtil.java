package com.daniel.mysuperchat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm");

    public static String format(Date date) {
        return FORMAT.format(date);
    }

}
