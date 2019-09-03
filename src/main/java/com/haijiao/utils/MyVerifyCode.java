/*
package com.haijiao.utils;

*/
/**
 * 人类验证码生成工具类
 *//*

public class MyVerifyCode {
    
    private static int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] nums2 = {1, 2, 3};
    private static int a;
    private static int b;
    private static int c;
    private static String d;
    private static String code;
    
    private MyVerifyCode() {
    }
    
    public static String[] getCode(){
        
        a = nums1[(int) (Math.random() * 9)];
        b = nums1[(int) (Math.random() * 9)];
        c = nums2[(int) (Math.random() * 3)];
        String[] strs;
        if (c == 1) {
            
            d = String.valueOf(a + b);
            code = a + " + " + b + "= ?";
            
        } else if (c == 2) {
    
            d = String.valueOf(a - b);
            code = a + " - " + b + "= ?";
            
        } else if (c == 3) {
    
            d = String.valueOf(a * b);
            code = a + " * " + b + "= ?";
            
        }
        strs = new String[]{code, d};
        return strs;
    }
    
}
*/
