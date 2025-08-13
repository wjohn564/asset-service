package com.equipreserve.asset_service.web;

import com.equipreserve.asset_service.model.Asset;
import com.equipreserve.asset_service.service.AssetService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

// Set the endpoint
@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    // Call list by default
    @GetMapping
    public Page<Asset> list(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return service.list(page, size);
    }

    // call search() for a query
    @GetMapping("/search")
    public Page<Asset> search(@RequestParam(required = false) String q,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return service.search(q, page, size);
    }
}
