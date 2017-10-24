package com.weavernorth.hrmsysnc.hrm;

import com.weavernorth.hrmsysnc.hrm.imp.HrmDepartmentImpl;
import com.weavernorth.hrmsysnc.hrm.log.DepartmentLogImp;
import com.weavernorth.hrmsysnc.hrm.manager.DepartmentManager;
import com.weavernorth.hrmsysnc.interfaces.xml.HrmSynService;
import com.weavernorth.hrmsysnc.util.ResolveXmlUtil;
//import net.sf.json.JSONObject;
import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
//import java.util.List;
import java.util.Map;

/**
 * 部门同步
 */
public class HrmSysnServiceImpl extends BaseBean implements HrmSynService {

    @Override
    /**
     * 接口HrmSynService实现类
     * 获取xml文件中的信息
     * 判断部门表中是否有该条信息
     * 进行同步操作
     */
    public String departmentSyn(String strJson) {
        BaseBean bb=new BaseBean();

        HrmDepartmentImpl hdi=new HrmDepartmentImpl();
        String returnValue = "";
        String sql;
        String sql1;//无用，便于重编译文件

        Map xml1;
        ResolveXmlUtil rlx=new ResolveXmlUtil();
        xml1=rlx.resolveXml(strJson);
        //JSONObject json1=JSONObject.fromObject(strJson);
//        JSONObject jsonObject=JSONObject.fromObject(xml1);
//        Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
//        Map<String, Object> mapjsonroot = (Map<String, Object>) mapJson.get("root");
//        Map<String, Object> mapjsonOrg = (Map<String, Object>) mapjsonroot.get("orglist");
//        List<Object> listjsonOrgMap = (List<Object>) mapjsonOrg.get("org");

        Map<String,Object>maporg=null;
        //部门编码departmentcode接口对应id
        String strCode="";
        //部门标识departmentmark接口对应orgCode
        String strShortName="";
        //部门名称departmentname接口对应orgName
        String strFullName="";
        //分部编码
        String strSubid="1";
        //部门层级编号
        String strLevelno="1";
        //接口错误信息
        String IOError;
        DepartmentLogImp departmentLogImpl = null;
        DepartmentManager departmentManager = null;

        try {
            departmentLogImpl=new DepartmentLogImp();
            //logID的自增获取
            //departmentLogImpl.getNextLogID();
            departmentManager=new DepartmentManager(departmentLogImpl);
            //for (int i=0;i<xml1.size();i++){
//                maporg=(Map<String, Object>)xml1.get(i);
                //部门编码
                strCode= Util.null2String(((String)xml1.get("id"))).trim();
                //部门名称
                strFullName=Util.null2String(((String)xml1.get("orgName"))).trim();
                //部门标识
                strShortName=Util.null2String(((String)xml1.get("orgCode"))).trim();
            //}
            departmentManager.departmentAddOrUpdate(strCode,strShortName,strFullName,strSubid,strLevelno);
            hdi.insertHrmDepartment(strFullName,strCode,strShortName,strSubid,strLevelno);
            RecordSet rs=new RecordSet();
            //数据库查询该部门名称下的数据是否存在
            sql="select departmentcode from HrmDepartment where departmentname='"+strFullName+"'";
            String getDepart="";
            rs.execute(sql);
            if (rs.next()){
                getDepart=Util.null2String(rs.getString("departmentcode"));
                bb.writeLog("查询到的部门departmentcode"+getDepart);
            }
            //判断该部门数据是否存在，若不存在，则调用插入方法，插入部门信息
            if (getDepart.equals("")){
                bb.writeLog("部门数据为空，插入该条信息！");
                //调用插入方法
                hdi.insertHrmDepartment(strFullName,strCode,strShortName,strSubid,strLevelno);
            }else {
                bb.writeLog("部门数据不为空，更新该条信息！");
                //调用更新方法
                hdi.updateHrmDepartment(strFullName,strCode,strShortName,strSubid,strLevelno);
            }
            returnValue=departmentLogImpl.getLogDetail();
        }catch (Exception e){
            e.printStackTrace();
            IOError=e.toString();
            bb.writeLog(" 读取接口数据时发生错误" + IOError);
        }

        return returnValue;

    }
}
