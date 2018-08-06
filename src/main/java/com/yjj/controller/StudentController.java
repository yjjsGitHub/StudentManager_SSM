package com.yjj.controller;

import com.yjj.model.Student;
import com.yjj.service.KlassService;
import com.yjj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private KlassService klassService;

    @RequestMapping("/get")
    public String getById(HttpServletRequest request, HttpServletResponse response, Model model) {
        String sid = request.getParameter("sid");
        if (sid == null) {
            return "klassList";
        }
        model.addAttribute("student",studentService.get(sid));
        return "studentUpdate";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        //判断登录
        if (request.getSession().getAttribute("email") == null) {
            return "redirect:/login";
        }
        String cid = request.getParameter("cid");
        if (cid == null || "".equals(cid)) {
            return "redirect:/index";
        }
        model.addAttribute("studentList", studentService.list(cid));
        model.addAttribute("klass", klassService.get(cid));
        return "studentList";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("klassList", klassService.list());
        return "studentAdd";
    }

    @RequestMapping("/save")
    public String save(Student student, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect) {
        if (student == null || student.getName() == null || "".equals(student.getName())) {
            redirect.addAttribute("msg", "缺少姓名字段");
            return "redirect:/student/add";
        }
        student.setSid(UUID.randomUUID().toString());
        studentService.save(student);
        redirect.addAttribute("msg", "添加学生成功");
        return "redirect:/klassList";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");

        System.out.println("stuIds:"+ids);
        if (ids == null) {
            return "没有选择任何学生";
        }
        String[] id_arr = ids.split("_");
        studentService.delete(id_arr);
        System.out.println(id_arr);
        return "删除成功";
    }

    @RequestMapping("/listByPage")
    public String listByPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        //判断登录
        if (request.getSession().getAttribute("email") == null) {
            return "redirect:/login";
        }
        String cid = request.getParameter("cid");
        String currentPage = request.getParameter("currentPage");
        if (cid == null || "".equals(cid) || currentPage == null || "".equals(currentPage)) {
            return "redirect:/klassList";
        }
        model.addAttribute("studentList", studentService.listByPage(cid, currentPage));
        model.addAttribute("klass", klassService.get(cid));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageCount", studentService.count(cid));
        return "studentList";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect, Student student) {
        String sid = student.getSid();
        String cid = student.getCid();
        String name = student.getName();
        String address = student.getAddress();
        System.out.println(student.toString());
        if (sid == null || "".equals(sid) ||cid == null || "".equals(cid) || name == null || "".equals(name) || address == null || "".equals(address)) {
            redirect.addAttribute("msg", "添加失败!参数不能为空");
        }else {
            studentService.update(student);
            redirect.addAttribute("msg", "修改学生信息成功");
        }
        return "redirect:/klassList";
    }
}
