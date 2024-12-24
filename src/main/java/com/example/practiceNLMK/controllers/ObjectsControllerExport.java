package com.example.practiceNLMK.controllers;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ObjectsControllerExport {

    private final ObjectsService objectsService;

    @PostMapping("/objects/export")
    public ResponseEntity<byte[]> exportObjectsToExcel(@RequestBody List<GraphQlFilter> filters) throws IOException {
        List<ObjectsData> objectsData = objectsService.getObjectsWithFilters(filters);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Objects Data");

        // Заголовки
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Object Name");
        headerRow.createCell(1).setCellValue("Object Length");
        headerRow.createCell(2).setCellValue("Object Width");
        headerRow.createCell(3).setCellValue("Object Weight");
        headerRow.createCell(4).setCellValue("Production Year");
        headerRow.createCell(5).setCellValue("Parameter Name");
        headerRow.createCell(6).setCellValue("Value");
        headerRow.createCell(7).setCellValue("Measured At");

        CellStyle dateCellStyle = workbook.createCellStyle();
        DataFormat dateFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dateFormat.getFormat("yyyy-mm-dd hh:mm:ss"));

        int rowNum = 1;
        for (ObjectsData data : objectsData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getObjectName());
            row.createCell(1).setCellValue(data.getObjectLength());
            row.createCell(2).setCellValue(data.getObjectWidth());
            row.createCell(3).setCellValue(data.getObjectWidth());
            row.createCell(4).setCellValue(data.getObjectProductionYear());
            row.createCell(5).setCellValue(data.getParameterName());
            row.createCell(6).setCellValue(data.getValue());
            Cell measuredAtCell = row.createCell(7);
            measuredAtCell.setCellValue(data.getMeasuredAt());
            measuredAtCell.setCellStyle(dateCellStyle);

        }

        String filename = "docs/objects_data" + UUID.randomUUID() + ".xls";
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            workbook.write(fileOut);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=objects_data.xlsx");

        String msg = "Файл " + filename + " успешно создан" ;
        return new ResponseEntity<>(msg.getBytes(StandardCharsets.UTF_8), headers, HttpStatus.OK);
    }
}
