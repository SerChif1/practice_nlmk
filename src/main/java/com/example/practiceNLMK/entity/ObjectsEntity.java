package com.example.practiceNLMK.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "objects")
@Getter
@Setter
public class ObjectsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(precision = 10, scale = 2)
    private BigDecimal length;

    @Column(precision = 10, scale = 2)
    private BigDecimal width;

    private Long weight;

    private Integer production_year;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParametrValuesEntity> parameterValues;
}
