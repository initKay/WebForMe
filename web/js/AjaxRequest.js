var net=new Object();//定义全局变量
net.AjaxRequest=function (url,onload,onerror,method,params) {
    this.req=null;
    this.onload=onload;
    this.onerror=(onerror)?onerror:this.defaultError;
    this.loadDate(url,method,params);
}
//用于初始化XMLHttpRequest对象并指定处理函数，最后发送Http请求的方法
net.AjaxRequest.prototype.loadDate=function (url,method,params) {
    if(!method){
        method="GET";//默认请求方式为get
    }

}
