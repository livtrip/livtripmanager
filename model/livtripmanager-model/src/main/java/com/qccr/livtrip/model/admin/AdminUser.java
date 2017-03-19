package com.qccr.livtrip.model.admin;

import com.qccr.livtrip.model.common.BaseDO;

import java.io.Serializable;

/**
 * 管理员
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2016/10/12 16:47 user Exp $$
 */
public class AdminUser extends BaseDO implements Serializable{


    private static final long serialVersionUID = 5591835053504873556L;
    private Integer id;
    private String userName;
    private String email;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
