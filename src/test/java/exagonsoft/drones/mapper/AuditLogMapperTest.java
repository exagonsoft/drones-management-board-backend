package exagonsoft.drones.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.entity.AuditLog;

public class AuditLogMapperTest {

    @Test
    public void testMapToAuditLogDto() {
        // Arrange
        AuditLog auditLog = new AuditLog(1L, 1L, "Test Message", null);

        // Act
        AuditLogDto auditLogDto = AuditLogMapper.mapToAuditLogDto(auditLog);

        // Assert
        assertEquals(auditLog.getId(), auditLogDto.getId());
        assertEquals(auditLog.getDrone_id(), auditLogDto.getDrone_id());
        assertEquals(auditLog.getMessage(), auditLogDto.getMessage());
        assertEquals(auditLog.getTimestamp(), auditLogDto.getTimestamp());
    }

    @Test
    public void testMapToAuditLog() {
        // Arrange
        AuditLogDto auditLogDto = new AuditLogDto(1L, 1L, "Test Message", null);

        // Act
        AuditLog auditLog = AuditLogMapper.mapToAuditLog(auditLogDto);

        // Assert
        assertEquals(auditLogDto.getId(), auditLog.getId());
        assertEquals(auditLogDto.getDrone_id(), auditLog.getDrone_id());
        assertEquals(auditLogDto.getMessage(), auditLog.getMessage());
        assertEquals(auditLogDto.getTimestamp(), auditLog.getTimestamp());
    }
}
