package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.UserSesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSesionRepository extends JpaRepository<UserSesionEntity,Long> {
}
