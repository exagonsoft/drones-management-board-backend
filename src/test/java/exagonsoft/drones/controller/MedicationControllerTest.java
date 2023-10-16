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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.service.MedicationService;

@WebMvcTest(MedicationController.class)
public class MedicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicationService medicationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateMedication() throws Exception {
        // Arrange
        MedicationDto medicationDto = new MedicationDto(); // Initialize with necessary data
        when(medicationService.createMedication(medicationDto)).thenReturn(medicationDto);

        // Act & Assert
        mockMvc.perform(post("/api/medications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicationDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetMedicationById() throws Exception {
        // Arrange
        Long medicationId = 1L;
        MedicationDto medicationDto = new MedicationDto(); // Initialize with necessary data
        when(medicationService.getMedicationById(medicationId)).thenReturn(medicationDto);

        // Act & Assert
        mockMvc.perform(get("/api/medications/{id}", medicationId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllMedications() throws Exception {
        // Arrange
        List<MedicationDto> medicationList = new ArrayList<>(); // Add some medications to the list
        when(medicationService.listAllMedications()).thenReturn(medicationList);

        // Act & Assert
        mockMvc.perform(get("/api/medications")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMedication() throws Exception {
        // Arrange
        Long medicationId = 1L;
        MedicationDto updatedMedicationDto = new MedicationDto(); // Initialize with necessary data
        when(medicationService.updateMedication(medicationId, updatedMedicationDto)).thenReturn(updatedMedicationDto);

        // Act & Assert
        mockMvc.perform(put("/api/medications/{id}", medicationId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedMedicationDto)))
                .andExpect(status().isOk());
    }
}

