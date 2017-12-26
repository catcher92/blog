package com.catcher92.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    public static String encode(String content) {
        StringBuilder builder = new StringBuilder();
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5加密失败");
            throw new RuntimeException(e);
        }
        byte[] md5Bytes = digest.digest(content.getBytes(Charset.defaultCharset()));
        for (byte md5Byte : md5Bytes) {
            int val = (int) md5Byte & 0xff;
            if (val < 16) {
                builder.append("0");
            }
            builder.append(Integer.toHexString(val));
        }
        return builder.toString();
    }
}
