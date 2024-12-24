package com.example.practiceNLMK.service;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.dto.ObjectsData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExportService {

    private final ObjectsService objectsService;

    public ExportService(ObjectsService objectsService) {
        this.objectsService = objectsService;
    }

    public byte[] exportToExcel(List<GraphQlFilter> filters) throws IOException {
        List<ObjectsData> objectsData = objectsService.getObjectsWithFilters(filters);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Objects Data");

            // Создание заголовков
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Length");

            // Заполнение данными
            int rowNum = 1;
            for (ObjectsData data : objectsData) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(data.getObjectName());
                row.createCell(1).setCellValue(data.getObjectLength());

            }

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

}
