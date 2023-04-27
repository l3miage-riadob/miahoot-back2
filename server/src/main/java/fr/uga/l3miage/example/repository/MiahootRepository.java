package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.models.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MiahootRepository extends JpaRepository <MiahootEntity, Long> {
    //nom id auteurId
    //Optional<TestEntity> findByNom(final String description);

    Optional<MiahootEntity> findById(final Long id);

    List<MiahootEntity> findAllByAuteurId(final Long auteurId);

    Optional<Collection<MiahootEntity>> findAllMiahootByIdEnseignant(String idEnseignant);

    //void deleteById(final Long id);

    int deleteByNom(final String nom);

    int deleteByAuteurId(final Long auteurId);
    //MiahootEntity save(MiahootEntity miahoot);
}