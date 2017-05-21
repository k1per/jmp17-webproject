package com.epam.learning.aykorenev.service;

import com.epam.learning.aykorenev.model.Patient;
import com.epam.learning.aykorenev.model.dto.PatientDTO;
import com.epam.learning.aykorenev.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by k1per on 21.05.17.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void createNewPatient(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO);
        patientRepository.save(patient);
    }
}
