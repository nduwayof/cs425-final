package edu.mum.cs.cs425.finalexam.services;

import edu.mum.cs.cs425.finalexam.models.State;


public interface IStateService {
    Iterable<State> findAllStates();
}
