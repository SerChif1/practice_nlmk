package com.example.practiceNLMK.service.filters;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.entity.ObjectsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.function.Predicate;

public interface Filter {
    List<Predicate> apply(Root<ObjectsEntity> root, CriteriaBuilder cb, GraphQlFilter filter);
}
