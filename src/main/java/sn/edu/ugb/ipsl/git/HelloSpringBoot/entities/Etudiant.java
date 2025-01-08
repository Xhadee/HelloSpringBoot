package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    private String nom;
    private String prenom;
    private String adresse;

}
