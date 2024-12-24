package com.example.practiceNLMK.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "parameters")
@Getter
@Setter
public class ParametrsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "parameter_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParametrValuesEntity> parameterValues;
}
