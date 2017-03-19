package com.qccr.livtrip.biz.service.admin;

import com.qccr.livtrip.model.admin.AdminUser;

/**
 * 管理员接口
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2016/10/12 17:07 user Exp $$
 */
public interface AdminUserService {

    /**
     * 新增
     * @param adminUserDO
     * @return
     */
    boolean insertAdminUser(AdminUser adminUserDO);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteAdminUser(Integer id);

    /**
     *查询管理员是否存在
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    Boolean  isAdminUserExist(String userName, String password);

}
