package com.epam.learning.aykorenev.repository;

import com.epam.learning.aykorenev.model.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by k1per on 21.05.17.
 */
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByEmail(String email);
}
