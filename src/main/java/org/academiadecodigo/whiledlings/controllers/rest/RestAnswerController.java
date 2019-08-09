package org.academiadecodigo.whiledlings.controllers.rest;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.converters.AnswerDtoToAnswer;
import org.academiadecodigo.whiledlings.exceptions.AnswerNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.PersonNotFoundException;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class RestAnswerController {

    private PersonService personService;
    private AnswerDtoToAnswer answerDtoToAnswer;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setAnswerDtoToAnswer(AnswerDtoToAnswer answerDtoToAnswer) {
        this.answerDtoToAnswer = answerDtoToAnswer;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{pid}/new-answer")
    public ResponseEntity<?> saveAnswer(@PathVariable Integer pid, @Valid @RequestParam AnswerDTO answerDTO){

        Answer answer = answerDtoToAnswer.convert(answerDTO);

        try {
            personService.saveAnswer(answer, pid);
        } catch (AnswerNotFoundException | PersonNotFoundException e) {
            e.printStackTrace(); // TODO: 08/08/2019 this
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
