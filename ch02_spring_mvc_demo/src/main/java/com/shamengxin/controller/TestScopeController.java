package com.shamengxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAN(){

        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope","hello,ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,Session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
