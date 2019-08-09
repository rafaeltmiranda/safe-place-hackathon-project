package org.academiadecodigo.whiledlings.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class AnswerDTO {

    private int id;

    @NotNull(message="Answer this question is important. Be heard")
    @NotBlank(message = "Answer this question is important. Be heard")
    @Size(min = 3)
    private String answer;
    private Integer question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }
}
