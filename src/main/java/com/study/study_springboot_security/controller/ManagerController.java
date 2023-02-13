package com.study.study_springboot_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {

    @GetMapping({ "/admin/*" }) // ROLE_ADMIN - 상위 개념
    public ModelAndView admin(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/admin/read.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @GetMapping({ "/manager/*" }) // ROLE_MANAGER
    public ModelAndView manager(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/admin/read.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}