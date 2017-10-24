package com.weavernorth.hrmsysnc.hrm.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import weaver.conn.ConnStatement;
import weaver.conn.RecordSet;
import weaver.general.TimeUtil;


public class DepartmentLogImp {
    private ConnStatement statement;
    private int deptSynLogId;
    private static Log log = LogFactory.getLog(DepartmentLogImp.class.getName());

    // 同步对象

    public DepartmentLogImp() {
        // 获得日志主键

    }
    public void getNextLogID(){
        RecordSet rs = new RecordSet();
        rs.execute("select dept_synlog_seq.nextval as logid from dual");
        rs.next();
        deptSynLogId = rs.getInt("logid");

    }

    /**
     * 将异常信息写入日志
     * @return
     */
    public boolean insertHrmLog() {
        boolean is_success = false;
        statement = new ConnStatement();
        try {
            String sql="insert into uf_SynDepartment(departmentcode,departmentname,departmentmark,operatedate,operatetime,logid,InterfaceReason,subid,levelno,errorMsg) values(?,?,?,?,?,?,?,?,?,?)";
//            String sql = "insert into uf_SynDepartment (action,code,shortname,fullname,org_code,parent_code,showorder,operatedate,operatetime,InterfaceReason,logid,levelno,psmessage) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement.setStatementSql(sql);
            statement.setString(1, this.getDepartmentCode());
            statement.setString(2, this.getDepartmentFullName());
            statement.setString(3, this.getDepartmentShortName());
            statement.setString(4, TimeUtil.getCurrentDateString());
            statement.setString(5, TimeUtil.getCurrentTimeString().split(" ")[1]);
            statement.setString(6, deptSynLogId+"");
            statement.setString(7, this.getInterfaceReason());
            statement.setString(8, this.getSubcompanyCode());
            statement.setString(9, this.getLevelno());
            statement.setString(10,this.getPsmessage());
            statement.executeUpdate();
            is_success = true;
        } catch (Exception e) {
            is_success = false;
            log.error("写入部门日志时异常！" + e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                is_success = false;
                log.error("写入部门日志时关闭异常！" + e);
            }
        }
        return is_success;
    }
    public String getLogDetail(){
        RecordSet rsLog=new RecordSet();
        StringBuffer stbJson = new StringBuffer();
        String strJson="";
        rsLog.execute("select departmentcode,departmentmark,psmessage from uf_SynDepartment where logid="+this.deptSynLogId+" order by id");
        String strCode ="";
        String strShortName = "";
        String strFlag ="";
        String strError = "";
        stbJson.append("{\"root\":{\"orglist\":{\"org\":[");
        while(rsLog.next()){
            strCode = rsLog.getString("departmentcode");
            strShortName = rsLog.getString("departmentmark");
            strError = rsLog.getString("psmessage");
            if("success".equals(strError)){
                strFlag="1";
                strError="成功";

            }else{
                strFlag="0";
            }
            stbJson.append("\"departmentcode\":\"").append(strCode).append("\",");
            stbJson.append("\"departmentmark\":\"").append(strShortName).append("\",");
            stbJson.append("\"flag\":\"").append(strFlag).append("\",");
            stbJson.append("\"message\":\"").append(strError).append("\"},");

        }
        strJson=stbJson.toString();
        if(rsLog.getCounts()>0){
            strJson=strJson.substring(0,strJson.length()-1);
        }

        strJson+="]}}}";
        return strJson;
    }

    private String departmentCode;
    private String departmentShortName;
    private String departmentFullName;
    private String subcompanyCode;
    private String interfaceReason;
    private String psmessage;
    private String levelno;

    public String getLevelno() {
        return levelno;
    }
    public void setLevelno(String levelno) {
        this.levelno = levelno;
    }
    public String getPsmessage() {
        return psmessage;
    }
    public void setPsmessage(String psmessage) {
        this.psmessage = psmessage;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentShortName() {
        return departmentShortName;
    }
    public void setDepartmentShortName(String departmentShortName) {
        this.departmentShortName = departmentShortName;
    }
    public String getDepartmentFullName() {
        return departmentFullName;
    }
    public void setDepartmentFullName(String departmentFullName) {
        this.departmentFullName = departmentFullName;
    }

    public String getSubcompanyCode() {
        return subcompanyCode;
    }
    public void setSubcompanyCode(String subcompanyCode) {
        this.subcompanyCode = subcompanyCode;
    }
    public String getInterfaceReason() {
        return interfaceReason;
    }
    public void setInterfaceReason(String interfaceReason) {
        this.interfaceReason = interfaceReason;
    }
    public void addLogDetail(String string, String subcompanycode2,
                             String string2, String string3, String errorMsg, String string4) {

    }



}
