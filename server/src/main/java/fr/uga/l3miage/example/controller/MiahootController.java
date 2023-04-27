package fr.uga.l3miage.example.controller;


import fr.uga.l3miage.example.endpoint.ExampleEndpoint;
import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import fr.uga.l3miage.example.service.MiahootService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class MiahootController implements MiahootEndpoint {

    private final MiahootService miahootService;

    /**
     *
     * @param idEnseignant id de l'enseignant pour lequel on cherche ses miahoots.
     * @return Tous les miahoots associés à idEnseignant ou bien tous les miahoots si cet id est null
     */
    public Collection<Miahoot> getAllEntityMiahoot(String idEnseignant) {
        if (idEnseignant == null) {
            return miahootService.getAllMiahoot();
        } else {
            return miahootService.getAllEnseignantMiahoot(idEnseignant);
        }
    }

    @Override
    public Miahoot getEntityMiahoot(final Long id) {
        return miahootService.getMiahoot(id);
    }

    @Override
    public void createEntityMiahoot(final CreateMiahootRequest request) {
        this.miahootService.createMiahoot(request);
    }


    @Override
    public void deleteMiahootEntity(final Long id) {
        miahootService.deleteMiahoot(id);
    }

    //TODO
    //public void updateMiahootEntity(...,final Miahoot miahoot)
}
