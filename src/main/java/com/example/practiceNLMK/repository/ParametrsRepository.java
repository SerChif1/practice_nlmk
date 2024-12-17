package com.example.practiceNLMK.repository;

import com.example.practiceNLMK.entity.ParametrsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ParametrsRepository extends JpaRepository<ParametrsEntity, UUID> {
}
