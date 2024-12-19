package com.example.practiceNLMK.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ObjectsData {
    private String objectName;
    private Double objectLength;
    private Double objectWidth;
    private Long objectWeight;
    private Integer objectProductionYear;
    private String parameterName;
    private String value;
    private LocalDateTime measuredAt;
}
