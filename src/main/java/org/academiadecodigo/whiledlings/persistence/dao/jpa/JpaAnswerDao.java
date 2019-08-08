package org.academiadecodigo.whiledlings.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.persistence.dao.AnswerDao;
import org.academiadecodigo.whiledlings.persistence.model.Answer;
import org.springframework.stereotype.Component;

@Component
public class JpaAnswerDao extends GenericJpaDao<Answer> implements AnswerDao {

    public JpaAnswerDao() {
        super(Answer.class);
    }
}
