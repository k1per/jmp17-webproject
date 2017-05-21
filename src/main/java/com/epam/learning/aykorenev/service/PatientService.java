package com.epam.learning.aykorenev.service;

import com.epam.learning.aykorenev.model.dto.PatientDTO;

/**
 * Created by k1per on 21.05.17.
 */
public interface PatientService {
    void createNewPatient(PatientDTO patientDTO);
}
