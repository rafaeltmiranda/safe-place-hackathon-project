package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.persistence.model.Answer;

public class AnswerToAnswerDTO extends AbstractConverter<AnswerDTO, Answer> {

    @Override
    public AnswerDTO convert(Answer answer) {

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setAnswer(answer.getAnswer());
        answerDTO.setQuestion(answer.getQuestion());
        answerDTO.setPerson(answer.getPerson());

        return  answerDTO;
    }
}
