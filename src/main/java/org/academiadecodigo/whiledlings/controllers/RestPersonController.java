package org.academiadecodigo.whiledlings.controllers;

import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.academiadecodigo.whiledlings.services.AnswerService;
import org.academiadecodigo.whiledlings.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class RestPersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Person> showPerson(@PathVariable Integer id){

        // TODO - change this to DTO! fernando
        Person person = personService.getById(id);

        if (person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/", ""})
    public ResponseEntity<?> addPerson(@Valid @RequestBody Person person, BindingResult bindingResult){

        // TODO: 08/08/2019 DTO here as well - fernando

        if (bindingResult.hasErrors() || person == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        personService.createNewPerson(person);
        // TODO: 08/08/2019 analyse this better, does it make sense that the createNewPerson method returns a Person?

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deletePersonRespectfully(@PathVariable Integer id){

        if (personService.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personService.deletePersonRespectfully(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/answers")             // this path looks fishy to me
    public ResponseEntity<List<Answer>> getPersonAnswers(@PathVariable Integer id){

        if (personService.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Answer> listOfAnswers = personService.getAnswers(id);

        return new ResponseEntity<>(listOfAnswers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{pid}/{qid}")
    public ResponseEntity<?> saveAnswer(@Valid @RequestBody Answer answer){

        // TODO: 08/08/2019 what if the answer is empty? add shit to prevent that
        // TODO: 08/08/2019 also, i must receive here pid and qid, i think


        personService.saveAnswer(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
