package com.workproject.simplewebapp.control;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractDao<T extends Serializable> {
	private final Class<T> clazz;
	@Inject
	private EntityManager em;
	
	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T find(Object id) {
		return em.find(clazz, id);
	}
	
	public void persist(final T entity) {
		em.persist(entity);
	}
	
	public List<T> findAll() {
		final CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(clazz);
		criteriaQuery.select(criteriaQuery.from(clazz));
		return em.createQuery(criteriaQuery).getResultList();
	}
	public void deleteAll() {
		final CriteriaDelete<T> criteriaDelete = em.getCriteriaBuilder().createCriteriaDelete(clazz);
		criteriaDelete.from(clazz);
		em.createQuery(criteriaDelete).executeUpdate();
	}
}
