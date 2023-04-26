package fr.uga.l3miage.example.models;


import lombok.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MiahootEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @NotNull
    private Long auteurId; //sera transmis par le client pour la creation via le JSON

    /*
    @OneToMany
    Set<Question> questions;
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TestEntity that = (TestEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    /*
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addQuestion(Question question) {
        if (this.questions == null) {
            this.questions = new HashSet<>();
        }
        this.questions.add(Question question);
    } */
}
