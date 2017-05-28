package com.epam.learning.aykorenev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by k1per on 21.05.17.
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private Integer enabled;
    private String role;

    public SecurityData(String login, String password) {
        this.login = login;
        this.password = password;
        this.enabled = 1;
        this.role = "USER";
    }
}
