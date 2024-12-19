//package com.example.practiceNLMK.service.filters;
//
//import com.example.practiceNLMK.dto.GraphQlFilter;
//import com.example.practiceNLMK.dto.dto_expression.StringExpression;
//import com.example.practiceNLMK.entity.ObjectsEntity;
//import jakarta.persistence.criteria.Root;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//public class StringFilter implements Filter {
//
//    @Override
//    public List<Predicate> apply(Root<ObjectsEntity> root, CriteriaBuilder cb, GraphQlFilter filter) {
//        List<Predicate> predicates = new ArrayList<>();
//        StringExpression stringExpression = filter.getStringExpression();
//        String field = filter.getField();
//
//        if (stringExpression.getMultipleChoice() != null && !stringExpression.getMultipleChoice().isEmpty()) {
//            CriteriaBuilder.In<String> inClause = cb.in(root.get(field));
//            for (String choice : stringExpression.getMultipleChoice()) {
//                inClause.value(choice);
//            }
//            predicates.add(inClause);
//        }
//
//        if (stringExpression.getContains() != null) {
//            predicates.add(cb.like(root.get(field), "%" + stringExpression.getContains() + "%"));
//        }
//
//        if (stringExpression.getNotContains() != null) {
//            predicates.add(cb.notLike(root.get(field), "%" + stringExpression.getNotContains() + "%"));
//        }
//
//        if (stringExpression.getStartsWith() != null) {
//            predicates.add(cb.like(root.get(field), stringExpression.getStartsWith() + "%"));
//        }
//
//        if (stringExpression.getEndsWith() != null) {
//            predicates.add(cb.like(root.get(field), "%" + stringExpression.getEndsWith()));
//        }
//        if (stringExpression.getEqual() != null) {
//            predicates.add(cb.equal(root.get(field), stringExpression.getEqual()));
//        }
//
//        if (stringExpression.getNotEqual() != null) {
//            predicates.add(cb.notEqual(root.get(field), stringExpression.getNotEqual()));
//        }
//
//        return predicates;
//    }
//}
//
