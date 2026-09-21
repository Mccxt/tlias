package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // 查询全部员工
    @Select("select * from emp")
    List<Emp> list();



    // 删除员工（根据id）
    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);

    // 添加员工
    @Insert("insert into emp(username,password,name,gender,image,job,entrydate,dept_id,create_time,update_time) values (#{username},#{password},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert (Emp emp);

    // 根据id查询员工
    @Select("select * from emp where id = #{id};")
    Emp getById(Integer id);

    // 修改员工
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime}where id=#{id}")
    void update(Emp emp);

}
