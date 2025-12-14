package tn.esprit.spring.football.entities;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
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
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArbitre;
    String nom;
    String prenom;
    String Nationalite;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @OneToMany(mappedBy = "arbitre")
    List<Rencontre> rencontres;

}
