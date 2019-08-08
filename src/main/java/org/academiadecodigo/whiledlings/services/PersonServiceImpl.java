package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.exceptions.AnswerNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.PersonNotFoundException;
import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaPersonDao;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private JpaPersonDao jpaPersonDao;
    private AnswerService answerService;

    @Autowired
    public void setJpaPersonDao(JpaPersonDao jpaPersonDao) {
        this.jpaPersonDao = jpaPersonDao;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public Person getById(Integer id) {

        return jpaPersonDao.getById(id);
    }

    @Override
    public Person createNewPerson(Person person) throws PersonNotFoundException {

        if(jpaPersonDao.getById(person.getId()) != null){

            throw new PersonNotFoundException();
        }

        jpaPersonDao.saveOrUpdate(person);

        return person;
    }

    @Override
    public void deletePersonRespectfully(Integer id) throws PersonNotFoundException {

        Person person = jpaPersonDao.getById(id);

        if(person.getId() == null){

           throw new PersonNotFoundException();
        }

        jpaPersonDao.delete(id);
    }

    @Override
    public void saveAnswer(Answer answer) throws AnswerNotFoundException {

        if(answer == null){

            throw new AnswerNotFoundException();
        }

          answerService.saveAnswer(answer);
    }

    @Override
    public List<Answer> getAnswers(Integer id) {

        Person person = jpaPersonDao.getById(id);

        List<Answer> listAnswers = person.getAnswersList();

        return listAnswers;
    }
}
