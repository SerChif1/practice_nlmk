package com.example.practiceNLMK.controllers;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.service.ExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/objects")
@RequiredArgsConstructor
public class ObjectsControllerExport {

    private final ExportService exportService;

    @PostMapping("/export")
    public ResponseEntity<byte[]> exportToExcel(@RequestBody List<GraphQlFilter> filters) {
        try {
            byte[] bytes = exportService.exportToExcel(filters);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=objects_data.xlsx");

            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
