package cn.com.zhirun.ssm0514.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class MyFileController {

    // 单文件上传
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") CommonsMultipartFile tempFile, String username) {
        System.out.println("OriginalFilename：" + tempFile.getOriginalFilename());
        System.out.println("Name：" + tempFile.getName());
        System.out.println("StorageDescription：" + tempFile.getStorageDescription());
        System.out.println("Size：" + tempFile.getSize());

        try {
            FileUtils.copyInputStreamToFile(tempFile.getInputStream(), new File("E:\\" + tempFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "result";
    }

    // 多文件上传
    @RequestMapping("/uploadFiles")
    public String uploadFile(@RequestParam("file") CommonsMultipartFile[] tempFile, String username) {
        for (CommonsMultipartFile cmf : tempFile) {
            System.out.println("OriginalFilename：" + cmf.getOriginalFilename());
            System.out.println("Name：" + cmf.getName());
            System.out.println("StorageDescription：" + cmf.getStorageDescription());
            System.out.println("Size：" + cmf.getSize());

            try {
                FileUtils.copyInputStreamToFile(cmf.getInputStream(), new File("E:\\" + cmf.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "result";
    }

    @RequestMapping("/fileDownload")
    public void fileDownload(String fileName, HttpServletResponse response) {
        File file = new File("E:\\" + fileName);
//        File file = new File("E:\\电影.txt");
        try {
            response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            FileUtils.copyFile(file, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
