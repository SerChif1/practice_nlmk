package com.example.practiceNLMK.service;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.dto.dto_expression.IntegerExpression;
import com.example.practiceNLMK.dto.dto_expression.LongExpression;
import com.example.practiceNLMK.dto.dto_expression.StringExpression;
import com.example.practiceNLMK.entity.ObjectsEntity;
import com.example.practiceNLMK.mapper.ObjectsMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectsService implements GraphQLQueryResolver {

    private final EntityManager entityManager;

    private final ObjectsMapper objectsMapper;

    public List<ObjectsData> getObjectsWithFilters(List<GraphQlFilter> filters) {
        System.out.println("СЕРВИС: getObjectsWithFilters сработал");
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObjectsEntity> query = cb.createQuery(ObjectsEntity.class);
        Root<ObjectsEntity> root = query.from(ObjectsEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filters != null) {
            for (GraphQlFilter filter : filters) {
                //СТРОКОВЫЙ ФИЛЬТР
                if (filter.getStringExpression() != null) {
                    StringExpression stringExpression = filter.getStringExpression();
                    String field = filter.getField();

                    if(stringExpression.getMultipleChoice() != null && !stringExpression.getMultipleChoice().isEmpty()) {
                        CriteriaBuilder.In<String> inClause = cb.in(root.get(field));
                        for (String choice : stringExpression.getMultipleChoice()) {
                            inClause.value(choice);
                        }
                        predicates.add(inClause);
                    }

                    if (stringExpression.getContains() != null) {
                        predicates.add(cb.like(root.get(field), "%" + stringExpression.getContains() + "%"));
                    }

                    if (stringExpression.getNotContains() != null) {
                        predicates.add(cb.notLike(root.get(field), "%" + stringExpression.getNotContains() + "%"));
                    }
                    if (stringExpression.getStartsWith() != null) {
                        predicates.add(cb.like(root.get(field), stringExpression.getStartsWith() + "%"));
                    }

                    if (stringExpression.getEndsWith() != null) {
                        predicates.add(cb.like(root.get(field), "%" + stringExpression.getEndsWith()));
                    }

                    if (stringExpression.getEqual() != null) {
                        predicates.add(cb.equal(root.get(field), stringExpression.getEqual()));
                    }

                    if (stringExpression.getNotEqual() != null) {
                        predicates.add(cb.notEqual(root.get(field), stringExpression.getNotEqual()));
                    }
                }

                // ИНТОВЫЙ ЦЕЛОЧИСЛЕННЫЙ ФИЛЬТР
                if (filter.getIntegerExpression() != null) {
                    IntegerExpression integerExpression = filter.getIntegerExpression();
                    String field = filter.getField();

                    if (integerExpression.getMultipleChoice() != null && !integerExpression.getMultipleChoice().isEmpty()) {
                        CriteriaBuilder.In<Integer> inClause = cb.in(root.get(field));
                        for (Integer choice : integerExpression.getMultipleChoice()) {
                            inClause.value(choice);
                        }
                        predicates.add(inClause);
                    }

                    if (integerExpression.getEqual() != null) {
                        predicates.add(cb.equal(root.get(field), integerExpression.getEqual()));
                    }

                    if (integerExpression.getNotEqual() != null) {
                        predicates.add(cb.notEqual(root.get(field), integerExpression.getNotEqual()));
                    }

                    if (integerExpression.getGreaterThan() != null) {
                        predicates.add(cb.greaterThan(root.get(field), integerExpression.getGreaterThan()));
                    }

                    if (integerExpression.getGreaterThanOrEqual() != null) {
                        predicates.add(cb.greaterThanOrEqualTo(root.get(field), integerExpression.getGreaterThanOrEqual()));
                    }

                    if (integerExpression.getLessThan() != null) {
                        predicates.add(cb.lessThan(root.get(field), integerExpression.getLessThan()));
                    }

                    if (integerExpression.getLessThanOrEqual() != null) {
                        predicates.add(cb.lessThanOrEqualTo(root.get(field), integerExpression.getLessThanOrEqual()));
                    }

                    if (integerExpression.getBetween() != null && integerExpression.getBetween().size() == 2) {
                        predicates.add(cb.between(root.get(field), integerExpression.getBetween().get(0), integerExpression.getBetween().get(1)));
                    }
                }

                // ЛОНГОВЫЙ ЦЕЛОЧИСЛЕННЫЙ ФИЛЬТР
                if (filter.getLongExpression() != null) {
                    LongExpression longExpression = filter.getLongExpression();
                    String field = filter.getField();

                    if (longExpression.getMultipleChoice() != null && !longExpression.getMultipleChoice().isEmpty()) {
                        CriteriaBuilder.In<Long> inClause = cb.in(root.get(field));
                        for (Long choice : longExpression.getMultipleChoice()) {
                            inClause.value(choice);
                        }
                        predicates.add(inClause);
                    }

                    if (longExpression.getEqual() != null) {
                        predicates.add(cb.equal(root.get(field), longExpression.getEqual()));
                    }

                    if (longExpression.getNotEqual() != null) {
                        predicates.add(cb.notEqual(root.get(field), longExpression.getNotEqual()));
                    }

                    if (longExpression.getGreaterThan() != null) {
                        predicates.add(cb.greaterThan(root.get(field), longExpression.getGreaterThan()));
                    }

                    if (longExpression.getGreaterThanOrEqual() != null) {
                        predicates.add(cb.greaterThanOrEqualTo(root.get(field), longExpression.getGreaterThanOrEqual()));
                    }

                    if (longExpression.getLessThan() != null) {
                        predicates.add(cb.lessThan(root.get(field), longExpression.getLessThan()));
                    }

                    if (longExpression.getLessThanOrEqual() != null) {
                        predicates.add(cb.lessThanOrEqualTo(root.get(field), longExpression.getLessThanOrEqual()));
                    }

                    if (longExpression.getBetween() != null && longExpression.getBetween().size() == 2) {
                        predicates.add(cb.between(root.get(field), longExpression.getBetween().get(0), longExpression.getBetween().get(1)));
                    }
                }
            }
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        List<ObjectsEntity> entities = entityManager.createQuery(query).getResultList();

        return entities.stream()
                .flatMap(entity -> objectsMapper.toDto(entity).stream())
                .collect(Collectors.toList());
    }
}
