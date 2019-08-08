package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaAnswerDao;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    private JpaAnswerDao jpaAnswerDao;

    @Autowired
    public void setJpaAnswerDao(JpaAnswerDao jpaAnswerDao) {
        this.jpaAnswerDao = jpaAnswerDao;
    }

    @Override
    public void saveAnswer(Answer answer) {

        jpaAnswerDao.saveOrUpdate(answer);
    }
}
