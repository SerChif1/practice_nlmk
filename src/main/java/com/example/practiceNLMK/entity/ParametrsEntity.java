package com.example.practiceNLMK.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "parameters")
public class ParametrsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
}
