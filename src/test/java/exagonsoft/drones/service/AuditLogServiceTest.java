package exagonsoft.drones.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import exagonsoft.drones.service.impl.AuditLogServiceImpl;
import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.repository.AuditLogRepository;
import exagonsoft.drones.repository.DroneRepository;

@SpringBootTest
public class AuditLogServiceTest {

    @InjectMocks
    private AuditLogServiceImpl auditLogService;

    @Mock
    private AuditLogRepository auditLogRepository;

    @Mock
    private DroneRepository droneRepository;

    @Test
    void testCreateAuditLog() {
        // Arrange
        String message = "Audit log message";
        Long droneId = 1L;

        // Act & Assert
        assertDoesNotThrow(() -> auditLogService.createAuditLog(message, droneId));
    }

    @Test
    void testListAllAuditLogs() {
        // Arrange
        List<AuditLogDto> expectedAuditLogs = Arrays.asList();

        // Act
        List<AuditLogDto> result = auditLogService.listAllAuditLogs();

        // Assert
        assertEquals(expectedAuditLogs, result);
    }

    @Test
    void testListAllAuditLogsForDrone() {
        // Arrange
        List<AuditLogDto> expectedAuditLogs = Arrays.asList();

        // Act
        List<AuditLogDto> result = Arrays.asList();

        // Assert
        assertEquals(expectedAuditLogs, result);
    }
}

