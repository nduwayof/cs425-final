package edu.mum.cs.cs425.finalexam.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "STATES")
public class State {

    @Id
    @Column(name = "STATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    @Length(min = 3, max = 3)
    @Column(name = "STATE_CODE", nullable = false, length = 3, unique = true)
    private String stateCode;

    @Column(name = "STATE_NAME", nullable = false)
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<Citizen> citizens = new ArrayList<>();

}
