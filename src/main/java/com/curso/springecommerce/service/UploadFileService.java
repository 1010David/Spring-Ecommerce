package com.curso.springecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFileImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {

    public String saveImage(MultipartFileImpl file) throws IOException {
        if (file.isEmpty()){
            byte [] bytes=file.getBytes();
            String folder = "images//";
            Path path = Paths.get(folder + file);
            Files.write(path, bytes);
            return file.toString();
        }
        return "default.jpg";
    }

    public void deleteImage(String nameI){
        String rute="images//";
        File file= new File(rute+nameI);
        file.delete();

    }
}
