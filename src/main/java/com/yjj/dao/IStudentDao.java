package com.yjj.dao;

import com.yjj.model.Student;

import java.util.List;

public interface IStudentDao {

    Student get(String sid);

    List<Student> list(String cid);

    List<Student> listByPage(String cid, int currentPage );

    void insert(Student student);

    void update(Student student);

    void delete(String sid);

    int count(String cid);

}
