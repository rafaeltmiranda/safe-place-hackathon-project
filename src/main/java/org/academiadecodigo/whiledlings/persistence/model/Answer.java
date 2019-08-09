package org.academiadecodigo.whiledlings.persistence.model;

import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer extends AbstractModel{

    private Integer idQuestion;

    @ManyToOne
    private Person person;

    private String answer;

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
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
