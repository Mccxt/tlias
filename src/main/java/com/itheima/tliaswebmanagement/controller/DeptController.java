package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Dept;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理控制器
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    // private static Logger log = LoggerFactory.getLogger(DeptController.class);

    // 查询部门
    @GetMapping ("/depts")
    public Result list(){
        log.info("查询全部部门数据");
        // Service
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    // 删除部门
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) throws Exception{
        log.info("根据id 删除部门：{}",id);
        // 调用Service删除部门
        deptService.delete(id);

        return Result.success();
    }

    // 新增部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        // 调用Service新增部门
        deptService.add(dept);
        return Result.success();
    }

    // 修改部门前根据ID查询部门
    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询部门：{}", id);
        // 调用Service查询部门
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    // 修改部门
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("修改部门的id：{}",dept.getId());
        // 调用Service修改部
        deptService.update(dept);
        return Result.success();
    }

}
