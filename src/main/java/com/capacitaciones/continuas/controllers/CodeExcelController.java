package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.CodeExcel;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.dtos.CodeExcelDto;
import com.capacitaciones.continuas.dtos.CodeExcelGetDto;
import com.capacitaciones.continuas.interfaces.CodesExcelUser;
import com.capacitaciones.continuas.services.CodeExcelService;
import com.capacitaciones.continuas.util.MethodsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CodeExcelController {
    private CodeExcelService codeExcelService;

    @Autowired
    public CodeExcelController(CodeExcelService codeExcelService){
        this.codeExcelService = codeExcelService;

    }

    @GetMapping("/codeExcel/findbyUserId/{id}")
    public ResponseEntity<List<CodeExcelGetDto>> getCodeExcelById(@PathVariable("id") Integer id){
        try {
            List<CodesExcelUser> codeExcels = codeExcelService.findCodesExcelByUsuarioIdUsuario(id);
            List<CodeExcelGetDto> filer = new ArrayList<>();

            for (CodesExcelUser t:codeExcels) {
                CodeExcelGetDto codeExcelDto = new CodeExcelGetDto();
                codeExcelDto.setIdCodeExel(t.getidCodeExel());
                codeExcelDto.setCodigosCourseExcel(MethodsConverter.convertStringToList(t.getcodigosCourseExcel()));
                codeExcelDto.setNombreDocumentoExcel(t.getnombreDocumentoExcel());
                codeExcelDto.setStatusCodeExcel(t.getstatusCodeExcel());
                codeExcelDto.setIdUsuario(t.getidUsuario());
                filer.add(codeExcelDto);
            }
            return new ResponseEntity<>(filer, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/codeExcel/save")
    public ResponseEntity<?> saveCodeExcel(@RequestBody CodeExcelDto codeExcel){
        try {
            CodeExcel codeExcel1 = new CodeExcel(
                    codeExcel.getNombreDocumentoExcel(),
                    MethodsConverter.listToString(codeExcel.getCodigosCourseExcel()),
                    codeExcel.getStatusCodeExcel(),
                    codeExcel.getUsuario());

            CodeExcel savedCodeExcel  = codeExcelService.save(codeExcel1);

            codeExcel.setIdCodeExel(savedCodeExcel.getIdCodeExel());
            return new ResponseEntity<>(codeExcel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/codeExcel/update/{id}")
    public ResponseEntity<CodeExcel> updateCodeExcel(@PathVariable Integer id, @RequestBody CodeExcel ce) {
        try {
            if (codeExcelService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(ce, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


   /* public String listToString(List<Integer> lista) {
        StringJoiner joiner = new StringJoiner(",");
        for (Integer elemento : lista) {
            joiner.add(elemento.toString());
        }
        return joiner.toString();
    }

    public List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }*/


   /* private String listToString(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return lista.stream().map(String::valueOf).collect(Collectors.joining(","));
    }*/
}
