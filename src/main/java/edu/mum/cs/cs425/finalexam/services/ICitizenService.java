package edu.mum.cs.cs425.finalexam.services;

import edu.mum.cs.cs425.finalexam.models.Citizen;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface ICitizenService {
    void saveCitizen(@NotBlank Citizen citizen);
    Iterable<Citizen> findAllCitizens();
    double calculateTotalNationalYearlyIncome(List<Citizen> citizens);
}
