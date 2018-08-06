package com.yjj.service;

import com.yjj.dao.IStudentDao;
import com.yjj.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentService {

    @Autowired
    private IStudentDao dao;

    public Student get(String sid) {
        return dao.get(sid);
    }

    public List<Student> list(String cid) {
        return dao.list(cid);
    }

    public void save(Student student) {
        dao.insert(student);
    }

    @Transactional
    public void delete(String[] ids) {
        if (ids != null) {
            for (String id : ids) {
                dao.delete(id);
            }
        }
    }

    public List<Student> listByPage(String cid, String currentPage){
        return dao.listByPage(cid, (Integer.parseInt(currentPage)-1)*5);
    }

    public int count(String cid){ return dao.count(cid)/6 + 1; }

    //更新班级信息
    //更新班级（用上事务注解，表示开启事务）
    @Transactional
    public void update(Student student) {
        dao.update(student);
    }

}
