package org.academiadecodigo.whiledlings.persistence.model;

import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option extends AbstractModel {

    @ManyToOne
    private Question question;

    private String option;

    private Integer idNextQuestion;

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
