package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    List<Option> getOptionsList();

    void addOption(Option option);

    Option changeOption(Integer optionId);

}
