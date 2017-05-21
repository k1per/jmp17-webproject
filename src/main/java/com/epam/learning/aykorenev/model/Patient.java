package com.epam.learning.aykorenev.model;

import com.epam.learning.aykorenev.model.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
@Data
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SecurityData securityData;
    private String contactTelephoneNumber;

    public Patient(PatientDTO patientDTO) {
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.email = patientDTO.getEmail();
        this.age = patientDTO.getAge();
        this.contactTelephoneNumber = patientDTO.getContactTelephoneNumber();
        this.securityData = new SecurityData(patientDTO.getLogin(), patientDTO.getPassword());
    }
}
