package tn.esprit.spring.football.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.football.entities.Arbitre;

import java.util.List;


@Repository
public interface ArbitreRepositories extends JpaRepository<Arbitre, Long> {
    Arbitre findByNomAndPrenom(String nom, String prenom);

    @Query("SELECT DISTINCT a FROM Arbitre a JOIN a.rencontres r JOIN r.equipes e WHERE e.idEquipe = :idEquipe")
    List<Arbitre> recupererArbitresDUneEquipe(@Param("idEquipe") int idEquipe);

}
