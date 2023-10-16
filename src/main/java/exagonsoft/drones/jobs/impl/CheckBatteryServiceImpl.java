package exagonsoft.drones.jobs.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import exagonsoft.drones.jobs.CheckBatteryService;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.AuditLogService;
import exagonsoft.drones.utils.UtilFunctions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CheckBatteryServiceImpl implements CheckBatteryService {

    private DroneRepository droneRepository;
    private AuditLogService auditLogService;

    @Override
    @Scheduled(fixedRate = 180000)
    public void checkBatteryLevel() {
        try {
            List<Object[]> drones = droneRepository.getAllDronesBatteryLevel();
            String _logMessage = "";

            for (Object[] drone : drones) {
                String serialNumber = (String) drone[0];
                Integer batteryLevel = (Integer) drone[1];
                Long id = (Long) drone[2];
                String message = "Drone with Serial Number " + serialNumber + " battery level: " + batteryLevel + "%";
                auditLogService.createAuditLog(message, id);
                _logMessage += "--" + message + "\n";
            }
            UtilFunctions.printInfo("BATTERY LEVEL INFO " + LocalDateTime.now(), _logMessage);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong!");
        }
    }
}
