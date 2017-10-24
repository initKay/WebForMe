package com.weavernorth.hrmsysnc.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ResolveXmlUtil {
	/**
	 * 解析xml方法
	 * @param xml 需要解析的xml字符串
	 * @return xml解析后的map集合
	 */
	public Map<String,String> resolveXml(String xml){
		try {
			//将文件转为document类型
			Document document = DocumentHelper.parseText(xml);
			//获取根节点元素对象
			Element root = document.getRootElement();
			//遍历
			return listNodes(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 遍历当前节点下的所有节点  
	 * @param node 当前节点
	 * @return 当前节点返回的map集合
	 */
    public Map<String,String> listNodes(Element node){  
    	Map<String,String> map = new HashMap<String,String>();
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();
//        //遍历属性节点  
//        for(Attribute attribute : list){  
//            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
//        }  
        //如果当前节点内容不为空，则输出  
        if(!(node.getTextTrim().equals(""))){  
        	map.put(node.getName(), node.getText());
        }  
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            map.putAll(listNodes(e));  
        }  
        return map;
    }  
}
