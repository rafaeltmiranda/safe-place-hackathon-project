package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaQuestionDao;
import org.academiadecodigo.whiledlings.persistence.model.questions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private JpaQuestionDao jpaQuestionDao;

    @Autowired
    public void setJpaQuestionDao(JpaQuestionDao jpaQuestionDao) {
        this.jpaQuestionDao = jpaQuestionDao;
    }

    @Override
    public Question getQuestion(Integer questionId) {

        Question question = jpaQuestionDao.getById(questionId);

        return question;
    }
}
