package org.academiadecodigo.whiledlings.services;

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
    public Person createNewPerson(Person person) {

        if(jpaPersonDao.getById(person.getId()) != null){

            // TODO: 08/08/2019 atualizar throw com excecoes
        }

        jpaPersonDao.saveOrUpdate(person);

        return person;
    }

    @Override
    public void deletePersonRespectfully(Integer id) {

        Person person = jpaPersonDao.getById(id);

        if(person.getId() == null){

           // TODO: 08/08/2019 atualizar throw com excecoes
        }

        jpaPersonDao.delete(id);
    }

    @Override
    public void saveAnswer(Answer answer) {

        if(answer == null){

            // TODO: 08/08/2019 atualizar throw com excecoes
        }

          answerService.saveAnswer(answer);
    }

    @Override
    public List<Answer> getAnswers(Integer id) {

        Person person = jpaPersonDao.getById(id);

        List<Answer> listAnswers = person.listAnswers();

        return listAnswers;  // TODO: 08/08/2019
    }
}
