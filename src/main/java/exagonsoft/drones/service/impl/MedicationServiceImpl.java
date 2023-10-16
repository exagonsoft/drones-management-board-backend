package exagonsoft.drones.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.exception.ResourceNotFoundException;
import exagonsoft.drones.mapper.MedicationMapper;
import exagonsoft.drones.repository.MedicationRepository;
import exagonsoft.drones.service.MedicationService;
import exagonsoft.drones.utils.UtilFunctions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private MedicationRepository medicationRepository;

    @Override
    public MedicationDto getMedication(Long medicationID) {
        try {
            Medication medication = medicationRepository.findById(medicationID)
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Medication not found with given id: " + medicationID));

            return MedicationMapper.mapToMedicationDto(medication);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public MedicationDto createMedication(MedicationDto medicationDto) {
        try {

            // *Validate the Drone Data*/
            UtilFunctions.validateMedication(medicationDto);

            Medication medication = MedicationMapper.mapToMedication(medicationDto);

            Medication savedMedication = medicationRepository.save(medication);

            return MedicationMapper.mapToMedicationDto(savedMedication);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public MedicationDto updateMedication(Long medicationId, MedicationDto updatedMedicationDto) {
        try {
            // *Validate the Drone Data*/
            UtilFunctions.validateMedication(updatedMedicationDto);

            Medication medication = medicationRepository.findById(medicationId)
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Medication not found with given id: " + medicationId));

            medication.setName(updatedMedicationDto.getName());
            medication.setCode(updatedMedicationDto.getCode());
            medication.setWeight(updatedMedicationDto.getWeight());
            medication.setImageUrl(updatedMedicationDto.getImageUrl());

            Medication updatedMedicationObj = medicationRepository.save(medication);

            return MedicationMapper.mapToMedicationDto(updatedMedicationObj);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteMedication(Long medicationID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMedication'");
    }

    @Override
    public MedicationDto getMedicationById(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Medication not found with given id: " + medicationId));

        return MedicationMapper.mapToMedicationDto(medication);
    }

    @Override
    public List<MedicationDto> listAllMedications() {
        try {
            List<Medication> medications = medicationRepository.findAll();

            return medications.stream().map((medication) -> MedicationMapper.mapToMedicationDto(medication))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    @Override
    public List<Medication> getMedicationsListByIds(List<Long> medicationIds) {
        try {
            List<Medication> medications = medicationRepository.findAllById(medicationIds);

            Map<Long, Medication> medicationMap = new LinkedHashMap<>();
            for (Medication medication : medications) {
                medicationMap.put(medication.getId(), medication);
            }

            List<Medication> result = new ArrayList<>();
            for (Long id : medicationIds) {
                Medication medication = medicationMap.get(id);
                if (medication != null) {
                    result.add(medication);
                }
            }

            return result;
        } catch (Exception e) {

            throw e;
        }
    }

}
