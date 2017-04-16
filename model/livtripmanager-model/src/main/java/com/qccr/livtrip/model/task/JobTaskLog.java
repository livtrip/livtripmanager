package com.qccr.livtrip.model.task;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 任务日志
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/16 15:01 Exp $$
 */
public class JobTaskLog extends BaseDO{

    private Integer id;
    private Integer taskId;
    /**状态 O结束，R运行中，E异常结束*/
    private String state;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
