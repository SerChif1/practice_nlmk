package com.example.practiceNLMK.service;

import com.example.practiceNLMK.dto.GraphQlFilter;
import com.example.practiceNLMK.dto.ObjectsData;
import com.example.practiceNLMK.entity.ObjectsEntity;
import com.example.practiceNLMK.mapper.ObjectsMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectsService implements GraphQLQueryResolver {

    private final EntityManager entityManager;

    private final ObjectsMapper objectsMapper;

    public String test() {
        return "Test successful!";
    }

    public List<ObjectsData> getObjectsWithFilters(List<GraphQlFilter> filters) {
        System.out.println("Filters received: " + filters);
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObjectsEntity> query = cb.createQuery(ObjectsEntity.class);
        Root<ObjectsEntity> root = query.from(ObjectsEntity.class);

        if (filters != null) {
            for (GraphQlFilter filter : filters) {
                if (filter.getStringExpression() != null) {
                    if (filter.getStringExpression().getContains() != null) {
                        query.where(cb.like(root.get(filter.getField()), "%" + filter.getStringExpression()
                                                                                        .getContains() + "%"));
                    }
                }
            }
        }

        List<ObjectsEntity> entities = entityManager.createQuery(query).getResultList();

        return entities.stream().map(objectsMapper :: toDto).collect(Collectors.toList());
    }
}
