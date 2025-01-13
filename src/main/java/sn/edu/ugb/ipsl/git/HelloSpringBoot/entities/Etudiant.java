package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Schema(description = "permet de representer un etudiant de l'IPSL")
public class Etudiant {
    @Schema(description = "represente de facon unique l'identifiant de l'etudiant",example = "12")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "represente de facon unique l'identifiant de l'etudiant",required=true, example = "JOOP")
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
