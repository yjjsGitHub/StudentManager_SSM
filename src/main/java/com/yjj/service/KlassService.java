package com.yjj.service;

import com.yjj.dao.IKlassDao;
import com.yjj.model.Klass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */
@Service("klassService")
public class KlassService {

    @Resource
    private IKlassDao klassDao;

    //获取班级列表
    public List<Klass> list() {
        return klassDao.list();
    }

    //获取某个班级详情
    public Klass get(String cid) {
        return klassDao.get(cid);
    }

    //批量删除班级（用上事务注解，表示开启事务）
    @Transactional
    public void delete(String[] ids) {
        if (ids != null) {
            for (String cid : ids) {
                klassDao.delete(cid);
            }
        }
    }

    //更新班级信息
    //更新班级（用上事务注解，表示开启事务）
    @Transactional
    public void update(Klass klass) {
        klassDao.update(klass);
    }

    //添加班级
    //批量添加班级（用上事务注解，表示开启事务）
    @Transactional
    public void insert(Klass klass) {
        klassDao.insert(klass);
    }
}
