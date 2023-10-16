package exagonsoft.drones.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.service.DroneService;

@WebMvcTest(DroneController.class)
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DroneService droneService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateDrone() throws Exception {
        // Arrange
        DroneDto droneDto = new DroneDto(); // Initialize with necessary data
        when(droneService.createDrone(droneDto)).thenReturn(droneDto);

        // Act & Assert
        mockMvc.perform(post("/api/drones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(droneDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetDroneById() throws Exception {
        // Arrange
        Long droneId = 1L;
        DroneDto droneDto = new DroneDto(); // Initialize with necessary data
        when(droneService.getDroneByID(droneId)).thenReturn(droneDto);

        // Act & Assert
        mockMvc.perform(get("/api/drones/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllDrones() throws Exception {
        // Arrange
        List<DroneDto> droneList = new ArrayList<>(); // Add some drones to the list
        when(droneService.listAllDrones()).thenReturn(droneList);

        // Act & Assert
        mockMvc.perform(get("/api/drones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testUpdateDrone() throws Exception {
        // Arrange
        Long droneId = 1L;
        DroneDto updatedDroneDto = new DroneDto(); // Initialize with necessary data
        when(droneService.updateDrone(droneId, updatedDroneDto)).thenReturn(updatedDroneDto);

        // Act & Assert
        mockMvc.perform(put("/api/drones/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedDroneDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAvailableDrones() throws Exception {
        // Arrange
        List<DroneDto> availableDroneList = new ArrayList<>(); // Add available drones to the list
        when(droneService.listAvailableDrones()).thenReturn(availableDroneList);

        // Act & Assert
        mockMvc.perform(get("/api/drones/available")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testCheckDroneBatteryLevel() throws Exception {
        // Arrange
        Long droneId = 1L;
        BatteryLevelDto batteryLevelDto = new BatteryLevelDto(); // Initialize with necessary data
        when(droneService.checkDroneBatteryLevel(droneId)).thenReturn(batteryLevelDto);

        // Act & Assert
        mockMvc.perform(get("/api/drones/check_battery/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDroneMedications() throws Exception {
        // Arrange
        Long droneId = 1L;
        List<MedicationDto> medicationList = new ArrayList<>(); // Add medications to the list
        when(droneService.listDroneMedications(droneId)).thenReturn(medicationList);

        // Act & Assert
        mockMvc.perform(get("/api/drones/medications/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoadDrone() throws Exception {
        // Arrange
        Long droneId = 1L;
        List<Long> medicationsListIds = new ArrayList<>(); // Add medication IDs
        when(droneService.loadDroneMedications(droneId, medicationsListIds)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(put("/api/drones/medications/load/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("medicationsListIds", medicationsListIds))))
                .andExpect(status().isOk());

        // Arrange for failure case (internal server error)
        when(droneService.loadDroneMedications(droneId, medicationsListIds)).thenReturn(false);

        // Act & Assert for failure case
        mockMvc.perform(put("/api/drones/medications/load/{id}", droneId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("medicationsListIds", medicationsListIds))))
                .andExpect(status().isInternalServerError());
    }
}


