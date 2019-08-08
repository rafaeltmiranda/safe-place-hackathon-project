package org.academiadecodigo.whiledlings.controllers;

import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.academiadecodigo.whiledlings.services.AnswerService;
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

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{pid}/new-answer")
    public ResponseEntity<?> saveAnswwer(@PathVariable Integer pid, @Valid @RequestParam Answer answer){

        personService.saveAnswer(pid, answer);      // TODO: 08/08/2019 will be changed 
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
