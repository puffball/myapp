package myapp.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import myapp.entity.MyEntity;

@Stateless
public class MyServiceBean {

	@Inject
	private Logger log;

	@PersistenceContext
	private EntityManager em;
	
	public List<MyEntity> findAll() {
		log.info("findAll");
		TypedQuery<MyEntity> query = em.createQuery("select e from MyEntity e", MyEntity.class);
		return query.getResultList();
	}

	public MyEntity findById(long id) {
		log.info("findById: id=" + id);
		return em.find(MyEntity.class, id);
	}

	public MyEntity merge(MyEntity entity) {
		log.info("merge");
		return em.merge(entity);
	}
}
