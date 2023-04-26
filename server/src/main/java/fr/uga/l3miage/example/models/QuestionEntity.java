package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String label;

    //@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    //@OrderBy("id ASC")
    //private List<Reponse> reponses = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
            return Objects.hash(id, label);
        }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }

}
