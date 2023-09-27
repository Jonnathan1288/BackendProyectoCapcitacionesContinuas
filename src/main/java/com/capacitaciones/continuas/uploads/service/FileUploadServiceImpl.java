package com.capacitaciones.continuas.uploads.service;

import com.capacitaciones.continuas.util.MethodsConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;


import static com.capacitaciones.continuas.uploads.constants.ConstantsNames.*;
@Service
public class FileUploadServiceImpl implements FileUploadService{
    //private final Path rootFolder = Paths.get(DOCUMENTS_EXEL);
    private Path rootFolder;
    @Override
    public String saveFile(MultipartFile file, String folder) throws IOException {
        String originalFileName = file.getOriginalFilename().replaceAll("\\s+", "");

        String uniqueFileName = UUID.randomUUID().toString() + "_" + MethodsConverter.normalizeFileName(originalFileName);

        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder + "/" + uniqueFileName);
        Files.write(path, bytes);

        return uniqueFileName;
    }



    @Override
    public Resource getUploadedFile(String fileName, String folder) throws IOException {
        this.rootFolder = Paths.get(FOLDER_MAPPING.get(folder));
        Path filePath = rootFolder.resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new FileNotFoundException("El archivo no se encontró: " + fileName);
        }
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        Path filePath = rootFolder.resolve(fileName);
        // Verifica si el archivo existe antes de eliminarlo
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        } else {
            throw new FileNotFoundException("El archivo no se encontró: " + fileName);
        }
    }

}

// Files.copy(file.getInputStream(), this.rootFolder.resolve(uniqueFileName));


/*
*  public FileUploadService() {

        if (!Files.exists(rootFolder)) {
            try {
                Files.createDirectories(rootFolder);
            } catch (IOException e) {
                throw new RuntimeException("No se pudo crear la carpeta de subida: " + rootFolder, e);
            }
        }
    }*/