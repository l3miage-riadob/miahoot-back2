package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.endpoint.ReponseEndpoint;
import fr.uga.l3miage.example.error.ReponseNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.Reponse;
import fr.uga.l3miage.example.service.ReponseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Cette classe correspond à l'implémentation de l'interface {@link ReponseEndpoint}<br>
 */

@RestController
@RequiredArgsConstructor
public class ReponseController implements ReponseEndpoint {

    private final ReponseService reponseService;

    @Override
    public Collection<Reponse> getAllEntityReponseOfAQuestion(final Long idMiahoot, final Long idQuestion) {
        return reponseService.getAllReponses(idMiahoot, idQuestion);
    }

    @Override
    public void createEntityReponse(final CreateReponseRequest request, final Long idMiahoot, final Long idQuestion) {
        reponseService.createReponse(request, idMiahoot, idQuestion);
    }

}
