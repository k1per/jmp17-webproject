package com.epam.learning.aykorenev.repository;

import com.epam.learning.aykorenev.model.Patient;
import com.epam.learning.aykorenev.model.SecurityData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by k1per on 21.05.17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void shouldSaveAndRetrievePatient(){
        Patient patient = new Patient();
        patient.setFirstName("Red");
        patient.setLastName("Crocodile");
        patient.setAge(22);
        patient.setEmail("RedCrocodile@greatlake.com");
        SecurityData securityData = new SecurityData("RedCrocodile","megapassword");
        patient.setSecurityData(securityData);

        entityManager.persist(patient);
        Patient resultPatetient = patientRepository.findByEmail("RedCrocodile@greatlake.com");

        assertThat(resultPatetient.getAge(), is(22));
        assertThat(resultPatetient.getFirstName(), is("Red"));
        assertThat(resultPatetient.getLastName(), is("Crocodile"));
        assertThat(resultPatetient.getEmail(), is("RedCrocodile@greatlake.com"));
        assertThat(resultPatetient.getSecurityData().getLogin(), is("RedCrocodile"));
        assertThat(resultPatetient.getSecurityData().getPassword(), is("megapassword"));
    }
}