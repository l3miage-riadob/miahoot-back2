package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.exception.rest.ReponseEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.IsNotAQuestionOfThisMiahootRestException;
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

    private ReponseComponent reponseComponent;
    private ReponseMapper reponseMapper;
    private MiahootComponent miahootComponent;
    private QuestionComponent questionComponent;

    /**
     * IMPORTANT: Je part du principe que pour la classe miahoot et question il y a une class MiahootEntityNotFoundException qui
     * est appelé dans le cas ou on ne trouve pas l'id du miahoot ou celui de la question
     */
    public Collection<Reponse> getAllReponses(final Long idMiahoot, final Long idQuestion) {
        try {
            Miahoot miahoot = miahootComponent.getMiahoot(idMiahoot);
            Question question = questionComponent.getQuestion(idQuestion);
            if (miahoot.getId(id) == question.getMiahoot().getId()) {
                return reponseMapper.toDto(reponseComponent.getAllQuestionAnswers(idQuestion));
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Impossible de charger les entités. Raison : [%s]", ex.getMessage()), null, ex);
        }
    }

    public void createReponse(final CreateReponseRequest request, final Long idMiahoot, final Long idQuestion) {
        try {
            Miahoot miahoot = miahootComponent.getMiahoot(idMiahoot);
            Question question = questionComponent.getQuestion(idQuestion);
            if (miahoot.getId(id) == question.getMiahoot().getId()) {
                ReponseEntity newReponseEntity = reponseMapper.toEntity(request);
                reponseComponent.createReponse(newReponseEntity);
            } else throw new IsNotAQuestionOfThisMiahootException("Cette question ne fait pas partie de ce Miahoot", ex);
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Impossible de charger les entités. Raison : [%s]", ex.getMessage()), null, ex);
        }
    }

}


