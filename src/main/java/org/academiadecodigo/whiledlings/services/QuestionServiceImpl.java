package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaOptionDao;
import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private JpaOptionDao jpaOptionDao;

    @Autowired
    public void setJpaOptionDao(JpaOptionDao jpaOptionDao) {
        this.jpaOptionDao = jpaOptionDao;
    }

    @Override
    public List<Option> getOptionsList() {

        return jpaOptionDao.findAll();
    }
}
