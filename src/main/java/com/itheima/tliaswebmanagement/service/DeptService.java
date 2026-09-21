package com.itheima.tliaswebmanagement.service;


import com.itheima.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {
    // 查询全部部门数据
    List<Dept> list();

    // 删除部门
    void delete(Integer id);

    // 增加部门
    void add(Dept dept);

    // 修改部门
    void update(Dept dept);

    // 修改时查询部门
    Dept getById(Integer id);
}
