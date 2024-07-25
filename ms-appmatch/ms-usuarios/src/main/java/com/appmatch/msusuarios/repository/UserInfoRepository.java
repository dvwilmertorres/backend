package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Long> {
    Optional<UserInfoEntity> findByDocument(String document);
}
