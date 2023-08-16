package com.capacitaciones.continuas.controllers.documents;

import com.capacitaciones.continuas.Dtos.ListApproved;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import com.capacitaciones.continuas.util.ExporterExcel;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ExelController {

    private ParticipantesMatriculadosService participantesMatriculadosService;

    @Autowired
    public ExelController(ParticipantesMatriculadosService participantesMatriculadosService){
        this.participantesMatriculadosService = participantesMatriculadosService;
    }

    @PostMapping("/generate/exportExcel")
    public void exporrListOfParticipantsApprovedExcel(@RequestBody List<Integer> codeId, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=ParticipantesAprovados_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<Integer> data = Arrays.asList(1,2,9);

        List<ListApproved> findList = participantesMatriculadosService.findALlParticipantesAprovadosByIdCursos(codeId);

        ExporterExcel exporter = new ExporterExcel(findList);
        exporter.exportDataExel(response);
    }
}
