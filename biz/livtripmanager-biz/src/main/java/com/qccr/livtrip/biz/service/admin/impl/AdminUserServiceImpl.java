package com.qccr.livtrip.biz.service.admin.impl;

import com.qccr.livtrip.dal.admin.AdminUserDao;
import com.qccr.livtrip.model.admin.AdminUser;
import com.qccr.livtrip.biz.service.admin.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员接口
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2016/10/12 17:07 user Exp $$
 */
@Service("adminUserService")
public class AdminUserServiceImpl  implements AdminUserService {

    @Resource
    private AdminUserDao adminUserDao;


    @Override
    public boolean insertAdminUser(AdminUser adminUserDO) {
        int insertNum = adminUserDao.insertAdminUser(adminUserDO);
        if(insertNum >0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdminUser(Integer id) {
        int deleteNum = adminUserDao.deleteAdminUser(id);
        if(deleteNum > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isAdminUserExist(String userName, String password) {
        String applicationId = adminUserDao.isAdminUserExist(userName,password);
        if(StringUtils.isBlank(applicationId)){
            return false;
        }
        return true;
    }
}
