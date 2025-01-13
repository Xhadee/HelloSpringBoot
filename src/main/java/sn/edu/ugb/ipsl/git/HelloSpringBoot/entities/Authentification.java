package sn.edu.ugb.ipsl.git.HelloSpringBoot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "authentification")
public class Authentification {
    @Id
    private Integer id;

    @ManyToOne
    private User user;

    @Column(unique = true,nullable = false)
    private String token;

    private Date notBefore;
    private Date notAfter;
}