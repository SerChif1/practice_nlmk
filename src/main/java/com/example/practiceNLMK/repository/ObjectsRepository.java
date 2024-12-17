package com.example.practiceNLMK.repository;

import com.example.practiceNLMK.entity.ObjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ObjectsRepository extends JpaRepository<ObjectsEntity, UUID> {

    Optional<ObjectsEntity> findById(UUID id);
}
