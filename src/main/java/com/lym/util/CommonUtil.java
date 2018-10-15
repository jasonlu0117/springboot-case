package com.lym.util;

import com.google.common.base.Strings;

public class CommonUtil {

    public static boolean isEmpty(String... args) {
        for (String arg : args) {
            if (Strings.isNullOrEmpty(arg)) {
                return true;
            }
        }
        return false;
    }
    
}