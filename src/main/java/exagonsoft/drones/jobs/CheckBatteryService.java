package exagonsoft.drones.jobs;

import org.springframework.scheduling.annotation.Scheduled;

public interface CheckBatteryService {

    @Scheduled(fixedRate = 180000)
    void checkBatteryLevel();
}
