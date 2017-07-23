package com.kingfish.show.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

public class DateTimeUtil {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String toString(Date date) {
        return FastDateFormat.getInstance(DEFAULT_PATTERN).format(date);
    }
}
