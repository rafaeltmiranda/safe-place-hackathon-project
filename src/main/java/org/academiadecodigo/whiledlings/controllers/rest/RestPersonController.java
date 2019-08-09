package org.academiadecodigo.whiledlings.controllers.rest;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.commands.PersonDTO;
import org.academiadecodigo.whiledlings.converters.AnswerDtoToAnswer;
import org.academiadecodigo.whiledlings.converters.AnswerToAnswerDTO;
import org.academiadecodigo.whiledlings.converters.PersonDtoToPerson;
import org.academiadecodigo.whiledlings.converters.PersonToPersonDTO;
import org.academiadecodigo.whiledlings.exceptions.AnswerNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.OurCorlorsNotFoundException;
import org.academiadecodigo.whiledlings.exceptions.PersonNotFoundException;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.academiadecodigo.whiledlings.services.AnswerService;
import org.academiadecodigo.whiledlings.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestPersonController {

    private PersonService personService;
    private PersonToPersonDTO personToPersonDTO;
    private PersonDtoToPerson personDtoToPerson;
    private AnswerToAnswerDTO answerToAnswerDTO;
    private AnswerDtoToAnswer answerDtoToAnswer;

    @Autowired
    public void setAnswerDtoToAnswer(AnswerDtoToAnswer answerDtoToAnswer) {
        this.answerDtoToAnswer = answerDtoToAnswer;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setPersonToPersonDTO(PersonToPersonDTO personToPersonDTO) {
        this.personToPersonDTO = personToPersonDTO;
    }

    @Autowired
    public void setPersonDtoToPerson(PersonDtoToPerson personDtoToPerson) {
        this.personDtoToPerson = personDtoToPerson;
    }

    @Autowired
    public void setAnswerToAnswerDTO(AnswerToAnswerDTO answerToAnswerDTO) {
        this.answerToAnswerDTO = answerToAnswerDTO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PersonDTO> showPerson(@PathVariable Integer id) {

        Person person = personService.getById(id);
        PersonDTO personDTO = personToPersonDTO.convert(person);

        if (personDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addPerson(@Valid @RequestBody PersonDTO personDTO, BindingResult bindingResult) {


        if (bindingResult.hasErrors() || personDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Person savedPerson = personService.createNewPerson(personDtoToPerson.convert(personDTO));
            return new ResponseEntity<>(personToPersonDTO.convert(savedPerson),HttpStatus.OK);

        } catch (OurCorlorsNotFoundException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deletePersonRespectfully(@PathVariable Integer id) {

        if (personService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {

            personService.deletePersonRespectfully(id);

        } catch (PersonNotFoundException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/answer")             // this path looks fishy to me
    public ResponseEntity<List<AnswerDTO>> getPersonAnswers(@PathVariable Integer id) {

        Person person = personService.getById(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<AnswerDTO> listOfAnswers = new ArrayList<>();

        for (Answer answer : person.getAnswersList()) {
            listOfAnswers.add(answerToAnswerDTO.convert(answer));
        }

        return new ResponseEntity<>(listOfAnswers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{pid}/answer")
    public ResponseEntity<?> saveAnswer(
            @PathVariable Integer pid, @Valid @ModelAttribute("answer") AnswerDTO answerDTO, BindingResult bindingResult){

        Answer answer = answerDtoToAnswer.convert(answerDTO);

        try {
            personService.saveAnswer(answer, pid);
        } catch (AnswerNotFoundException | PersonNotFoundException e) {
            e.printStackTrace(); // TODO: 08/08/2019 this
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
