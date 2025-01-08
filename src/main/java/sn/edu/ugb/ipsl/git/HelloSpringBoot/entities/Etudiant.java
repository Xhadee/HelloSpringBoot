package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {
    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

}
