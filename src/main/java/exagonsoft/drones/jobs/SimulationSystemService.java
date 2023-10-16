package exagonsoft.drones.jobs;

import org.springframework.scheduling.annotation.Scheduled;

public interface SimulationSystemService {
    @Scheduled(fixedRate = 120000)
    void simulateDronesLifeCycle();
}
