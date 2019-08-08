package org.academiadecodigo.whiledlings.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.persistence.dao.OptionDao;
import org.academiadecodigo.whiledlings.persistence.model.Option;

public class JpaOptionDao extends GenericJpaDao<Option> implements OptionDao {

    public JpaOptionDao() {
        super(Option.class);
    }
}
