package com.example.practiceNLMK.mapper;

import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.entity.ObjectsEntity;
import com.example.practiceNLMK.entity.ParametrValuesEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectsMapper {

    public List<ObjectsData> toDto(ObjectsEntity entity) {
        if (entity == null) {
            return null;
        }

        List<ObjectsData> dtos = new ArrayList<>();

        if (entity.getParameterValues() != null) {
            for (ParametrValuesEntity parameterValue : entity.getParameterValues()) {
                ObjectsData parameterDto = new ObjectsData();
                parameterDto.setObjectName(entity.getName());
                parameterDto.setObjectLength(entity.getLength().doubleValue());
                parameterDto.setObjectWidth(entity.getWidth().doubleValue());
                parameterDto.setObjectWeight(entity.getWeight());
                parameterDto.setObjectProductionYear(entity.getProduction_year());
                parameterDto.setParameterName(parameterValue.getParameter_id().getName());
                parameterDto.setValue(parameterValue.getValue());
                String measuredAtString = parameterValue.getMeasured_at().toString();
                measuredAtString = measuredAtString.replace(" ", "T");
                parameterDto.setMeasuredAt(LocalDateTime.parse(measuredAtString));

                dtos.add(parameterDto);
            }
        } else {
            ObjectsData dto = new ObjectsData();
            dto.setObjectName(entity.getName());
            dto.setObjectLength(entity.getLength().doubleValue());
            dto.setObjectWidth(entity.getWidth().doubleValue());
            dto.setObjectWeight(entity.getWeight());
            dto.setObjectProductionYear(entity.getProduction_year());
            dtos.add(dto);
        }
        return dtos;
    }
}
