package org.academiadecodigo.whiledlings.exceptions;

import org.academiadecodigo.whiledlings.exceptions.errors.ErrorMessage;

public class QuestionNotFoundException extends OurCorlorsNotFoundException {

    public QuestionNotFoundException() {
        super(ErrorMessage.QUESTION_NOT_FOUND);
    }
}
