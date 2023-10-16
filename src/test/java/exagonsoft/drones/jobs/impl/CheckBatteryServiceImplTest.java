package exagonsoft.drones.jobs.impl;

import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.AuditLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class CheckBatteryServiceImplTest {

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private AuditLogService auditLogService;

    @InjectMocks
    private CheckBatteryServiceImpl checkBatteryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckBatteryLevel() {
        // Arrange
        List<Object[]> drones = new ArrayList<>();
        Object[] droneData = {"Serial123", 80, 1L};
        drones.add(droneData);

        when(droneRepository.getAllDronesBatteryLevel()).thenReturn(drones);

        // Act
        checkBatteryService.checkBatteryLevel();

        // Assert
        verify(auditLogService, times(1)).createAuditLog(eq("Drone with Serial Number Serial123 battery level: 80%"), eq(1L));
    }
}
