package com.yjj.controller;

import com.yjj.model.Klass;
import com.yjj.service.KlassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by pqr on 2018/7/13.
 */
@Controller
@RequestMapping("/klass")
public class KlassController {
    @Resource
    private KlassService klassService;

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) {
        return "klassAdd";
    }

    @RequestMapping("/save")
    public String save(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect) {
        String cname = request.getParameter("cname");
        String note = request.getParameter("note");
        if (cname == null || "".equals(cname) || note == null || "".equals(note)) {
            redirect.addAttribute("msg", "添加失败!参数不能为空");
            return "redirect:/klass/add";
        }
        Klass klass = new Klass();
        klass.setCid(UUID.randomUUID().toString());
        klass.setCname(cname);
        klass.setNote(note);
        klassService.insert(klass);
        redirect.addAttribute("msg", "添加班级成功");
        return "redirect:/klassList";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect) {
        String ids = request.getParameter("ids");
        if (ids == null) {
            return "没有选择任何班级";
        }
        String[] id_arr = ids.split("_");
        klassService.delete(id_arr);
        System.out.println(id_arr);
        redirect.addAttribute("msg", "删除班级成功");
        return "删除成功";
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request, HttpServletResponse response, Model model ) {
        String cid = request.getParameter("cid");
        if (cid == null) {
            return "klassList";
        }
        model.addAttribute("klass",klassService.get(cid));
        return "klassUpdate";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect, Model model, Klass klass) {
        String cid = klass.getCid();
        String cname = klass.getCname();
        String note = klass.getNote();
        if (cid == null || "".equals(cid) || cname == null || "".equals(cname) || note == null || "".equals(note)) {
            redirect.addAttribute("msg", "添加失败!参数不能为空");
        }else {
            klassService.update(klass);
            redirect.addAttribute("msg", "修改班级信息成功");
        }
        return "redirect:/klassList";
    }

}
