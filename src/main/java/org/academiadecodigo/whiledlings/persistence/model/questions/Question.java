package org.academiadecodigo.whiledlings.persistence.model.questions;

import org.academiadecodigo.whiledlings.persistence.model.AbstractModel;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
public abstract class Question extends AbstractModel {

    private String question;

    private boolean lastQuestion = false;

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setLastQuestion(boolean lastQuestion) {
        this.lastQuestion = lastQuestion;
    }

    public boolean isLastQuestion() {
        return lastQuestion;
    }

    public abstract QuestionType getQuestionType();
}
