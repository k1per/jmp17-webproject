package com.epam.learning.aykorenev.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Anton_Korenev on 5/9/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    @NotEmpty(message = "{validation.login.notEmpty}")
    @Size(min = 3, max = 22)
    @NotNull
    private String login;
    @NotNull
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
            message = "{validation.password.patternNotMuch}")
    private String password;
    @NotEmpty
    private String confirmPassword;
    @Email @NotNull
    private String email;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    @Range(min = 18, max = 99)
    private int age;
    @Pattern(regexp = "\\d{11}",  message = "{validation.telephone.patternNotMuch}" )
    private String contactTelephoneNumber;
}
