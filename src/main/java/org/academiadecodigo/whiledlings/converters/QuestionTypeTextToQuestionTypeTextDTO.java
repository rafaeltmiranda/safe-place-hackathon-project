package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.QuestionTypeTextDTO;
import org.academiadecodigo.whiledlings.persistence.model.questions.QuestionTypeText;
import org.springframework.stereotype.Component;

@Component
public class QuestionTypeTextToQuestionTypeTextDTO implements Converter<QuestionTypeTextDTO, QuestionTypeText> {

    @Override
    public QuestionTypeTextDTO convert(QuestionTypeText object) {

        QuestionTypeTextDTO questionTypeTextDTO = new QuestionTypeTextDTO();

        questionTypeTextDTO.setId(object.getId());
        questionTypeTextDTO.setQuestion(object.getQuestion());
        questionTypeTextDTO.setLastQuestion(object.isLastQuestion());
        questionTypeTextDTO.setIdNextQuestion(object.getIdNextQuestion());

        return questionTypeTextDTO;
    }
}
