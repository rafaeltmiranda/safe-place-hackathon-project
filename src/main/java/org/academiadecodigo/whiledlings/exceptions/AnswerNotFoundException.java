package org.academiadecodigo.whiledlings.exceptions;

import org.academiadecodigo.whiledlings.exceptions.errors.ErrorMessage;

public class AnswerNotFoundException extends OurCorlorsNotFoundException {

    public AnswerNotFoundException() {

        super(ErrorMessage.ANSWER_NOT_FOUND);
    }
}
