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
        if (repo.count() > 0) return;

        repo.saveAll(java.util.List.of(
                newAsset("Scanner A", "Zebra DS2208", "SN-001"),
                newAsset("Scanner B", "Honeywell Voyager 1250g", "SN-002"),
                newAsset("Scanner C", "Datalogic QuickScan QD2131", "SN-003"),
                newAsset("Scanner D", "Zebra LI4278", "SN-004"),
                newAsset("Scanner E", "Zebra DS4608", "SN-005"),
                newAsset("Scanner F", "Honeywell Xenon 1900", "SN-006"),
                newAsset("Scanner G", "Honeywell Voyager 1450g", "SN-007"),
                newAsset("Scanner H", "Datalogic Gryphon GBT4500", "SN-008"),
                newAsset("Scanner I", "Datalogic QuickScan QBT2131", "SN-009"),
                newAsset("Scanner J", "Symbol LS2208", "SN-010"),
                newAsset("Scanner K", "Zebra DS4308", "SN-011"),
                newAsset("Scanner L", "Zebra DS8108", "SN-012"),
                newAsset("Scanner M", "Honeywell Granit 1910i", "SN-013"),
                newAsset("Scanner N", "Honeywell Voyager 1202g", "SN-014"),
                newAsset("Scanner O", "Datalogic PowerScan PBT9300", "SN-015"),
                newAsset("Scanner P", "Datalogic Heron HD3430", "SN-016"),
                newAsset("Scanner Q", "Unitech MS836", "SN-017"),
                newAsset("Scanner R", "Inateck BCST-60", "SN-018"),
                newAsset("Scanner S", "Tera 8100", "SN-019"),
                newAsset("Scanner T", "NADAMOO YHD-891", "SN-020"),
                newAsset("Scanner U", "Eyoyo EY-009", "SN-021"),
                newAsset("Scanner V", "NetumScan S1", "SN-022"),
                newAsset("Scanner W", "Zebex Z-3100", "SN-023"),
                newAsset("Scanner X", "WoneNice WN-6900", "SN-024"),
                newAsset("Scanner Y", "TaoTronics TT-BS030", "SN-025")
        ));
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
