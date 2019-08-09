package org.academiadecodigo.whiledlings.commands;

import org.academiadecodigo.whiledlings.persistence.model.Option;

import java.util.List;

public class QuestionsTypeOptionsDTO extends QuestionDTO{

    private List<Option> options;

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
