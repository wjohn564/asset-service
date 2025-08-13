package com.equipreserve.asset_service.seed;

import com.equipreserve.asset_service.model.Asset;
import com.equipreserve.asset_service.repo.AssetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final AssetRepository repo;

    public DataLoader(AssetRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        // if the repository is empty create it
        if (repo.count() > 0) return;
        repo.save(newAsset("Scanner A", "Zebra DS2208", "SN-001"));
        repo.save(newAsset("Scanner B", "Honeywell Voyager 1250g", "SN-002"));
        repo.save(newAsset("Scanner C", "Datalogic QuickScan QD2131", "SN-003"));
    }

    private Asset newAsset(String name, String model, String serial) {
        // Helper method to build an Asset
        Asset a = new Asset();
        a.setName(name);
        a.setModel(model);
        a.setSerial(serial);
        return a;
    }
}
