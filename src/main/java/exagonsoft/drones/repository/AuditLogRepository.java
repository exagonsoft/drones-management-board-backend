package exagonsoft.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exagonsoft.drones.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    @Query(value = "SELECT * FROM audit_logs WHERE drone_id = :droneId" , nativeQuery = true)
    List<AuditLog> getDroneAuditLogs(@Param("droneId") Long droneId);
}
