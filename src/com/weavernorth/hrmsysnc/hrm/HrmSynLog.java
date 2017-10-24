package com.weavernorth.hrmsysnc.hrm;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;

public class HrmSynLog extends BaseBean {
    private RecordSet rsLog=new RecordSet();
    private int hrSynLogId;
    private String starttime;
    private String endtime;
    private String costtime;
    private String remark;

    //同步类型
    public enum SYNTYPE{
        ADD,EDIT,DELETE,UNDELETE;
    }

}
