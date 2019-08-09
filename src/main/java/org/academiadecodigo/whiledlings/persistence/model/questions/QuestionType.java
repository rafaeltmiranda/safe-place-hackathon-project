package org.academiadecodigo.whiledlings.persistence.model.questions;

import java.util.Arrays;
import java.util.List;

public enum QuestionType {

    TEXT,

    OPTIONS;

    public static List<QuestionType> list() {
        return Arrays.asList(QuestionType.values());
    }

}
