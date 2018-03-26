package com.initKay.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/1/3
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MathPrecision {
    private static BigDecimal bigDecial_01;
    private static BigDecimal bigDecial_02;

    //处理精度的加法

    /**
     * author:initKay
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return double 计算加法的结果
     * Description:
     * 计算两个字符相加的结果
     * Date:2018/3/24 23:38
     */
    public static double add(String a, String b) {
        if (a == null || a.equals("")) {
            a = "0";
        } else {
            a = a.replaceAll(",", "");
        }
        if (b == null || b.equals("")) {
            b = "0";
        } else {
            b = b.replaceAll(",", "");
        }
        bigDecial_01 = new BigDecimal(a);
        bigDecial_02 = new BigDecimal(b);
        return bigDecial_01.add(bigDecial_02).doubleValue();
    }


    /**
     * author:initKay
     *
     * @param number 需要转换的字符串
     * @return double
     * Description:
     * 获得字符串类型转Double类型
     * Date:2018/3/24 23:32
     */
    public double getDouble(String number) {
        double dounumber = 0.00;
        if (!number.equals("")) {
            try {
                dounumber = new DecimalFormat().parse(number).doubleValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dounumber;
    }

    /**
     * author:initKay
     *
     * @param a 字符串a需要是数字
     * @param b 字符串b需要是数字
     * @return double 返回计算结果
     * Description:
     * 处理双精度的减法
     * Date:2018/3/24 23:34
     */
    public static double subtract(String a, String b) {
        if (a == null || a.equals("")) {
            a = "0";
        } else {
            a = a.replaceAll(",", "");
        }
        if (b == null || b.equals("")) {
            b = "0";
        } else {
            b = b.replaceAll(",", "");
        }
        bigDecial_01 = new BigDecimal(a);
        bigDecial_02 = new BigDecimal(b);
        return bigDecial_01.subtract(bigDecial_02).doubleValue();
    }
}
