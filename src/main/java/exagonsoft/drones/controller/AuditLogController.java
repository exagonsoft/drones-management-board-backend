package exagonsoft.drones.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.service.AuditLogService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/audit_logs")
public class AuditLogController {
    private AuditLogService auditLogService;

    @GetMapping
    public ResponseEntity<List<AuditLogDto>> getAllAuditlogs() {
        List<AuditLogDto> auditLogsList = auditLogService.listAllAuditLogs();

        return ResponseEntity.ok(auditLogsList);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<AuditLogDto>> getDroneAllAuditlogs(@PathVariable("id") Long droneID) {
        List<AuditLogDto> auditLogsList = auditLogService.listAllAuditLogsForDrone(droneID);

        return ResponseEntity.ok(auditLogsList);
    }
}
