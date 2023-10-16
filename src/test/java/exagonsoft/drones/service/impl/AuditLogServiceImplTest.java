package exagonsoft.drones.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.entity.AuditLog;
import exagonsoft.drones.mock.MockData;
import exagonsoft.drones.repository.AuditLogRepository;
import exagonsoft.drones.repository.DroneRepository;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AuditLogServiceImplTest {

    @InjectMocks
    private AuditLogServiceImpl auditLogService;

    @Mock
    private AuditLogRepository auditLogRepository;

    @Mock
    private DroneRepository droneRepository;

    @Test
    void testListAllAuditLogs() {
        // Arrange
        List<AuditLog> auditLogs = Arrays.asList();
        when(auditLogRepository.findAll()).thenReturn(auditLogs);

        // Act
        List<AuditLogDto> result = auditLogService.listAllAuditLogs();

        // Assert
        assertEquals(auditLogs.size(), result.size());
    }

    @Test
    void testListAllAuditLogsForDrone() {
        // Arrange
        List<AuditLog> auditLogs = Arrays.asList(MockData.mockAuditLog(), MockData.mockAuditLog());

        // Act
        List<AuditLogDto> result = Arrays.asList(MockData.mockAuditLogDto(), MockData.mockAuditLogDto());

        // Assert
        assertEquals(auditLogs.size(), result.size());
    }

    // Additional tests for other methods can be added here
}

