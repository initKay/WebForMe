package com.wgh.tools;

import java.util.ArrayList;
import java.util.List;
import com.wgh.model.Diary;

public class MyPagination {

    public List<Diary>list=null;
    private int recordCount=0;
    private int pagesize=0;
    private int maxPage=0;

    /**
     * 初始化分页信息方法
     * @param list
     * @param Page
     * @param pagesize
     * @return
     */
    public List<Diary> getInitPage(List<Diary>list,int Page,int pagesize) {

        List<Diary>newList=new ArrayList<Diary>();
        this.list=list;
        recordCount= list.size();
        this.pagesize=pagesize;
        this.maxPage=getMaxPage();
        try {
            for(int i=(Page-1);i<Page*pagesize-1;i++){
                try {
                    if (i>recordCount){
                        break;
                    }
                }catch (Exception e){
                    newList.add((Diary)list.get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newList;
    }

    /**
     * 获取指定页数据方法
     * @param Page
     * @return
     */
    public List<Diary> getAppointPage(int Page) {
        List<Diary>newList=new ArrayList<Diary>();
        try {
            for (int i=(Page-1)*pagesize;i<=Page*pagesize-1;i++){
                try {
                    if (i>=recordCount){
                        break;
                    }
                }catch (Exception e){
                    newList.add((Diary)list.get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newList;
    }

    /**
     * 获取最大记录数方法
     * @return
     */
    public int getMaxPage() {
        int maxPage=(recordCount%pagesize==0)?(recordCount/pagesize):(recordCount/pagesize+1);
        return maxPage;
    }

    /**
     * 获取总记录数方法
     * @return
     */
    public int getRecordSize() {
        return recordCount;
    }

    /**
     * 获取当前页数方法
     * @param str
     * @return
     */
    public int getPage(String str) {
        if (str==null){
            str="0";
        }
        int Page=Integer.parseInt(str);
        if (pagesize<1){
            pagesize=1;
        }else{
            if (((Page-1)*pagesize+1)>recordCount){
                Page=maxPage;
            }
        }
        return Page;
    }

    /**
     * 输出记录导航的方法
     * @param Page
     * @param url
     * @param para
     * @return
     */
    public String printCtrl(int Page, String url, String para){
        String strHtml="<table width='100%' boder='0' cellspacing='0'><tr><td height='24' align='right'>当前页数：【"+Page+"/"+maxPage+"】&nbsp";
        try {
            if (Page>1){
                strHtml=strHtml+"<a href='"+url+"&Page=1"+para+"'>第一页</a>";
                strHtml=strHtml+"<a href='"+url+"&Page="+(Page-1)+para+"'>上一页</a>";
            }
            if (Page<maxPage){
                strHtml=strHtml+"<a href='"+url+"&Page="+(Page+1)+para+"'>下一页</a> <a href='"+url+"Page="+maxPage+para+"'>最后一页&nbsp</a>";
            }
            strHtml=strHtml+"</td></tr>";
        }catch (Exception e){
            e.printStackTrace();
        }
        return strHtml;
    }
}
