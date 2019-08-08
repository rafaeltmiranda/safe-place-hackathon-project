package org.academiadecodigo.whiledlings.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.persistence.dao.Dao;
import org.academiadecodigo.whiledlings.persistence.model.AbstractModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends AbstractModel> implements Dao<T> {

    private Class<T> modelType;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T getById(Integer id) {
        return entityManager.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T model) {
        return entityManager.merge(model);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(modelType, id));
    }
}
