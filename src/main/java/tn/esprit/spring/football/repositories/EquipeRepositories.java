package tn.esprit.spring.football.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.football.entities.Equipe;

@Repository
public interface EquipeRepositories extends JpaRepository<Equipe, Long> {
}
