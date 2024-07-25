package com.appmatch.msusuarios.repository;

import com.appmatch.msusuarios.entity.CatecoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CatecoryEntity, Long> {

}
