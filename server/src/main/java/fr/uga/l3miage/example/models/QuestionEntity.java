package fr.uga.l3miage.example.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter//cree un getter pour tout attribut de la classe automatiquement de maniere implicite
@Setter //cree un setter pour tout attribut de la classe automatiquement de maniere implicite
@Builder
@Entity
@AllArgsConstructor //cree un constructeur de tous les attributs de la classe automatiquement
@NoArgsConstructor // cree le constructeur par défaut
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank // NotBlank = label ne peut pas être = à null ou empty ("" ou "   ")
    private String label;

    @ManyToOne
    private MiahootEntity miahoot;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("id ASC")
    private List<ReponseEntity> reponses = new ArrayList<>();

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
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
    */

}
