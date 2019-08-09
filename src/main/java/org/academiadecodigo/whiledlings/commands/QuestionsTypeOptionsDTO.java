package org.academiadecodigo.whiledlings.commands;

import org.academiadecodigo.whiledlings.persistence.model.Option;

import java.util.List;

public class QuestionsTypeOptionsDTO extends QuestionDTO{

    private List<OptionDTO> options;

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
}
