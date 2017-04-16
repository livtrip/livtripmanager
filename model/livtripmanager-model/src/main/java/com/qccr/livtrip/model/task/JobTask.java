package com.qccr.livtrip.model.task;

import com.qccr.livtrip.model.common.BaseDO;

/**
 *  定时任务
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/15 16:20 Exp $$
 */
public class JobTask extends BaseDO{

    private Integer id;
    private String taskCode;
    private Integer taskType;
    private String taskImplClass;
    private String taskExpress;
    /**U 已使用 O 已结束*/
    private String state;
    private String params;
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskImplClass() {
        return taskImplClass;
    }

    public void setTaskImplClass(String taskImplClass) {
        this.taskImplClass = taskImplClass;
    }

    public String getTaskExpress() {
        return taskExpress;
    }

    public void setTaskExpress(String taskExpress) {
        this.taskExpress = taskExpress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
