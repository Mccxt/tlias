package com.itheima.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.PageBean;
import com.itheima.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// 员工业务实现类
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    // 查询员工

    /* public PageBean page(Integer page, Integer pageSize) {
        // 记录总行数
        Long count = empMapper.count();
        // 获取分页查询结果
        Integer start = (page - 1)*pageSize; //计算起始索引 , 公式: (页码-1)*页大小
        List<Emp> empsList = empMapper.list(start,pageSize);
        // 封装PageBean对象
        PageBean pageBean = new PageBean(count,empsList);
        return pageBean;
    } */
    @Override
    public PageBean page(Integer page, Integer pageSize){
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        // 执行分页查询
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        // 封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(Integer id) {
        empMapper.delete(id);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        Emp oldEmp = empMapper.getById(emp.getId());
        if( oldEmp==null){
            throw new RuntimeException("要修改的员工不存在");
        }
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
