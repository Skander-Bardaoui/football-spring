package tn.esprit.spring.football.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.football.entities.Arbitre;
import tn.esprit.spring.football.entities.Equipe;
import tn.esprit.spring.football.entities.Rencontre;
import tn.esprit.spring.football.repositories.ArbitreRepositories;
import tn.esprit.spring.football.repositories.EquipeRepositories;
import tn.esprit.spring.football.repositories.RencontreRepositories;

import java.util.List;

@Service
@AllArgsConstructor

public class appService implements IappService{

    ArbitreRepositories arbitreRepo;
    EquipeRepositories equipeRepo;
    RencontreRepositories rencontreRepo;

    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }

    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        equipe.getJoueurs().forEach(joueur -> joueur.setEquipe(equipe));
        return equipeRepo.save(equipe);
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, int idR) throws Exception {
        Arbitre arbitre =arbitreRepo.findByNomAndPrenom(nom,prenom);
        Rencontre rencontre = rencontreRepo.findById((long)idR).get();

        if (arbitre.getNiveau() != rencontre.getNiveau()) {
            throw new Exception("Exception déclanchée");
        }
        rencontre.setArbitre(arbitre);
        rencontreRepo.save(rencontre);
    }


    @Override
    @Transactional
    public void incrementerNbreBut(int idRencontre) {
        rencontreRepo.incrementerNbreBut(idRencontre);
    }

    @Override
    public List<Arbitre> recupererArbitresDUneEquipe(int idEquipe) {
        return arbitreRepo.recupererArbitresDUneEquipe(idEquipe);
    }

    @Override
    public Rencontre ajouterRencontre(Rencontre rencontre) {
        return rencontreRepo.save(rencontre);
    }

    @Override
    public void addEquipeToRencontre(long idRencontre, long idEquipe) {
        Rencontre rencontre = rencontreRepo.findById(idRencontre).get();
        Equipe equipe = equipeRepo.findById(idEquipe).get();

        equipe.getRencontres().add(rencontre);
        rencontre.getEquipes().add(equipe);
        equipeRepo.save(equipe);
    }
}
