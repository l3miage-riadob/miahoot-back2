package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.ReponseEntity;
import fr.uga.l3miage.example.repository.ReponseRepository;
import fr.uga.l3miage.example.response.Reponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Respect de l'architecture hexagonale, on ne traite ici que les données
 */

@Component
@RequiredArgsConstructor
public class ReponseComponent {

    private final ReponseRepository reponseRepository;
    private final QuestionRepository questionRepository;

    public Collection<Reponse> getAllQuestionAnswers(Long idQuestion) {
        return questionRepository.getOne(idQuestion).getReponses();
    }

    /**
     * Attention: Potentiellement il faudra mettre une limite au nombre de réponse possible voir d'autres choses
     * à prendre en compte. Pour le moment on rend l'entité persistante sans plus de vérification
     * @param newReponseEntity correspond à la nouvelle réponse possible que l'on veut ajouter à une question
     */
    public void createReponse(ReponseEntity newReponseEntity) {
        reponseRepository.save(newReponseEntity);
    }

}
