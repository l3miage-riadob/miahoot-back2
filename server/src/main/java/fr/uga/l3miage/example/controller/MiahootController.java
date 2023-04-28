package fr.uga.l3miage.example.controller;


import fr.uga.l3miage.example.endpoint.ExampleEndpoint;
import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import fr.uga.l3miage.example.service.MiahootService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
        Collection<Miahoot> miahoots;
        if (idEnseignant == null) {
            miahoots = miahootService.getAllMiahoot();
            //return miahootService.getAllMiahoot();
        } else {
            miahoots = miahootService.getAllEnseignantMiahoot(idEnseignant);
            //return miahootService.getAllEnseignantMiahoot(idEnseignant);
        }
        System.out.println("------------------------------");
        System.out.println("Controller getAllEntityMiahoot: Nombre de miahoot renvoyé trouvé = " + miahoots.size());
        System.out.println("Controller getAllEntityMiahoot: Nombre de questions dans ce miahoot = " + miahoots.iterator().next().getQuestions().size());
        return miahoots;
    }

    @Override
    public Miahoot getEntityMiahoot(final String idMetier) {
        return miahootService.getMiahoot(idMetier);
    }

    @Override
    public String createEntityMiahoot(final CreateMiahootRequest request) {
        System.out.println("------------------------------");
        System.out.println("Controller createEntityMiahoot: Nombre de questions dans la request = " + request.getQuestions().size());
        return this.miahootService.createMiahoot(request);
    }


    @Override
    public void deleteMiahootEntity(final String idMetier) {
        miahootService.deleteMiahoot(idMetier);
    }

    public void updateMiahootEntity(final Miahoot miahoot, final String idMetier) {
        miahootService.updateMiahoot(miahoot, idMetier);
    }
}
