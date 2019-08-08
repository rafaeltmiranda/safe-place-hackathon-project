package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.exceptions.AnswerNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.PersonNotFoundException;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;

import java.util.List;

public interface PersonService{

    Person getById(Integer id);

    Person createNewPerson(Person person) throws PersonNotFoundException;

    void deletePersonRespectfully(Integer id) throws PersonNotFoundException;

    void saveAnswer(Answer answer, Integer personId) throws AnswerNotFoundException, PersonNotFoundException;

    List<Answer> getAnswers(Integer id);
}
