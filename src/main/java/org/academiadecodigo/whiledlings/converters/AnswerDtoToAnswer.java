package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.persistence.model.Answer;

public class AnswerDtoToAnswer implements Converter<Answer, AnswerDTO> {

    @Override
    public Answer convert(AnswerDTO answerDTO) {

        Answer answer = new Answer();
        answer.setAnswer(answerDTO.getAnswer());
        answer.setPerson(answerDTO.getPerson());
        answer.setQuestion(answerDTO.getQuestion());

        return answer;
    }
}
