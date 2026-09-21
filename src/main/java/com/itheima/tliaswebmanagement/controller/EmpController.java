package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.PageBean;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 员工管理控制器
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    // 查询员工
    /*
    @GetMapping("/emps")
    public Result list(){
        log.info("查询全部员工数据");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    } */
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        // 记录日志
        log.info("分页查询，参数：{},{}",page,pageSize);
        // 调用业务层分页查询功能
        PageBean pageBean = empService.page(page,pageSize);
        return Result.success(pageBean);
    }

    // 删除员工
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable("ids") Integer id){    // 里面的参数名应和 DeleteMapping里面的一样
        log.info("根据id 删除部门：{}",id);
        // 调用Service 删除
        empService.delete(id);
        return Result.success();
    }

    // 添加员工
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        // 调用Service添加
        empService.add(emp);
        return Result.success();
    }

    // 根据 id 查询员工
    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询id为：{} 的员工",id);
        Emp emp = empService.getById(id);
        // 调用Service查询
        return Result.success(emp);
    }
    // 修改员工
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("修改的员工id：{}",emp.getId());
        // 调用Sevice修改
        empService.update(emp);
        return Result.success();
    }



}
