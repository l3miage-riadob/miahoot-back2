package fr.uga.l3miage.example.controller;


import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.endpoint.QuestionEndpoint;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.QuestionEntity;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.Question;
import fr.uga.l3miage.example.service.QuestionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Cette classe correspond à l'implémentation de l'interface {@link QuestionEndpoint}<br>
 */

@RestController
@RequiredArgsConstructor
public class QuestionController implements QuestionEndpoint {

        private final QuestionService questionService;
        private final QuestionMapper questionMapper;

        @Override
        public Collection<Question> getAllQuestion(final Long idMiahoot) {
            return questionMapper.toDto(questionService.getAllQuestions(idMiahoot))  ;
        }

        @Override
        public void createEntityQuestion(final CreateQuestionRequest request, final Long idMiahoot) {
            questionService.createQuestion(request, idMiahoot);
        }

}
