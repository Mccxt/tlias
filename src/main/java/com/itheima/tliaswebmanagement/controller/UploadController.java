package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名 {}",image.getOriginalFilename());
        //
        String url = aliOSSUtils.upload(image);
        log.info("上传成功，文件url为：{}",url);
        return  Result.success(url);
    }
}
