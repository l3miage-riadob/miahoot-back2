package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;

    //recuperer un miahoot via son id

    //get un Miahoot via son id
    public MiahootEntity getMiahoot(final String idMetier) throws MiahootEntityNotFoundException {
        return miahootRepository.findByIdMetier(idMetier)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité de Miahoot n'a été trouvée pour l'id [%s]", idMetier), idMetier));
    }

    public Collection<MiahootEntity> getAllMiahoot() {
        return miahootRepository.findAll();

    }

    // Renvoie tous les Miahoot présent dans la base de donnée associé à l'idEnseignant
    public Collection<MiahootEntity> getAllEnseignantMiahoot(String idEnseignant) throws MiahootEntityNotFoundException {
        return miahootRepository.findAllMiahootByIdEnseignant(idEnseignant)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité de Miahoot n'a été trouvée pour l'id [%s]", idEnseignant), idEnseignant));
    }


    public String createMiahoot(final MiahootEntity newMiahoot) {
        //je n'ai pas levé d'exception si un autre Miahoot à le même nom car deux mihaoots peuvent avoir le même nom
        System.out.println("------------------------------");
        System.out.println("Component createMiahoot: Avant de save nombre de questions dans la request Entity = " + newMiahoot.getQuestions().size());
        miahootRepository.save(newMiahoot);

        MiahootEntity tmpTest = miahootRepository.getOne(newMiahoot.getId());
        System.out.println("Component createMiahoot: Ici on a sauvegardé l'entité, on la récupère et on regarde si il a appliqué le persistant sur les associations");
        System.out.println("Component createMiahoot: Nombre de question dans le miahoot récupéré après save = " + tmpTest.getQuestions().size());

        return newMiahoot.getIdMetier();
    }

    public void updateMiahoot(Miahoot miahoot, String idMetier) throws MiahootEntityNotFoundException {
        MiahootEntity miahootEntity = miahootRepository.findByIdMetier(idMetier)
                .orElseThrow( () -> new MiahootEntityNotFoundException(String.format("Aucune entité miahoot ayant l'id métier [%s] n'a été trouvé", idMetier), idMetier));
        miahootMapper.mergeMiahootEntity(miahootEntity, miahoot);
        miahootRepository.save(miahootEntity);
    }

    //delete un miahoot via son id
    public void deleteMiahoot(final String idMetier) throws MiahootEntityNotFoundException, MultipleEntityHaveSameDescriptionException {
        int deleted = miahootRepository.deleteByIdMetier(idMetier);
        if (deleted > 1) {
            throw new MultipleEntityHaveSameDescriptionException("Plusieurs entités ont le même id métier alors que c'est impossible ".concat(idMetier));
        } else if (deleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Aucune entité miahoot ayant l'id métier [%s] n'a été trouvé", idMetier), idMetier);
        };
    }

    /*
    //delete tous les mihaoots qui appartiennent à l'auteur dont l'id est passé par paramètre
    public void deleteMiahoots(final String idEnseignant) throws MiahootEntityNotFoundException  {
        int nbMiahootDeleted = this.miahootRepository.deleteByIdEnseignant(idEnseignant);

        //si nbMiahootDeleted > 0 , on part du principe que pas de probleme métier car plusieurs miahoot peuvent avoir le meme nom
        if (nbMiahootDeleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Erreur de suppression, aucun Miahoot n'a d'auteur dont l'id est  [%d] en base", auteurId), Long.toString(auteurId));
        }
    }
    */

}
