package tn.esprit.spring.football.entities;



import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
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
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRencontre;
    LocalDateTime dateMatch;
    int nbre_but;
    String nomStade;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToOne
    Arbitre arbitre;

    @ManyToMany(mappedBy = "rencontres")
    List<Equipe> equipes;


}
