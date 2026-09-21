package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.PageBean;

import java.util.List;

public interface EmpService {




    // List<Emp> list();
    PageBean page(Integer page, Integer pageSize);

    void delete(Integer id);

    void add(Emp emp) ;

    Emp getById(Integer id);

    void update(Emp emp);


}
