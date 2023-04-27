package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.DescriptionAlreadyExistException;
import fr.uga.l3miage.example.exception.technical.IsNotTestException;
import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
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
    public MiahootEntity getMiahoot(final Long id) throws MiahootEntityNotFoundException {
        return miahootRepository.findById(id)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité de Miahoot n'a été trouvée pour l'id [%d]", id), Long.toString(id)));
                //attention changer le type de l'exception
    }

    /**
     *
     * @param idEnseignant id de l'enseignant pour lequel on cherche ses miahoot. L'id est bien un
     * @return
     */

    Collection<Miahoot> getAllEntityMiahoot(String idEnseignant) {

    }

    //get tous les Miahoot pour un auteur donné
    public List<MiahootEntity> getMiahoots(final Long auteurId) throws MiahootEntityNotFoundException {
        List<MiahootEntity> result = miahootRepository.findAllByAuteurId(auteurId);

        if (result.size() == 0) {
           throw new MiahootEntityNotFoundException(String.format("Aucune liste de Miahoot pour l'auteur ayant l'id [%d]", auteurId), Long.toString(auteurId));
        } else {
            return result;
        }
    }

    public void createMiahoot(final MiahootEntity newMiahoot) {
        //je n'ai pas levé d'exception si un autre Miahoot à le même nom car deux mihaoots peuvent avoir le même nom
        miahootRepository.save(newMiahoot);
    }

    //public void updateTest(final String lastDescription, final Test test) modifier le mapper et utiliser mapstruct pour les sources de modification

    //delete un miahoot via son id
    public void deleteMiahoot(final Long id) {
        this.miahootRepository.deleteById(id);
    }

    //delete des miahoots qui ont un certain nom
    public void deleteMiahoots(final String nom) throws MiahootEntityNotFoundException {
        int nbMiahootDeleted = this.miahootRepository.deleteByNom(nom);

        //si nbMiahootDeleted > 0 , on part du principe que pas de probleme métier car plusieurs miahoot peuvent avoir le meme nom
        if (nbMiahootDeleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Erreur de suppression, aucun Miahoot avec le nom [%s], présent en base", nom), nom);
        }
    }

    //delete tous les mihaoots qui appartiennent à l'auteur dont l'id est passé par paramètre
    public void deleteMiahoots(final Long auteurId) throws MiahootEntityNotFoundException  {
        int nbMiahootDeleted = this.miahootRepository.deleteByAuteurId(auteurId);

        //si nbMiahootDeleted > 0 , on part du principe que pas de probleme métier car plusieurs miahoot peuvent avoir le meme nom
        if (nbMiahootDeleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Erreur de suppression, aucun Miahoot n'a d'auteur dont l'id est  [%d] en base", auteurId), Long.toString(auteurId));
        }
    }
}
