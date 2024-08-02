package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.CredentialEntity;
import com.appmatch.msusuarios.entity.UserSesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialEntity, UUID> {
}
