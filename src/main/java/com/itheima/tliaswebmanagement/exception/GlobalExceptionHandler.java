package com.itheima.tliaswebmanagement.exception;

import com.itheima.tliaswebmanagement.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
全局异常处理器
 */
@RestControllerAdvice  // @RestControllerAdvice = @ControllerAdvice + @ResponseBody

public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class) // 捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
