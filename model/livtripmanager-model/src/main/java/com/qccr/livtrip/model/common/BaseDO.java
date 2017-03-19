package com.qccr.livtrip.model.common;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2016/10/12 16:49 user Exp $$
 */
public class BaseDO implements Serializable{

    private static final long serialVersionUID = -3832027892634032348L;
    private String createPerson;
    private Date createTime;
    private String updatePerson;
    private Date updateTime;


    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
