package org.academiadecodigo.whiledlings.controllers;

import org.academiadecodigo.whiledlings.commands.AnswerDTO;
import org.academiadecodigo.whiledlings.commands.PersonDTO;
import org.academiadecodigo.whiledlings.converters.AnswerToAnswerDTO;
import org.academiadecodigo.whiledlings.converters.PersonDtoToPerson;
import org.academiadecodigo.whiledlings.converters.PersonToPersonDTO;
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
@RequestMapping("/api/")
public class RestPersonController {

    private PersonService personService;
    private PersonToPersonDTO personToPersonDTO;
    private PersonDtoToPerson personDtoToPerson;
    private AnswerToAnswerDTO answerToAnswerDTO;

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

        Person person = personDtoToPerson.convert(personDTO);
        try {
            personService.createNewPerson(person);

        } catch (OurCorlorsNotFoundException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
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

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/answers")             // this path looks fishy to me
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
}
