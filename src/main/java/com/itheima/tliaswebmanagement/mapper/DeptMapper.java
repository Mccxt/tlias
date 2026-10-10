package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    // 查询全部部门
    @Select("SELECT * from dept")
    List<Dept> list();

    // 删除部门
    @Delete("delete * from dept where id = #{id}")
    void deleteById(Integer id);

    // 增加部门
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    // 修改部门前的查询
    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);

    // 修改部门
    @Update("update dept set name = #{name},update_time = #{updateTime}where id = #{id}")
    void update(Dept dept);
}
