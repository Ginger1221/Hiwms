package com.example.utils;

import java.security.MessageDigest;

/**
 * 加密工具类
 * @author ginger
 */
public class EncryptUtil {


    /**
     * SHA加密 生成40位SHA码
     * @param Str 待加密字符串
     * @return 返回40位SHA码
     * @throws Exception e
     */
    public static String shaEncode(String Str) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = Str.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 测试主函数
     * @param args args
     * @throws Exception e
     */
    public static void main(String[] args) throws Exception {
        //123456的密文7c4a8d09ca3762af61e59520943dc26494f8941b
        String str = "1";
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));

    }


}
