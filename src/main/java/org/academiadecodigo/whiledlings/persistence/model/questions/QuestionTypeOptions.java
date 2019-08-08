package org.academiadecodigo.whiledlings.persistence.model.questions;

import org.academiadecodigo.whiledlings.persistence.model.Option;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionTypeOptions extends Question{

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "question", // TODO - Verificar se funciona sem usar a anotação Table na class Question
            fetch = FetchType.EAGER
    )
    List<Option> options = new ArrayList<>();

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.OPTIONS;
    }
}
