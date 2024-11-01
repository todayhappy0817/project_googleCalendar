package com.project1.project1.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {
    public static final String ENCRYPTION_KEY = "SHA-256"; //사용할 해시 알고리즘
    public static String encrypt(String str) {
        String SHA = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ENCRYPTION_KEY); //SHA-256 알고리즘 인스턴스 생성
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("암호화 에러!", e);
        }
        return SHA;
    }
}
