package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, UUID> {
}
