package com.weavernorth.hrmsysnc.hrm.manager;

import com.weavernorth.hrmsysnc.hrm.imp.HrmDepartmentImpl;
import com.weavernorth.hrmsysnc.hrm.log.DepartmentLogImp;
import weaver.common.util.string.StringUtil;
import weaver.conn.RecordSet;
import weaver.general.BaseBean;

public class DepartmentManager extends BaseBean {
    private DepartmentLogImp departmentLogImp;
    private boolean isUpdateCache=true;

    /**
     *
     * @param departmentLogImp
     */
    public DepartmentManager(DepartmentLogImp departmentLogImp){
        this.departmentLogImp = departmentLogImp;
    }

    /**
     *
     * @return
     */
    public boolean isUpdateCache(){
        return isUpdateCache;
    }

    /**
     *
     * @param isUpdateCache
     */
    public void setUpdateCache(boolean isUpdateCache){
        this.isUpdateCache=isUpdateCache;
    }

    /**
     *
     * @param strCode 部门编码
     * @param strShortname 部门标识
     * @param strFullname 部门全称
     * @param strsubid 分部ID
     * @param strLevelno 部门层级
     * @return
     */
    public boolean departmentAddOrUpdate(String strCode, String strShortname,String strFullname,String strsubid,String strLevelno){
//        HrmDepartmentImpl hrmDepartment=new HrmDepartmentImpl();
//        DepartmentComInfo dci=null;
        BaseBean bb=new BaseBean();
        //String strDepartID="";
       // String strOrg_id="";
        //String strParent_id="";
        String errorMsg="";
        String IOError="";
        //String strReturnValue;
        //RecordSet rs=new RecordSet();
        try {
//            dci=new DepartmentComInfo();
            departmentLogImp.setDepartmentCode(strCode);
            departmentLogImp.setDepartmentFullName(strFullname);
            departmentLogImp.setDepartmentShortName(strShortname);
            departmentLogImp.setSubcompanyCode(strsubid);
            departmentLogImp.setLevelno(strLevelno);
            if (StringUtil.isNullOrEmpty(strCode)){
                errorMsg="添加部门失败，原因：部门编码不能为空。";
                departmentLogImp.setPsmessage(errorMsg);
                departmentLogImp.insertHrmLog();
                return false;
            }
            if (StringUtil.isNullOrEmpty(strFullname)){
                errorMsg="添加部门失败，原因：部门名称不能为空。";
                departmentLogImp.setPsmessage(errorMsg);
                departmentLogImp.insertHrmLog();
                return false;
            }
            if (StringUtil.isNullOrEmpty(strShortname)){
                errorMsg="添加部门失败，原因：部门标识不能为空。";
                departmentLogImp.setPsmessage(errorMsg);
                departmentLogImp.insertHrmLog();
                return false;
            }
            if (StringUtil.isNullOrEmpty(strsubid)){
                errorMsg="添加部门失败，原因：分部id不能为空。";
                departmentLogImp.setPsmessage(errorMsg);
                departmentLogImp.insertHrmLog();
                return false;
            }
            if (StringUtil.isNullOrEmpty(strLevelno)){
                errorMsg="添加部门失败，原因：部门层级不能为空。";
                departmentLogImp.setPsmessage(errorMsg);
                departmentLogImp.insertHrmLog();
                return false;
            }


        }catch (Exception e){
            e.printStackTrace();
            bb.writeLog("获取接口部门时发生异常,部门标号:"+strCode+e.toString());
            departmentLogImp.setInterfaceReason(("获取接口部门时发生异常,部门标号:"+strCode+e.toString()));
            departmentLogImp.insertHrmLog();
            return false;
        }

        return true;
    }
}
