package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.exception.rest.ReponseEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.IsNotAQuestionOfThisMiahootRestException;
import fr.uga.l3miage.example.exception.technical.ReponseEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.ReponseEntity;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.Reponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ReponseService {

    private final ReponseComponent reponseComponent;
    private final ReponseMapper reponseMapper;
    private final MiahootComponent miahootComponent;
    private final QuestionComponent questionComponent;

    /**
     * IMPORTANT: Je part du principe que pour la classe miahoot et question il y a une class MiahootEntityNotFoundException qui
     * est appelé dans le cas ou on ne trouve pas l'id du miahoot ou celui de la question
     */
    public Collection<Reponse> getAllReponses(final Long idMiahoot, final Long idQuestion) {
        try {
            Miahoot miahootEntity = miahootComponent.getMiahoot(idMiahoot); /* Il faudra c  */
            Question questionEntity = questionComponent.getQuestion(idQuestion);
            if (miahoot.getId(id) == question.getMiahoot().getId()) {
                return reponseMapper.toDto(reponseComponent.getAllQuestionAnswers(idQuestion));
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question n'existe pas"), null, ex);
        }
    }

    public void createReponse(final CreateReponseRequest request, final Long idMiahoot, final Long idQuestion) {
        try {
            Miahoot miahootEntity = miahootComponent.getMiahoot(idMiahoot);
            Question questionEntity = questionComponent.getQuestion(idQuestion);
            if (miahoot.getId(id) == question.getMiahoot().getId()) {
                ReponseEntity newReponseEntity = reponseMapper.toEntity(request);
                reponseComponent.createReponse(newReponseEntity);
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question n'existe pas"), null, ex);
        }
    }

    public void deleteReponse(final Long idMiahoot, final Long idQuestion, final Long idReponse) {
        try {
            MiahootEntity miahoot = miahootComponent.getMiahoot(idMiahoot);
            QuestionEntity question = questionComponent.getQuestion(idQuestion);
            ReponseEntity reponse = reponseComponent.getReponse(idReponse);
            if (miahoot.getId(id) == question.getMiahoot().getId() && question.getId() == reponse.getQuestion().getId()) {
                reponseComponent.deleteReponse(idReponse);
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot ou cette réponse n'est pas liée à cette question");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException | ReponseEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question ou la réponse n'existe pas"), null, ex);
        }

    }

}


