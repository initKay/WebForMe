package com.wgh.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    public String encoding=null;//定义编码格式变量
    protected FilterConfig filterConfig=null;//定义过滤器配置对象

    public void init(FilterConfig filterConfig)throws ServletException{
        this.filterConfig=filterConfig;                             //初始化过滤器配置对象
        this.encoding= filterConfig.getInitParameter("encoding");//获取配置文件中的指定编码方式
    }
    //过滤器接口方法，用于执行过滤业务
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException{
        if (encoding!=null){
            request.setCharacterEncoding(encoding);//设置请求的编码
            //设置响应对象的内容类型（包括编码格式）
            response.setContentType("Text/Html;charset="+encoding);
        }
        chain.doFilter(request,response);//传递给下一过滤器
    }

    @Override
    public void destroy() {
        this.encoding=null;
        this.filterConfig=null;
    }

}
