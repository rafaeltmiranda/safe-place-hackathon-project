package org.academiadecodigo.whiledlings.commands;

import org.academiadecodigo.whiledlings.persistence.model.Answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class PersonDTO {

    private int id;

    @NotNull(message = "Your name is important.")
    @NotBlank(message = "Show how people can call you. Write your name")
    @Size(min = 3, max = 64)
    private String name;
    private List<Answer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
