package edu.mum.cs.cs425.finalexam.controllers;

import edu.mum.cs.cs425.finalexam.models.Citizen;
import edu.mum.cs.cs425.finalexam.services.ICitizenService;
import edu.mum.cs.cs425.finalexam.services.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CitizenController {

    private IStateService stateService;
    private ICitizenService citizenService;

    @Autowired
    public CitizenController(IStateService stateService, ICitizenService citizenService){
        this.stateService = stateService;
        this.citizenService = citizenService;
    }

    @GetMapping(path = "/citizens")
    public String citizens(Model model){
        List<Citizen> citizens = (List<Citizen>)citizenService.findAllCitizens();
        model.addAttribute("citizens", citizens);
        model.addAttribute("totalYearlyIncome", citizenService.calculateTotalNationalYearlyIncome(citizens));
        return "pages/citizens";
    }

    @GetMapping(path={"/citizen/new"})
    public String newCitizenForm(Model model) {
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("states", stateService.findAllStates());
        return "pages/citizen";
    }

    @PostMapping(path = {"/citizen/new"})
    public String registerNewCitizen(@Valid @ModelAttribute("citizen") Citizen citizen) {
        citizenService.saveCitizen(citizen);
        return "redirect:/citizens";
    }


}
