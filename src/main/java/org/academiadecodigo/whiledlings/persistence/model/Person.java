package org.academiadecodigo.whiledlings.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person extends AbstractModel {

    private String name;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "person",
            fetch = FetchType.EAGER
    )
    private List<Answer> answers = new ArrayList<>();

    /**
     * Get name of the person
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the person
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get list of all answers of the person
     * @return answersList
     */
    public List<Answer> getAnswersList() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void saveAnswer(Answer answer) {
        answers.add(answer);
    }
}
