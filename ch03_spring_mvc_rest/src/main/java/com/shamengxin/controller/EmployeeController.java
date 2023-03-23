package com.shamengxin.controller;

import com.shamengxin.dao.EmployeeDao;
import com.shamengxin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 查询所有的员工信息-->/employee-->get
 * 跳转到添加页面-->/to/add-->get
 * 新增员工信息-->/employee-->post
 * 跳转到修改页面-->/employee/1-->put
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        //获取所有员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployee);
        //跳转到列表页面
        return "employee_list";
    }
    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能页面：/employee
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据id查询需要修改员工的信息
        Employee employee = employeeDao.get(id);
        //将查询出来的员工信息共享到请求域中
        model.addAttribute("employee",employee);
        //跳转到employee_update.html
        return "employee_update";
    }

    @PutMapping("/employee")
    public String UpdateEmployee(Employee employee){
        //修改员工信息
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String DeleteEmployee(@PathVariable("id") Integer id){
        //删除员工信息
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
