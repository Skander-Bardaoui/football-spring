package tn.esprit.spring.football.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idJoueur;
    String nom;
    String prenom;
    Poste poste;
    int num_maillot;

    @ManyToOne
    @JsonIgnoreProperties("joueurs")
    Equipe equipe;

}
