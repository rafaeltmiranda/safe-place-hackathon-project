package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.exceptions.AnswerNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.PersonNotFoundException;
import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaPersonDao;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private JpaPersonDao jpaPersonDao;


    @Autowired
    public void setJpaPersonDao(JpaPersonDao jpaPersonDao) {
        this.jpaPersonDao = jpaPersonDao;
    }

    @Override
    public Person getById(Integer id) {

        return jpaPersonDao.getById(id);
    }

    @Transactional
    @Override
    public Person createNewPerson(Person person) throws PersonNotFoundException {

        if(jpaPersonDao.getById(person.getId()) != null){

            throw new PersonNotFoundException();
        }

        Person savedPerson = jpaPersonDao.saveOrUpdate(person);

        return savedPerson;
    }

    @Transactional
    @Override
    public void deletePersonRespectfully(Integer id) throws PersonNotFoundException {

        Person person = jpaPersonDao.getById(id);

        if(person.getId() == null){

           throw new PersonNotFoundException();
        }

        jpaPersonDao.delete(id);
    }

    @Transactional
    @Override
    public void saveAnswer(Answer answer, Integer personId) throws PersonNotFoundException {

        Person person = jpaPersonDao.getById(personId);

        if(person == null){

            throw new PersonNotFoundException();
        }
            answer.setPerson(person);
            person.saveAnswer(answer);
            jpaPersonDao.saveOrUpdate(person);
    }

    @Override
    public List<Answer> getAnswers(Integer id) {

        Person person = jpaPersonDao.getById(id);

        List<Answer> listAnswers = person.getAnswersList();

        return listAnswers;
    }
}
