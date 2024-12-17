package com.example.practiceNLMK.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "parameter_values")
public class ParametrValuesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id", nullable = false)
    private ObjectsEntity object_id;

    @ManyToOne
    @JoinColumn(name = "parameter_id", referencedColumnName = "id", nullable = false)
    private ParametrsEntity parameter_id;

    private String value;

    @Column(name = "measured_at")
    private Timestamp measured_at;
}
