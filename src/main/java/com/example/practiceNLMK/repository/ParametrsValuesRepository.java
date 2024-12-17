package com.example.practiceNLMK.repository;

import com.example.practiceNLMK.entity.ParametrValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParametrsValuesRepository extends JpaRepository<ParametrValuesEntity, UUID> {
}
