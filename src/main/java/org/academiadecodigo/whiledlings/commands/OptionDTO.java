package org.academiadecodigo.whiledlings.commands;

import org.academiadecodigo.whiledlings.persistence.model.questions.Question;
import org.springframework.stereotype.Component;

@Component
public class OptionDTO {

    private int id;

    private Question question;

    private String option;

    private Integer idNextQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getIdNextQuestion() {
        return idNextQuestion;
    }

    public void setIdNextQuestion(Integer idNextQuestion) {
        this.idNextQuestion = idNextQuestion;
    }
}
