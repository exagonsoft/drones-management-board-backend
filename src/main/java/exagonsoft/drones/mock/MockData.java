package exagonsoft.drones.mock;

import exagonsoft.drones.dto.AuditLogDto;
import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.DroneMedicationDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.AuditLog;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.DroneMedications;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.ModelType;
import exagonsoft.drones.entity.Drone.StateType;

public class MockData {

    public static Drone mockDrone() {
        Drone drone = new Drone();
        drone.setId(1L);
        drone.setSerial_number("mxzn6789");
        drone.setMax_weight(250);
        drone.setModel(ModelType.Cruiserweight);
        drone.setBattery_capacity(100);
        drone.setState(StateType.IDLE);
        return drone;
    }

    public static DroneDto mockDroneDto(){
        DroneDto droneDto = new DroneDto();
        droneDto.setId(1L);
        droneDto.setSerial_number("mxzn6789");
        droneDto.setMax_weight(250);
        droneDto.setModel(ModelType.Cruiserweight);
        droneDto.setBattery_capacity(100);
        droneDto.setState(StateType.IDLE);
        return droneDto;
    }

    public static DroneDto mockUpdatedDroneDto(){
        DroneDto droneDto = new DroneDto();
        droneDto.setId(1L);
        droneDto.setSerial_number("mxzn6789");
        droneDto.setMax_weight(250);
        droneDto.setModel(ModelType.Cruiserweight);
        droneDto.setBattery_capacity(90);
        droneDto.setState(StateType.DELIVERED);
        return droneDto;
    }

    public static Medication mockMedications(){
        Medication medication = new Medication();
        medication.setId(1L);
        medication.setName("Test_Medication");
        medication.setWeight(10);
        medication.setCode("GNXT_42_ZFYTUPL");
        medication.setImageUrl("/uploads/samplePicture.png");
        return medication;
    }

    public static MedicationDto mockMedicationDto(){
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setId(1L);
        medicationDto.setName("Test_Medication");
        medicationDto.setWeight(10);
        medicationDto.setCode("GNXT_42_ZFYTUPL");
        medicationDto.setImageUrl("/uploads/samplePicture.png");
        return medicationDto;
    }

    public static DroneMedications mockDroneMedications(){
        DroneMedications droneMedications = new DroneMedications();
        droneMedications.setId(1L);
        droneMedications.setDroneId(1L);
        droneMedications.setMedicationId(1L);
        return droneMedications;
    }

    public static DroneMedicationDto mockDroneMedicationDto(){
        DroneMedicationDto droneMedicationDto = new DroneMedicationDto();
        droneMedicationDto.setId(1L);
        droneMedicationDto.setDroneId(1L);
        droneMedicationDto.setMedicationId(1L);
        return droneMedicationDto;
    }

    public static AuditLog mockAuditLog(){
        AuditLog auditLog = new AuditLog();
        auditLog.setId(1L);
        auditLog.setDrone_id(1L);
        auditLog.setMessage("Sample Message");
        auditLog.setTimestamp(new java.sql.Date(System.currentTimeMillis()));
        return auditLog;
    }

    public static AuditLogDto mockAuditLogDto() {
        AuditLogDto auditLogDto = new AuditLogDto();
        auditLogDto.setId(1L);
        auditLogDto.setDrone_id(1L);
        auditLogDto.setMessage("Sample Message");
        auditLogDto.setTimestamp(new java.sql.Date(System.currentTimeMillis()));
        return auditLogDto;
    }

    public static BatteryLevelDto mockBatteryLevelDto(){
        BatteryLevelDto batteryLevelDto = new BatteryLevelDto();
        batteryLevelDto.setBatteryLevel(100);
        return batteryLevelDto;
    }
}
