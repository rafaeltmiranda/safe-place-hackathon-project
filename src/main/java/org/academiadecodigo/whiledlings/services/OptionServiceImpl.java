package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaAnswerDao;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {

    private JpaAnswerDao jpaAnswerDao;

    @Autowired
    public void setJpaAnswerDao(JpaAnswerDao jpaAnswerDao) {
        this.jpaAnswerDao = jpaAnswerDao;
    }

    @Override
    public void addOption(Option option, Integer id) {

        Answer answer = jpaAnswerDao.getById(id);

    }
}
