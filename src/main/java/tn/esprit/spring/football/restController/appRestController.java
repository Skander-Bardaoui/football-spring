package tn.esprit.spring.football.restController;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.football.entities.Arbitre;
import tn.esprit.spring.football.entities.Equipe;
import tn.esprit.spring.football.entities.Rencontre;
import tn.esprit.spring.football.repositories.ArbitreRepositories;
import tn.esprit.spring.football.repositories.EquipeRepositories;
import tn.esprit.spring.football.repositories.RencontreRepositories;
import tn.esprit.spring.football.services.IappService;

import java.util.List;

@RestController
@AllArgsConstructor
public class appRestController {

   IappService appService;
   ArbitreRepositories arbitreRepos;
   RencontreRepositories rencontreRepo;
   EquipeRepositories equipeRepo;

    @PostMapping("/addArbitre")
    public Arbitre ajouterArbitre(@RequestBody Arbitre arbitre){
        return appService.ajouterArbitre(arbitre) ;
    }

    @PostMapping("/addequi")
    public Equipe ajouterEquipeEtJoueurs(@RequestBody Equipe equipe){
        return appService.ajouterEquipeEtJoueurs(equipe);
    }

    @PutMapping("/affecterArbitre/{nom}/{prenom}/{idR}")
    public void affecterArbitreARencontre(@PathVariable String nom,
                                          @PathVariable String prenom,
                                          @PathVariable int idR) throws Exception{
        appService.affecterArbitreARencontre(nom,prenom,idR);
    }

    @GetMapping("/arbitres")
    public List<Arbitre> getAllArbitres() {
        return arbitreRepos.findAll();
    }

    @PutMapping("/rencontre/incrementerBut/{idRencontre}")
    public void incrementerNbreBut(@PathVariable int idRencontre) {
        appService.incrementerNbreBut(idRencontre);
    }

    @GetMapping("/arbitres/equipe/{idEquipe}")
    public List<Arbitre> recupererArbitresDUneEquipe(@PathVariable int idEquipe) {
        return appService.recupererArbitresDUneEquipe(idEquipe);
    }


    @PutMapping("/rencontre/{idRencontre}/addEquipe/{idEquipe}")
    public void addEquipeToRencontre(@PathVariable long idRencontre, @PathVariable long idEquipe) {
        appService.addEquipeToRencontre(idRencontre, idEquipe);
    }

    @PostMapping("/rencontre/add")
    public Rencontre addRencontre(@RequestBody Rencontre rencontre) {
        return appService.ajouterRencontre(rencontre);
    }
}
