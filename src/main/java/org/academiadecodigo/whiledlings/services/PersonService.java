package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;

import java.util.List;

public interface PersonService {

    Person getById(Integer id);

    Person createNewPerson(Person person);

    void deletePersonRespectfully(Integer id);

    void saveAnswer(Answer answer);

    List<Answer> getAnswers(Integer id);
}
