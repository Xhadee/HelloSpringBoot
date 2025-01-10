package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nom ;

    @Column(nullable=false)
    private String prenom;
    private String adresse;

    @PrePersist
    @PreUpdate
    public void trimField() {
        System.out.println("###TrimField "+prenom);
        if (prenom != null) {
            prenom = prenom.trim();
        }
        if (nom != null) {
            nom = nom.trim();
        }
        if (adresse != null) {
            adresse = adresse.trim();
        }
    }
}
