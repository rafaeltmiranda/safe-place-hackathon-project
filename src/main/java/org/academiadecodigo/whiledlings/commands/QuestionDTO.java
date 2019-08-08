package org.academiadecodigo.whiledlings.commands;

public class QuestionDTO {

    private String question;
    private boolean lastQuestion;

    public String getQuestion() {
        return question;
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
