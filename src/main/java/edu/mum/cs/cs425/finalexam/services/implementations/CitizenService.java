package edu.mum.cs.cs425.finalexam.services.implementations;

import edu.mum.cs.cs425.finalexam.models.Citizen;
import edu.mum.cs.cs425.finalexam.repositories.ICitizenRepository;
import edu.mum.cs.cs425.finalexam.services.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class CitizenService implements ICitizenService {

    private ICitizenRepository citizenRepository;

    @Autowired
    public CitizenService(ICitizenRepository  citizenRepository){
        this.citizenRepository = citizenRepository;
    }

    @Override
    public void saveCitizen(@NotBlank Citizen citizen) {
        this.citizenRepository.save(citizen);
    }

    @Override
    public Iterable<Citizen> findAllCitizens() {
        return this.citizenRepository.findAll(Sort.by("lastName").ascending());
    }

    @Override
    public double calculateTotalNationalYearlyIncome(List<Citizen> citizens) {
        double totalNationalYearlyIncome = 0;
        for(Citizen citizen : citizens){
            totalNationalYearlyIncome += citizen.getYearlyIncome();
        }
        return totalNationalYearlyIncome;
    }
}
