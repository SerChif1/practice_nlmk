package com.example.practiceNLMK.controllers;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ObjectsController  {

    private final ObjectsService objectsService;

    @QueryMapping
    public List<ObjectsData> getObjectsWithFilter(List<GraphQlFilter> filters) {
        System.out.println("Filters received: " + filters);
       return objectsService.getObjectsWithFilters(filters);
    }

    @QueryMapping
    public String test() {
        return objectsService.test();
    }
}
