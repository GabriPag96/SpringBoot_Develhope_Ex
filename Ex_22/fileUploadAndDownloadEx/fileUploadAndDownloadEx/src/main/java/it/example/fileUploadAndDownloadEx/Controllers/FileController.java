package it.example.fileUploadAndDownloadEx.Controllers;

import it.example.fileUploadAndDownloadEx.Services.FileStorageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws Exception{
        return fileStorageService.upload(file);
    }

    @PostMapping("/download")
    public byte[] download(@RequestParam MultipartFile file) throws Exception{

        return fileStorageService.download(String.valueOf(file));
    }

}
