package exagonsoft.drones.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.service.DroneService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/drones")
public class DroneController {
    private DroneService droneService;

    @PostMapping
    public ResponseEntity<DroneDto> createDrone(@RequestBody DroneDto droneDto) {

        try {
            DroneDto savedDrone = droneService.createDrone(droneDto);

            return new ResponseEntity<>(savedDrone, HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<DroneDto> getDroneById(@PathVariable("id") Long droneID) {
        DroneDto droneDto = droneService.getDroneByID(droneID);

        return ResponseEntity.ok(droneDto);
    }

    @GetMapping
    public ResponseEntity<List<DroneDto>> getAllDrones() {
        List<DroneDto> droneList = droneService.listAllDrones();

        return ResponseEntity.ok(droneList);
    }

    @PutMapping("{id}")
    public ResponseEntity<DroneDto> updateDrone(@PathVariable("id") Long droneID, @RequestBody DroneDto updatedDrone) {
        DroneDto droneDto = droneService.updateDrone(droneID, updatedDrone);
        return ResponseEntity.ok(droneDto);
    }

    @GetMapping("/available")
    public ResponseEntity<List<DroneDto>> getAvailableDrones() {
        List<DroneDto> droneList = droneService.listAvailableDrones();

        return ResponseEntity.ok(droneList);
    }

    @GetMapping("/check_battery/{id}")
    public ResponseEntity<BatteryLevelDto> checkDroneBatteryLevel(@PathVariable("id") Long droneID) {
        BatteryLevelDto droneBatteryLevel = droneService.checkDroneBatteryLevel(droneID);

        return ResponseEntity.ok(droneBatteryLevel);
    }

    @GetMapping("/medications/{id}")
    public ResponseEntity<List<MedicationDto>> getDroneMedications(@PathVariable("id") Long droneID) {
        List<MedicationDto> droneMedications = droneService.listDroneMedications(droneID);

        return ResponseEntity.ok(droneMedications);
    }

    @PutMapping("/medications/load/{id}")
    public ResponseEntity<Void> loadDrone(@PathVariable("id") Long droneID,
            @RequestBody Map<String, List<Long>> requestBody) {
        List<Long> medicationsListIds = requestBody.get("medicationsListIds");
        boolean result = droneService.loadDroneMedications(droneID, medicationsListIds);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
