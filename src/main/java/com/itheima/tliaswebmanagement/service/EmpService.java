package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {




    // List<Emp> list();
    PageBean page(Integer page, Integer pageSize, String name, Short gender,  LocalDate begin,  LocalDate end);

    void delete(Integer id);

    void add(Emp emp) ;

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
