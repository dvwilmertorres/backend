package org.appmatch.msapigateway.repository;
import org.appmatch.msapigateway.entity.MstRouteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MstRouteManagerRepository extends JpaRepository<MstRouteManagerEntity, UUID> {
}
