package com.yjj.dao;

import com.yjj.model.Klass;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */
public interface IKlassDao {

    List<Klass> list();//班级列表

    void insert(Klass klass);//添加班级

    void update(Klass klass);//更新班级信息

    void delete(String cid);//删除班级

    Klass get(String cid);//获取某个班级详情
}
