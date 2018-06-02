package com.cheney.satisfy.util;

public class StringUtil {

    public static boolean isNullOrBlank(String content) {
        if (content == null || "".equals(content.trim())) {
            return true;
        }
        return false;
    }
}
