package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, UUID> {
    UserProfileEntity findByEmail(String email);
}
