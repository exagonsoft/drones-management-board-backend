package exagonsoft.drones.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.exception.DroneInvalidLoadStateException;
import exagonsoft.drones.exception.LowBatteryException;
import exagonsoft.drones.exception.MaxSerialNumberCharacters;
import exagonsoft.drones.exception.MaxWeightExceededException;
import exagonsoft.drones.exception.MedicationCodeInvalidPatternException;
import exagonsoft.drones.exception.MedicationInvalidNamePatternException;

public class UtilFunctions {

    public static void validateDrone(DroneDto drone) {

        if (drone.getMax_weight() > 500) {
            throw new MaxWeightExceededException("Drone Max Weight Exceeded!. (max = 500gr)");
        }

        if (drone.getSerial_number().length() > 100) {
            throw new MaxSerialNumberCharacters("Drone Serial Number Max Length Exceeded!. (max = 100)");
        }
    }

    public static void validateDroneManagement(DroneDto updatedDrone) {

        if (updatedDrone.getState() == StateType.LOADING) {
            if (updatedDrone.getBattery_capacity() < 25) {
                throw new LowBatteryException(
                        "Drone battery level most be greater than 25% to start LOADING state!, (actual:"
                                + updatedDrone.getBattery_capacity() + "%)");
            }
        }
    }

    public static void validateDroneLoad(int droneMaxWeight, List<Medication> medicationList, StateType state) {

        int weightToLoad = medicationList.stream()
                .mapToInt(Medication::getWeight)
                .sum();

        if (weightToLoad > droneMaxWeight) {
            throw new MaxWeightExceededException("Drone Max Weight Exceeded!. (max = " + droneMaxWeight + "gr)");
        }

        if (state != StateType.IDLE) {
            throw new DroneInvalidLoadStateException("The Drone can be loaded only in IDLE state!");
        }
    }

    public static void validateMedication(MedicationDto medication) {
        String VALID_PATTERN = "^[a-zA-Z0-9-_]+$";
        String VALID_CODE_PATTERN = "^[A-Z_0-9]+$";
        Pattern pattern = Pattern.compile(VALID_PATTERN);
        Matcher matcher = pattern.matcher(medication.getName());
        Pattern patternCode = Pattern.compile(VALID_CODE_PATTERN);
        Matcher matcherCode = patternCode.matcher(medication.getCode());

        if (!matcher.matches()) {

            throw new MedicationInvalidNamePatternException(
                    "Medication Name Pattern Invalid!. (allowed only letters, numbers, ‘-‘, ‘_’)");
        }

        if (!matcherCode.matches()) {
            throw new MedicationCodeInvalidPatternException(
                    "Medication Code Pattern Invalid!. (allowed only upper case letters, underscore and numbers)");
        }
    }

    public static Drone updateDroneLifeCycle(Drone drone, List<Medication> medicationList) {
        try {
            if (drone.getState() == StateType.IDLE) {
                drone.setBattery_capacity(100);
                return drone;
            }

            int loadedWeight = medicationList.stream()
                    .mapToInt(Medication::getWeight)
                    .sum();
            int batterySpend = calculateBatterySpend(loadedWeight);
            int newBatteryLevel = drone.getBattery_capacity() - batterySpend;
            drone.setBattery_capacity(newBatteryLevel);
            switch (drone.getState()) {
                case LOADING:
                    drone.setState(StateType.LOADED);
                    break;
                case LOADED:
                    drone.setState(StateType.DELIVERING);
                    break;
                case DELIVERING:
                    drone.setState(StateType.DELIVERED);
                    break;
                case DELIVERED:
                    drone.setState(StateType.RETURNING);
                    break;
                case RETURNING:
                    drone.setState(StateType.IDLE);
                    break;
                default:
                    break;
            }
            return drone;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int calculateBatterySpend(int weightLoaded) {
        int batterySpend = 1;

        if (weightLoaded > 0 && weightLoaded <= 20) {
            batterySpend = 3;
        }

        if (weightLoaded > 20 && weightLoaded <= 50) {
            batterySpend = 5;
        }

        if (weightLoaded > 50 && weightLoaded <= 150) {
            batterySpend = 6;
        }

        if (weightLoaded > 150 && weightLoaded <= 400) {
            batterySpend = 7;
        }

        if (weightLoaded > 400) {
            batterySpend = 10;
        }

        return batterySpend;
    }

    public static void printInfo(String header, String message) {
        try {
            System.out.println("\n");
            System.out.println("****************************" + header + "****************************" + "\n");
            System.out.println(message);
            System.out.println("****************************" + header + " END ****************************");
            System.out.println("\n");
        } catch (Exception e) {
            throw e;
        }
    }
}
