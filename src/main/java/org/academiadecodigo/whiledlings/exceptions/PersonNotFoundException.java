package org.academiadecodigo.whiledlings.exceptions;

import org.academiadecodigo.whiledlings.exceptions.errors.ErrorMessage;

public class PersonNotFoundException extends OurCorlorsNotFoundException {

    public PersonNotFoundException() {
        super(ErrorMessage.PERSON_NOT_FOUND);
    }
}
