package com.catcher92.blog.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
