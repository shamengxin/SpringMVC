package com.shamengxin.controller;

import com.shamengxin.pojo.User;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id:"+requestBody);
        response.getWriter().println("hello,axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map , HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().println("hello,RequestBody");
    }

    public void testRequestBody(@RequestBody User user , HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().println("hello,RequestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001,"admin","12334",20,"男");
        User user2 = new User(1002,"admin","12334",20,"男");
        User user3 = new User(1003,"admin","12334",20,"男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
    /*public Map<String,Object> testResponseBodyJson(){
        User user1 = new User(1001,"admin","12334",20,"男");
        User user2 = new User(1002,"admin","12334",20,"男");
        User user3 = new User(1003,"admin","12334",20,"男");
        Map<String ,Object> map = new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);
        return map;
    }*/
    /*public User testResponseBodyJson(){
        User user = new User(1001,"admin","12334",20,"男");
        return user;
    }*/

}
