package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AnswerToAnswerDTO extends AbstractConverter<AnswerDTO, Answer> {

    @Override
    public AnswerDTO convert(Answer answer) {

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setAnswer(answer.getAnswer());
        answerDTO.setQuestion(answer.getIdQuestion());

        return  answerDTO;
    }

    public List<AnswerDTO> convert(List<Answer> answers){
        
        List<AnswerDTO> answerDTOS = new LinkedList<>();

        for (Answer a: answers){

            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setId(a.getId());   // TODO: 08/08/2019 meter mais legivel
            answerDTO.setAnswer(a.getAnswer());
            answerDTO.setQuestion(a.getIdQuestion());
            answerDTOS.add(answerDTO);
        }

        return answerDTOS;
    }
}
