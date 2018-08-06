package com.yjj.service;

import com.yjj.dao.IAdminDao;
import com.yjj.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/13.
 */
@Service("adminService")
public class AdminService {

    @Resource
    private IAdminDao adminDao;

    //管理员登陆
    public Admin login(String email, String password) {
        return adminDao.get(email, password);
    }

    //记录这次登陆时间
    public void lastLogin(String email) {
        adminDao.update(email, new java.sql.Date((new java.util.Date()).getTime()));
    }
}
