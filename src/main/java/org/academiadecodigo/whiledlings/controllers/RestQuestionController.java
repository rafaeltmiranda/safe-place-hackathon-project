package org.academiadecodigo.whiledlings.controllers;

import org.academiadecodigo.whiledlings.persistence.model.Option;
import org.academiadecodigo.whiledlings.persistence.model.questions.Question;
import org.academiadecodigo.whiledlings.persistence.model.questions.QuestionType;
import org.academiadecodigo.whiledlings.persistence.model.questions.QuestionTypeOptions;
import org.academiadecodigo.whiledlings.services.QuestionService;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class RestQuestionController {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{qid}/options")
    public ResponseEntity<?> showOptions(@PathVariable Integer qid){

        //List<Option> optionsList = questionService.getOptionsList();

        Question question = questionService.getQuestion(qid); // TODO: 08/08/2019 ricardo doing this

        if (question.getQuestionType() == QuestionType.TEXT){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        QuestionTypeOptions questionTypeOptions = (QuestionTypeOptions) question;
        List<Option> optionsList = questionTypeOptions.getOptions();

        return new ResponseEntity<>(optionsList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{qid}")
    public ResponseEntity<Question> showQuestion(@PathVariable Integer qid){

        Question question = questionService.getQuestion(qid);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
