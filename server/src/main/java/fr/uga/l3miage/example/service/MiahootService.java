package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.exception.rest.MiahootEntityNotDeletedRestException;
import fr.uga.l3miage.example.exception.rest.MiahootEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotDeletedRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.MultipleEntityHaveSameDescriptionException;
import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.Miahoot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MiahootService {

    private final MiahootMapper miahootMapper;
    private final MiahootComponent miahootComponent;

    public void createMiahoot(final CreateMiahootRequest request) {

        MiahootEntity newMiahootEntity = this.miahootMapper.toEntity(request);
        this.miahootComponent.createMiahoot(newMiahootEntity);
    }

    //get un miahoot via son id au format DTO
    public Miahoot getMiahoot(final Long id) {

        try {
            return miahootMapper.toDto(miahootComponent.getMiahoot(id));
        } catch (MiahootEntityNotFoundException e) {
            throw new MiahootEntityNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]",e.getMessage()), Long.toString(id), e);
        }
    }


    // TODO Faut t'il vraiment ajouter une exception si il ne trouve rien?

    // Renvoie tous les Miahoot présent dans la base de données
    public Collection<Miahoot> getAllMiahoot() {
        return miahootMapper.toDto(miahootComponent.getAllMiahoot());
    }

    // Renvoie tous les Miahoot présent dans la base de donnée associé à l'idEnseignant
    public Collection<Miahoot> getAllEnseignantMiahoot(String idEnseignant) {
        try {
            return miahootMapper.toDto(miahootComponent.getAllEnseignantMiahoot(idEnseignant));
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundRestException(String.format("Impossible de charger l'entité"), null);
        }
    }

    //TODO
    //delete pour auteur

    //TODO
    //delete un miahoot via son  id

    @Transactional
    public void deleteMiahoot(final Long id) {

        try {
            MiahootEntity searchedMiahoot = this.miahootComponent.getMiahoot(id);
            miahootComponent.deleteMiahoot(id);
        }catch (MiahootEntityNotFoundException e) {
            //throw ici
            throw new MiahootEntityNotDeletedRestException(e.getMessage());
        }

        /*
        try {
            miahootComponent.deleteMiahoot(id);
        } catch (MiahootEntityNotFoundException e) {
            throw new MiahootEntityNotDeletedRestException(e.getMessage());
        } */
    }

}
