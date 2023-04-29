package fr.uga.l3miage.example.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



//@Builder

@Data
@NoArgsConstructor
@Entity
public class MiahootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMiahoot;

    @NotBlank
    private String idEnseignant; //sera transmis par le client pour la creation via le JSON. Sert pour la récupération de tous les Miahoots d'un enseigant

    @NotBlank
    private String nom;

    private String idMetier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<QuestionEntity> questions;

    /*
    public void addQuestions(QuestionEntity questionEntity) {
        questions.add(questionEntity);
        questionEntity.setMiahootEntity(this);
    }

    public void removeQuestions(QuestionEntity questionEntity) {
        questions.remove(questionEntity);
        questionEntity.setMiahootEntity(null);
    }
    */
}
