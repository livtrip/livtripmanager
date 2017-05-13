/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.qccr.livtrip.dal.admin;


import com.qccr.livtrip.model.admin.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserDao {

    /**
     * 新增管理员
     * @param adminUserDO
     * @return
     */
    int insertAdminUser(AdminUser adminUserDO);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    int deleteAdminUser(@Param("id") Integer id);

    /**
     * 查询用户是否存在
     * @param userName
     * @param password
     * @return
     */
    String isAdminUserExist(@Param("userName")String userName,@Param("password")String password);


}
