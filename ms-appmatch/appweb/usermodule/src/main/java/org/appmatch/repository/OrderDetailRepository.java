package org.appmatch.repository;

import org.appmatch.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
}
