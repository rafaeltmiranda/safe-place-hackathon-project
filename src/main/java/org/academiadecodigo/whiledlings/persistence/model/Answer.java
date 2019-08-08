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

}
