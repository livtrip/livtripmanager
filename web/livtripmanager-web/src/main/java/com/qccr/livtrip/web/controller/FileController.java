package com.qccr.livtrip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件控制器
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/19 16:36 Exp $$
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController{

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public void addFile(MultipartFile img){
        System.out.println("add file"+ img.getOriginalFilename());
    }


}
