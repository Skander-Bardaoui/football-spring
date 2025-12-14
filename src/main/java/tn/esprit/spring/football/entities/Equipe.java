package tn.esprit.spring.football.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
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
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEquipe;
    String NomEquipe;
    LocalDate dateCreation;


    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("equipe")
    List<Joueur> joueurs;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("equipes")
    List<Rencontre> rencontres;
}
