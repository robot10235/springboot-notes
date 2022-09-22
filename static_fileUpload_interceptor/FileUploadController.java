package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());

        // get server work path
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);
        return "upload successfully";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);

        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(path+photo.getOriginalFilename());
        // save photo to file path and name is the original name
        photo.transferTo(file);
    }
}
