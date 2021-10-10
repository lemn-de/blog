package com.lemndo.blog.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lemndo.blog.utils.ImageUtils;
import com.lemndo.blog.utils.UploadGiteeImgBed;
import com.lemndo.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        //唯一文件名称，随机
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");


        /**
         * 图片压缩
         */
        byte[] yasuo = ImageUtils.commpressImage(file.getBytes(), 1024, 0.8);

        //上传码云的url
        String targetURL = UploadGiteeImgBed.createUploadFileUrl(originalFilename);

        //请求体封装
        Map<String, Object> uploadBodyMap = UploadGiteeImgBed.getUploadBodyMap(yasuo);
        String JSONResult = HttpUtil.post(targetURL, uploadBodyMap);
        //解析响应JSON字符串
        JSONObject jsonObj = JSONUtil.parseObj(JSONResult);

        //请求失败
        if(jsonObj == null || jsonObj.getObj("commit") == null){
            return Result.fail(20001, "上传失败");
        }
        JSONObject content = JSONUtil.parseObj(jsonObj.getObj("content"));
        return Result.success(content.getObj("download_url"));
    }
}
