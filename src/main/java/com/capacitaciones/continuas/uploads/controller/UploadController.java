package com.capacitaciones.continuas.uploads.controller;

import com.capacitaciones.continuas.uploads.service.FileUploadService;
import com.capacitaciones.continuas.uploads.service.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;

import static com.capacitaciones.continuas.uploads.constants.ConstantsNames.DOCUMENTS_EXEL;
import static com.capacitaciones.continuas.uploads.constants.ConstantsNames.FOLDER_MAPPING;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UploadController {

    private final FileUploadService fileUploadService;

    @Autowired
    public UploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("folder") String folder) {
        try {
            String folderPath = FOLDER_MAPPING.get(folder);

            if (folderPath == null) {
                return new ResponseEntity<>("Path not found", HttpStatus.BAD_REQUEST);
            }

            Map<String, String> response = new HashMap<>();
            String fileName = fileUploadService.saveFile(file, folderPath);
            response.put("key", fileName);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/upload/{fileName:.+}/{folder}")
    public ResponseEntity<Resource> getUploadedFile(@PathVariable("fileName") String fileName, @PathVariable("folder") String folder) {
        try {
           Resource resource = fileUploadService.getUploadedFile(fileName, folder);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/uploadUri/{fileName:.+}/{folder}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName, @PathVariable("folder") String folder) {
        try {
            Resource resource = fileUploadService.getUploadedFile(fileName,  folder);
            String contentType = Files.probeContentType(Paths.get(resource.getURI()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("upload/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        try {
            fileUploadService.deleteFile(fileName);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Err: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PostMapping("/subir")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        if (image.getSize() > MAX_IMAGE_SIZE) {
            throw new RuntimeException("La imagen es demasiado grande. El tamaño máximo permitido es de " + MAX_IMAGE_SIZE + " bytes.");
        }
        byte[] bytes = image.getBytes();
        Path path = Paths.get(DIRECTORY + "/" + image.getOriginalFilename());
        Files.write(path, bytes);
    }


    @GetMapping("/images/{imageName}")
    public byte[] getImagen(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(DIRECTORY + "/" + imageName);
        return Files.readAllBytes(path);
    }*/


}
