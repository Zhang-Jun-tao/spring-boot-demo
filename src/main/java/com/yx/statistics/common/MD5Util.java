package com.yx.statistics.common;


import java.security.MessageDigest;

/**
 * Created by zhang on 2016/12/8.
 */
public class MD5Util {
    private static final String SALT="yx-statistics-system";

    public static  String handlerRawPw(String ramPw){
        return MD5(SALT.replace("statistics",ramPw)).toUpperCase();
    }


    private static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.print(handlerRawPw("123456"));//0D633C0ABCD8D6B7D8090776E096969C
    }

}
