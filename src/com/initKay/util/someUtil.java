package com.initKay.util;

import net.sf.json.JSONArray;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2017/12/22
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class someUtil {
    /**
     * 判断字符串是否为纯数字
     * @param str 传过来的字符串
     * @return 返回结果
     */
    public boolean isDigit(String str){
        boolean flag;
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        flag=pattern.matcher(str).matches();
        return flag;
    }

    /**
     * 解析json的方法
     * @param strJson 传过来的json字符串
     */
    public void analysisJSON(String strJson) {
        boolean flag = true;
        JSONArray json = JSONArray.fromObject(strJson);
        for (int i = 0; i < json.size(); i++) {
            String id = json.getJSONObject(i).getString("id");
            String value = json.getJSONObject(i).getString("value");
            String userid = json.getJSONObject(i).getString("userid");
        }
    }
}
