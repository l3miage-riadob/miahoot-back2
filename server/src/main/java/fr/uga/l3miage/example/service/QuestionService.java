package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.QuestionComponent;
//import fr.uga.l3miage.example.exception.rest.QuestionEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestIntIsZeroRestException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.QuestionEntity;
//import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionComponent questionComponent;
    private final QuestionMapper questionMapper;

    public Collection<QuestionEntity> getAllQuestions(final Long idMiahoot) {
        if(idMiahoot <= 10 && idMiahoot >= 1) {
            return questionComponent.getAllQuestionsforOneMiahoot(idMiahoot);
        }
        else throw new TestIntIsZeroRestException(" Id non compris entre 1 et 10");
    }

    public void createQuestion(final CreateQuestionRequest request, final Long idMiahoot) {
        if(idMiahoot <= 10 && idMiahoot >= 1) {
            QuestionEntity newQuestionEntity=questionMapper.toEntity(request);
            questionComponent.createQuestionEntity(newQuestionEntity);
        }
        else throw new TestIntIsZeroRestException(" Id non compris entre 1 et 10");
    }

}
