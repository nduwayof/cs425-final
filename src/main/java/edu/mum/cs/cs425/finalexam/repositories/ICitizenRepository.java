package edu.mum.cs.cs425.finalexam.repositories;

import edu.mum.cs.cs425.finalexam.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitizenRepository extends JpaRepository<Citizen, Long> {
}
