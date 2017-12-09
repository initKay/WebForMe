package com.initKay.bauble.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: initKay
 * Date: 2017/12/8
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * *关于map的工具类
 */
public class getMultivaluedMap {
    /**
     * 2017 11 06 添加
     * 查询map中是否有这个key的存在
     * 如果key存在，将这个value添加到key对应的value中
     * 如果key不存在，则对zhe个map新增键值对
     *
     * @param key 传过来的key值
     * @param val 传过来的value
     * @param map 传过来需要校验的map
     * @return 返回的map
     */
    public Map getMultivaluedMap(String key, String val, Map<String, List<String>> map) {
        //Map<String,List<String>> map=new HashMap();
        List<String> list = new ArrayList<String>();
        if (!key.equals("")) {
            if (map.containsKey(key)) {
                list = map.get(key);
                list.add(val);
                map.put(key, list);
            } else {
                list.add(val);
                map.put(key, list);
            }
        }
        return map;
    }
}
