package tn.esprit.spring.football.services;

import tn.esprit.spring.football.entities.Arbitre;
import tn.esprit.spring.football.entities.Equipe;
import tn.esprit.spring.football.entities.Rencontre;

import java.util.List;

public interface IappService {

    Arbitre ajouterArbitre (Arbitre arbitre) ;
    Equipe ajouterEquipeEtJoueurs (Equipe equipe) ;
    void affecterArbitreARencontre (String nom, String prenom, int idR) throws Exception ;
    void incrementerNbreBut (int idRencontre) ;
    List<Arbitre> recupererArbitresDUneEquipe(int idEquipe);
    Rencontre ajouterRencontre(Rencontre rencontre);
    void addEquipeToRencontre(long idRencontre, long idEquipe);

}
