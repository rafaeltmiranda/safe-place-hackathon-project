package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaOptionDao;
import org.academiadecodigo.whiledlings.persistence.dao.jpa.JpaQuestionDao;
import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private JpaQuestionDao jpaQuestionDao;
    private JpaOptionDao jpaOptionDao;
    private OptionService  optionService;

    @Autowired
    public void setJpaQuestionDao(JpaQuestionDao jpaQuestionDao) {
        this.jpaQuestionDao = jpaQuestionDao;
    }

    @Autowired
    public void setJpaOptionDao(JpaOptionDao jpaOptionDao) {
        this.jpaOptionDao = jpaOptionDao;
    }

    @Autowired
    public void setOptionService(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public void addQuestion(Question question) {

        jpaQuestionDao.saveOrUpdate(question);
    }

    @Override
    public List<Option> getOptionsList() {

        return jpaOptionDao.findAll();
    }

    @Override
    public void addOption(Option option, Integer id) {

        optionService.addOption(option, id);
    }

    @Override
    public Option changeOption(Integer optionId) {

        Option option = jpaOptionDao.findById(optionId);
        
        return option;   // TODO: 08/08/2019 falta um parametro 
    }
}
