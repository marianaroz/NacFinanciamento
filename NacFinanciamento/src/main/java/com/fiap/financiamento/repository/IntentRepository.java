package com.fiap.financiamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.financiamento.entity.IntentEntity;

@Repository
public interface IntentRepository extends JpaRepository<IntentEntity, Long> {
}
