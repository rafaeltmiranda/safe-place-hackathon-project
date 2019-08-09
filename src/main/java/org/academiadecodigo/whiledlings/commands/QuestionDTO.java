package org.academiadecodigo.whiledlings.commands;

public abstract class QuestionDTO {

    private Integer id;
    private String question;
    private boolean lastQuestion;

    public String getQuestion() {
        return question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isLastQuestion() {
        return lastQuestion;
    }

    public void setLastQuestion(boolean lastQuestion) {
        this.lastQuestion = lastQuestion;
    }
}
