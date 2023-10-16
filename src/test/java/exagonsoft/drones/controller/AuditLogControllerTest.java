package exagonsoft.drones.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.service.AuditLogService;

@WebMvcTest(AuditLogController.class)
public class AuditLogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuditLogService auditLogService;

    @Test
    public void testGetAllAuditLogs() throws Exception {
        // Arrange
        List<AuditLogDto> auditLogs = new ArrayList<>();
        when(auditLogService.listAllAuditLogs()).thenReturn(auditLogs);

        // Act & Assert
        mockMvc.perform(get("/api/audit_logs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(auditLogs.size()));
    }

    @Test
    public void testGetDroneAllAuditLogs() throws Exception {
        // Arrange
        Long droneId = 1L;
        List<AuditLogDto> auditLogs = new ArrayList<>();
        when(auditLogService.listAllAuditLogsForDrone(droneId)).thenReturn(auditLogs);

        // Act & Assert
        mockMvc.perform(get("/api/audit_logs/{id}", droneId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(auditLogs.size()));
    }
}
