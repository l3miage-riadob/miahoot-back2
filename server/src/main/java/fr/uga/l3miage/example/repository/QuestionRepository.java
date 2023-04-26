package fr.uga.l3miage.example.repository;


import fr.uga.l3miage.example.models.QuestionEntity;
import fr.uga.l3miage.example.models.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {

    /*int deleteById(final long id);

    QuestionEntity save(QuestionEntity question);


    QuestionEntity get(Long id);

    void delete(QuestionEntity question) ;

    List<QuestionEntity> allQuestion();*/

}

