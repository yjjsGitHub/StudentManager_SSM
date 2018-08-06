package com.yjj.dao;

import com.yjj.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class StudentDaoTest {

    @Autowired
    private StudentDao dao;

    @Test
    public void testGet() throws Exception {
        String sid = "123";
        Student student = dao.get(sid);
        System.out.println(student == null);
    }
}
