package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

import java.util.List;

public interface QuestionService {

    List<Option> getOptionsList();

}
