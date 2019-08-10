package edu.mum.cs.cs425.finalexam.services.implementations;

import edu.mum.cs.cs425.finalexam.models.State;
import edu.mum.cs.cs425.finalexam.repositories.IStateRepository;
import edu.mum.cs.cs425.finalexam.services.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService implements IStateService {

    private IStateRepository stateRepository;

    @Autowired
    public StateService(IStateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @Override
    public Iterable<State> findAllStates() {
        return this.stateRepository.findAll();
    }
}
