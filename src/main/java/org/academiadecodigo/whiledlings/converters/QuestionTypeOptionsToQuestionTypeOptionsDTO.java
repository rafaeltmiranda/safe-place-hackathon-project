package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.OptionDTO;
import org.academiadecodigo.whiledlings.commands.QuestionsTypeOptionsDTO;
import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.questions.QuestionTypeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionTypeOptionsToQuestionTypeOptionsDTO implements Converter<QuestionsTypeOptionsDTO, QuestionTypeOptions> {


    OptionToOptionDTO optionToOptionDTO;

    @Autowired
    public void setOptionToOptionDTO(OptionToOptionDTO optionToOptionDTO) {
        this.optionToOptionDTO = optionToOptionDTO;
    }

    @Override
    public QuestionsTypeOptionsDTO convert(QuestionTypeOptions object) {

        QuestionsTypeOptionsDTO questionsTypeOptionsDTO = new QuestionsTypeOptionsDTO();

        questionsTypeOptionsDTO.setId(object.getId());
        questionsTypeOptionsDTO.setQuestion(object.getQuestion());
        questionsTypeOptionsDTO.setLastQuestion(object.isLastQuestion());

        List<OptionDTO> optionsDTO = new ArrayList<>();

        for (Option option : object.getOptions()) {

            optionsDTO.add(optionToOptionDTO.convert(option));
        }

        questionsTypeOptionsDTO.setOptions(optionsDTO);

        return questionsTypeOptionsDTO;
    }
}
