package org.academiadecodigo.whiledlings.persistence.model.questions;

import javax.persistence.Entity;

@Entity
public class QuestionTypeText extends Question {

    private Integer idNextQuestion;

    public void setIdNextQuestion(Integer idNextQuestion) {
        this.idNextQuestion = idNextQuestion;
    }

    public Integer getIdNextQuestion() {
        return idNextQuestion;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.TEXT;
    }
}
