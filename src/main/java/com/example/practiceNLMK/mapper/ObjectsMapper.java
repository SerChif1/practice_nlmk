package com.example.practiceNLMK.mapper;

import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.entity.ObjectsEntity;
import org.springframework.stereotype.Component;

@Component
public class ObjectsMapper {

    public ObjectsData toDto(ObjectsEntity entity) {
        if (entity == null) {
            return null;
        }

        ObjectsData dto = new ObjectsData();
        dto.setObjectName(entity.getName());
        dto.setObjectLength(entity.getLength().doubleValue());
        dto.setObjectWidth(entity.getWidth().doubleValue());
        dto.setObjectWeight(entity.getWeight());
        dto.setObjectProductionYear(entity.getProduction_year());
        return dto;
    }
}
