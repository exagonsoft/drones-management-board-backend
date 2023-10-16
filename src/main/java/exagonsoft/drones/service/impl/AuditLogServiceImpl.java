package exagonsoft.drones.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.entity.AuditLog;
import exagonsoft.drones.exception.ResourceNotFoundException;
import exagonsoft.drones.mapper.AuditLogMapper;
import exagonsoft.drones.repository.AuditLogRepository;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.AuditLogService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {

    private AuditLogRepository auditLogRepository;
    private DroneRepository droneRepository;

    @Override
    public void createAuditLog(String message, Long droneId) {

        try {
            // Create an AuditLog object with the provided message
            AuditLog auditLog = new AuditLog();
            auditLog.setMessage(message);
            auditLog.setDrone_id(droneId);
            LocalDateTime localNow = LocalDateTime.now();
            Date now = Date.from(localNow.atZone(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(now.getTime());
            auditLog.setTimestamp(sqlDate);

            // Save the audit log to the database
            auditLogRepository.save(auditLog);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<AuditLogDto> listAllAuditLogs() {
        try {
            List<AuditLog> auditLogs = auditLogRepository.findAll();

            return auditLogs.stream().map((auditLog) -> AuditLogMapper.mapToAuditLogDto(auditLog))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    @Override
    public List<AuditLogDto> listAllAuditLogsForDrone(Long droneId) {
        try {
            droneRepository.findById(droneId)
                    .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneId));

            List<AuditLog> auditLogs = auditLogRepository.getDroneAuditLogs(droneId);

            return auditLogs.stream().map((auditLog) -> AuditLogMapper.mapToAuditLogDto(auditLog))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }

}