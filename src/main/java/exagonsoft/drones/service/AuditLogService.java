package exagonsoft.drones.service;

import java.util.List;

import exagonsoft.drones.dto.AuditLogDto;

public interface AuditLogService {
    void createAuditLog(String message, Long droneId);

    List<AuditLogDto> listAllAuditLogs();

    List<AuditLogDto> listAllAuditLogsForDrone(Long droneId);
}
