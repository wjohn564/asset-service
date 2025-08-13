package com.equipreserve.asset_service.service;

import com.equipreserve.asset_service.repo.AssetRepository;
import com.equipreserve.asset_service.model.Asset;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    private final AssetRepository repo;

    public AssetService(AssetRepository repo) {
        this.repo = repo;
    }

    public Page<Asset> list(int page, int size) {
        // Returns a paged list of assets, Limits pagination to 100
        return repo.findAll(PageRequest.of(Math.max(page, 0), Math.min(size, 100), Sort.by("name")));
    }

    public Page<Asset> search(String q, int page, int size) {
        // Ensure query is ok
        String term = (q == null || q.isBlank()) ? null : q.trim();
        // call search() and match name/model/serial
        return repo.search(term, PageRequest.of(Math.max(page, 0), Math.min(size, 100), Sort.by("name")));
    }
}
