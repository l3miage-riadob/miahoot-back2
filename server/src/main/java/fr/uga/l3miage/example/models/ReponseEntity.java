package fr.uga.l3miage.example.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReponseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private Boolean estValide;

    @ManyToOne
    private Question question;


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
}

