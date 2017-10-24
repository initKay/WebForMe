package com.weavernorth.hrmsysnc.hrm.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import weaver.conn.ConnStatement;
import weaver.conn.RecordSet;
import weaver.general.BaseBean;

public class HrmDepartmentImpl {

    private ConnStatement statement;
    private static Log log= LogFactory.getLog(HrmDepartmentImpl.class.getName());
    public String Departmentname;
    public String Departmentcode;
    public String Departmentmark;
    public String Subcompanyid="1";
    public String Levelno="1";

    /**
     *插入部门信息表
     * @return
     */
    public String insertHrmDepartment(String departmentname,String departmentcode,String departmentmark,String subcompanyid,String levelno){
        String strReturnValue="";
        BaseBean bb=new BaseBean();
        Departmentname=departmentname;
        Departmentcode=departmentcode;
        Departmentmark=departmentmark;
        Subcompanyid=subcompanyid;
        Levelno=levelno;
        String strSql="insert into HrmDepartment (departmentname,departmentcode,departmentmark,subcompanyid1) " +
                "values('"+departmentname+"','"+departmentcode+"','"+departmentmark+"',"+subcompanyid+")";
        statement =new ConnStatement();
        try {

            log.info(strSql);
            bb.writeLog("插入部门信息的sql："+strSql);
            statement.setStatementSql(strSql);
            statement.setString(1,Departmentname);//获取部门名称
            statement.setString(2,Departmentcode);//获取部门id
            statement.setString(3,Departmentmark);//获取部门标识
            statement.setString(4,Subcompanyid);//获取分部ID
            statement.setString(5,Levelno);//获取部门级别
//          statement.setString(6,TimeUtil.getCurrentDateString());//获取插入日期
//          statement.setString(7,TimeUtil.getCurrentTimeString().split("")[1]);//获取插入时间
            statement.executeUpdate();
            strReturnValue="success";
        }catch (Exception e){
            strReturnValue="添加人力资源部门信息异常！"+e.toString();
            log.error("添加人力资源部门信息异常！"+e);
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                strReturnValue = "添加人力资源部门信息关闭数据库连接异常！"+e.toString();
                log.error("添加人力资源部门信息异常！" + e);
            }
        }
        bb.writeLog("执行结果："+strReturnValue);
        return strReturnValue;
    }
    public String updateHrmDepartment(String departmentname,String departmentcode,String departmentmark,String subcompanyid,String levelno){
        String strReturnValue="";
        BaseBean bb=new BaseBean();
        statement =new ConnStatement();
        try {
            String strSqlForUpdate="update HrmDepartment set departmentname='"+departmentname+"',departmentmark='"+departmentmark
                    +"',subcompanyid1='"+subcompanyid+"','where departmentcode='"+departmentcode+"'";
            log.info(strSqlForUpdate);
            bb.writeLog("更新部门信息的sql："+strSqlForUpdate);
            statement.setStatementSql(strSqlForUpdate);
            statement.executeUpdate();
            strReturnValue="success";
        }catch (Exception e){
            strReturnValue="更新人力资源部门信息异常！"+e.toString();
            log.error("更新人力资源部门信息异常！"+e);
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                strReturnValue = "更新人力资源部门信息关闭数据库连接异常！"+e.toString();
                log.error("更新人力资源部门信息异常！" + e);
            }
        }
        bb.writeLog("执行结果："+strReturnValue);
        return strReturnValue;
    }


    //关于部门名称的方法
    public String getDepartmentname() {
        return Departmentname;
    }
    public void setDepartmentname(String departmentname) {
        this.Departmentname = departmentname;
    }
    //关于部门id的方法
    public String getDepartmentcode(){
        return Departmentcode;
    }
    public void setDepartmentcode(String departmentcode){
        this.Departmentcode=departmentcode;
    }
    //关于部门标识的方法
    public String getDepartmentmark(){
        return Departmentmark;
    }
    public void setDepartmentmark(String departmentmark){
        this.Departmentmark=departmentmark;
    }
    //固定分部id和层级id为1
    public String getSubcompanyid(){
        return Subcompanyid;
    }
    public void setSubcompanyid(String subcompanyid){
        this.Subcompanyid=subcompanyid;
    }
    public String getLevelno(){
        return Levelno;
    }
    public void setLevelno(String levelno){
        this.Levelno=levelno;
    }
}
