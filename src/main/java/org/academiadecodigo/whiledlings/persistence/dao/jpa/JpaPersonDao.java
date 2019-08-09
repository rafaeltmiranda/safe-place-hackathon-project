package org.academiadecodigo.whiledlings.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.persistence.dao.PersonDao;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPersonDao extends GenericJpaDao<Person> implements PersonDao {

    public JpaPersonDao() {
        super(Person.class);
    }
}
