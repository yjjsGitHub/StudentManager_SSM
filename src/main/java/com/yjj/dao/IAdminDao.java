package com.yjj.dao;

import com.yjj.model.Admin;

import java.sql.Date;

/**
 * Created by Administrator on 2018/7/13.
 */
public interface IAdminDao {

    Admin get(String email, String password);

    void update(String email, Date date);
}
