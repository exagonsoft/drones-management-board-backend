package exagonsoft.drones.repository;

import exagonsoft.drones.entity.AuditLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AuditLogRepositoryTest {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Test
    void testGetDroneAuditLogs() {
        // Save a sample AuditLog with a specific drone ID
        long droneId = 1L;
        AuditLog auditLog = new AuditLog();
        auditLog.setDrone_id(droneId);
        auditLog.setMessage("Sample audit log message");
        auditLogRepository.save(auditLog);

        // Retrieve audit logs for the specific drone ID
        List<AuditLog> auditLogs = auditLogRepository.getDroneAuditLogs(droneId);

        // Assert that the retrieved audit logs contain the saved audit log
        assertEquals(1, auditLogs.size());
        assertEquals("Sample audit log message", auditLogs.get(0).getMessage());
    }
}
