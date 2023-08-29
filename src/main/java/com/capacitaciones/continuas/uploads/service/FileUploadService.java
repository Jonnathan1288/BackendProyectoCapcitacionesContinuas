package com.capacitaciones.continuas.uploads.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileUploadService {
    String saveFile(MultipartFile file, String folder) throws IOException;

    public Resource getUploadedFile(String fileName, String folder) throws IOException ;

    public void deleteFile(String fileName) throws IOException ;

}
