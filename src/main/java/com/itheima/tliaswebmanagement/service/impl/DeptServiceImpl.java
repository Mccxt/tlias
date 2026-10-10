package com.itheima.tliaswebmanagement.service.impl;

import com.itheima.tliaswebmanagement.mapper.DeptMapper;
import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Dept;
import com.itheima.tliaswebmanagement.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

// 部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id); // 根据id删除部门
        empMapper.deleteByDeptId(id); // 部门下的员工一并删除
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    // 根据id修改部门
    @Override
    public void update(Dept dept) { // 先逻辑处理判断要修改的是否存在
        Dept oldDept = deptMapper.getById(dept.getId());
        if(oldDept ==null){
            throw new RuntimeException("要修改的部门不存在");
        }

        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);

    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
}
