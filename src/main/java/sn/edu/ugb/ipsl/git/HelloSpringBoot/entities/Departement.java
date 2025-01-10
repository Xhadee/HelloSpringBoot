package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Departement {
    @Id
    private String code;

    @Column(nullable=false, unique=true)
    private String nom;
    private String description;
}
