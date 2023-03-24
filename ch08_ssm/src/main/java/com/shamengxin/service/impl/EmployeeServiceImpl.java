package com.shamengxin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shamengxin.mapper.EmployeeMapper;
import com.shamengxin.pojo.Employee;
import com.shamengxin.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee() {
        List<Employee> list = employeeMapper.getAllEmployee();
        return list;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {

        PageHelper.startPage(pageNum,4);

        List<Employee> list = employeeMapper.getAllEmployee();

        PageInfo<Employee> page = new PageInfo<>(list,5);

        return page;
    }
}
