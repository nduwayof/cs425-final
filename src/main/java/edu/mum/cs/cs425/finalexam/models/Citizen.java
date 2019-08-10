package edu.mum.cs.cs425.finalexam.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CITIZENS")
public class Citizen {

    @Id
    @Column(name = "CITIZEN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long citizenId;

    @Column(name = "SOCIAL_SECURITY_NUMBER", nullable = false, unique = true)
    private String socialSecurityNumber;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "YEARLY_INCOME", nullable = false)
    private double yearlyIncome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stateId", nullable = false)
    private State state;
}
