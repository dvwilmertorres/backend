package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.knowledgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KnowledgeRepository extends JpaRepository<knowledgeEntity, UUID> {
}
