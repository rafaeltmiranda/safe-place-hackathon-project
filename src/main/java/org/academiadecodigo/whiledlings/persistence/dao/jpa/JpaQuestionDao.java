package org.academiadecodigo.whiledlings.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.persistence.dao.QuestionDao;
import org.academiadecodigo.whiledlings.persistence.model.questions.Question;

public class JpaQuestionDao extends GenericJpaDao<Question> implements QuestionDao {

    public JpaQuestionDao() {
        super(Question.class);
    }
}
