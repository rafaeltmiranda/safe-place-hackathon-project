package org.academiadecodigo.whiledlings.services;

import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.Question;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    List<Option> getOptionsList();

    void addOption(Option option, Integer id);

    Option changeOption(Integer optionId);

}
