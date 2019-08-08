package org.academiadecodigo.whiledlings.persistence.model;

import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer extends AbstractModel{

    @ManyToOne
    private Question question;

    @ManyToOne
    private Person person;

    private String answer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
