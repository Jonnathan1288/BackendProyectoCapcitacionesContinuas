package com.capacitaciones.continuas.util;

import com.capacitaciones.continuas.Dtos.ListApproved;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFFont;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ExporterExcel {
    private Integer aux = 0;
    private Integer auxIdCurso = null;
    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<ListApproved> listApprovedI;



    public ExporterExcel(List<ListApproved> listApprovedI) {
        this.listApprovedI = listApprovedI;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("ParticipantesAprovados");
    }

    private void escribirCabeceraDeTabla() {
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("No.");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("NOMBRES Y APELLIDOS");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("CÓDIGO");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("CURSO");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("FECHA");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("HORAS");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("DOCENTE");
        celda.setCellStyle(estilo);

    }

    private void writeInTheTable() {
        int numberRow = 1;

        Map<Integer, XSSFColor> idsColorMap = new HashMap<>();

        Random rand = new Random();

        for(ListApproved empleado : listApprovedI) {
            Row fila = hoja.createRow(numberRow ++);

            CellStyle estiloP = libro.createCellStyle();
            XSSFFont fuenteP = libro.createFont();

            fuenteP.setFontHeight(14);

            int idCurso = empleado.getidCurso();
            XSSFColor fontColor = idsColorMap.get(idCurso);

            if(fontColor == null){
                fontColor = new XSSFColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                idsColorMap.put(idCurso, fontColor);

            }

            fuenteP.setColor(fontColor);
            estiloP.setFont(fuenteP);


            Cell celda = fila.createCell(0);
            celda.setCellValue(validateNumber(empleado.getidCurso()));
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estiloP);


            celda = fila.createCell(1);
            celda.setCellValue(empleado.getnombres().toUpperCase());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estiloP);

            celda = fila.createCell(2);
            celda.setCellValue("");
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estiloP);

            celda = fila.createCell(3);
            celda.setCellValue(empleado.getcurso().toUpperCase());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estiloP);

            celda = fila.createCell(4);
            celda.setCellValue(parseDateToStringCalendar(empleado.getfechaInicio().toString(), empleado.getfechaFin().toString()));
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estiloP);

            celda = fila.createCell(5);
            celda.setCellValue(empleado.gethoras());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estiloP);

            celda = fila.createCell(6);
            celda.setCellValue(empleado.getdocente());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estiloP);

        }


    }

    public Integer validateNumber(Integer idCurso){
        aux = (auxIdCurso != null  && auxIdCurso.equals(idCurso)) ? aux + 1: 1;
        auxIdCurso = idCurso;
        return  aux;
    }

    public String parseDateToStringCalendar(String fechaInicio, String fechaFin) {
        String[] meses = {
                "enero", "febrero", "marzo", "abril", "mayo", "junio",
                "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicioObj = LocalDate.parse(fechaInicio, inputFormatter);
        LocalDate fechaFinObj = LocalDate.parse(fechaFin, inputFormatter);

        String fechaInicioStr = String.format("%d de %s", fechaInicioObj.getDayOfMonth(), meses[fechaInicioObj.getMonthValue() - 1]);
        String fechaFinStr = String.format("%d de %s, %d", fechaFinObj.getDayOfMonth(), meses[fechaFinObj.getMonthValue() - 1], fechaFinObj.getYear());

        return fechaInicioStr + " al " + fechaFinStr;
    }

    public void exportDataExel(HttpServletResponse response) throws IOException {
        escribirCabeceraDeTabla();
        writeInTheTable();

        ServletOutputStream outPutStream = response.getOutputStream();
        libro.write(outPutStream);

        libro.close();
        outPutStream.close();
    }


}



//CellStyle estiloP = libro.createCellStyle();
// XSSFFont fuenteP = libro.createFont();

//        fuenteP.setColor(IndexedColors.BLUE.getIndex());
// fuenteP.setFontHeight(14);
// estiloP.setFont(fuenteP);

//CellStyle estiloP = libro.createCellStyle();
// XSSFFont fuenteP = libro.createFont();

//        fuenteP.setColor(IndexedColors.BLUE.getIndex());
// fuenteP.setFontHeight(14);
// estiloP.setFont(fuenteP);

//  estilo.setFill(IndexedColors.BLUE.getIndex());//
// estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);