package com.initKay.util;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/2/26
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 * Description:
 *              用于获取项目class文件路径的类
 */
public class ProjectClassPath {
    /**
     * 用于获取项目class文件路径的方法
     * @return 项目路径
     */
    public static String getConfigPath() {
        String spath = "appconfig";
        URL url = Thread.currentThread().getContextClassLoader()
                .getResource("");
        String path = url.getPath().replace("classes", spath);
        path = path.substring(1);
        System.out.println(path);
        return path;
    }
}
