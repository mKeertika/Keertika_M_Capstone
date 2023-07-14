//package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;
//
//import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostImage;
//import org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments.IPostImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//
//@Controller
//public class PostImageController {
//
//    @Autowired
//    private IPostImageService imgService;
//
//
//    @PostMapping("/upload-image")
//    public String uploadPostImage(@RequestParam("imageFile")MultipartFile imageFile) throws IOException {
//        PostImage postImage = new PostImage();
//        String filePath="../static/images/";
//        String filename= UUID.randomUUID()+"-"+imageFile.getOriginalFilename();
//        String fullPath = filePath + filename;
//        postImage.setFilePath(fullPath);
//
//        File file = new File(fullPath);
//        imageFile.transferTo(file);
////        save image in db
//        imgService.savePostImage(postImage);
//
//        return "/index";
//
//    }
//
//}
