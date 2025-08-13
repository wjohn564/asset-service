package com.equipreserve.asset_service.repo;

import com.equipreserve.asset_service.model.Asset;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    // This repository provides all CRUD for Asset and adds a paginated
    // search that matches the query text against an asset’s name, model, or serial.
    @Query("""
              SELECT a FROM Asset a
              WHERE (:q IS NULL OR LOWER(a.name)  LIKE LOWER(CONCAT('%', :q, '%'))
                     OR LOWER(a.model) LIKE LOWER(CONCAT('%', :q, '%'))
                     OR LOWER(a.serial) LIKE LOWER(CONCAT('%', :q, '%')))
            """)
    Page<Asset> search(@Param("q") String q, Pageable pageable);
}
