package fr.uga.l3miage.example.models;


import fr.uga.l3miage.example.idgenerator.IdMetierGenerator;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MiahootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String idEnseignant; //sera transmis par le client pour la creation via le JSON. Sert pour la récupération de tous les Miahoots d'un enseigant

    /**
     * !!! ATTENTION !!!
     * Rajouter un id métier string? ou long calculé d'une certaine manière pour qu'il soit unique
     * Cette id sera renvoyé à l'enseignant et il servira à 2 choses:
     *      - Ce connecter à ce miahoot pour un participant
     *      - Update ce miahoot pour l'enseignant
     * Pour le moment on renvoie l'id base de données
     * ATTENTION: Il faudra bien penser à changer dans rest-api/response/Miahoot l'id que
     * l'on renvoie
     */

    @NotBlank
    private String nom;

    //Ca marche?
    @GeneratedValue(generator = "miahoot_seq")
    @GenericGenerator(
            name = "miahoot_seq",
            strategy = "fr.uga.l3miage.example.idgenerator.IdMetierGenerator",
            parameters = {
                    @Parameter(name = IdMetierGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = IdMetierGenerator.VALUE_PREFIX_PARAMETER, value = "MIAHOOT-"),
                    @Parameter(name = IdMetierGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String idMetier;

    @OneToMany(mappedBy = "miahoot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<QuestionEntity> questions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TestEntity that = (TestEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    /*
    public void addQuestion(Question question) {
        if (this.questions == null) {
            this.questions = new HashSet<>();
        }
        this.questions.add(Question question);
    } */
}
