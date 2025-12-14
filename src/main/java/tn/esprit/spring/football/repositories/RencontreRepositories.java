package tn.esprit.spring.football.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.football.entities.Rencontre;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RencontreRepositories extends JpaRepository<Rencontre, Long> {
    List<Rencontre> findByDateMatchBetween(LocalDateTime start, LocalDateTime end);

    @Modifying
    @Query("UPDATE Rencontre r SET r.nbre_but = r.nbre_but + 1 WHERE r.idRencontre = :idRencontre AND DATE(r.dateMatch) = CURRENT_DATE")
    void incrementerNbreBut(@Param("idRencontre") int idRencontre);
}
