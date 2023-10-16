package exagonsoft.drones.mapper;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.entity.AuditLog;

public class AuditLogMapper {
    public static AuditLogDto mapToAuditLogDto(AuditLog auditLog) {
        return new AuditLogDto(
                auditLog.getId(),
                auditLog.getDrone_id(),
                auditLog.getMessage(),
                auditLog.getTimestamp());
    }

    public static AuditLog mapToAuditLog(AuditLogDto auditLogDto) {
        return new AuditLog(
                auditLogDto.getId(),
                auditLogDto.getDrone_id(),
                auditLogDto.getMessage(),
                auditLogDto.getTimestamp());
    }
}
