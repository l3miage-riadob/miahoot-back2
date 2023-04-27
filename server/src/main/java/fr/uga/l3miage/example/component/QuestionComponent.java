package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.models.QuestionEntity;
import fr.uga.l3miage.example.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Attention: Potentiellement il faudra mettre une limite au nombre de réponse possible voir d'autres choses
 * à prendre en compte. Pour le moment on rend l'entité persistante sans plus de vérification
 * @param newReponseEntity correspond à la nouvelle réponse possible que l'on veut ajouter à une question
 */

/**
 * Respect de l'architecture hexagonale, on ne traite ici que les données
 */

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    /*
    // private final MiahootRepository miahootRepository;
    private final QuestionRepository questionRepository;

  // public Collection<Question> getAllQuestionsforOneMiahoot(Long idMiahoot) {
        //return miahootRepository.GetQuestions();
   // }

    public void createQuestionEntity(QuestionEntity nouveauQuestionEntity) {
        questionRepository.save(nouveauQuestionEntity);
    }
    public Collection<QuestionEntity> getAllQuestionsforOneMiahoot(Long idMiahoot) {
        return questionRepository.findAll();
    }
    */

}


