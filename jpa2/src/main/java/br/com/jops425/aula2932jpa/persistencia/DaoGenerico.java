package br.com.jops425.aula2932jpa.persistencia;

import br.com.jops425.aula2932jpa.model.EntidadeBase;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DaoGenerico<T extends EntidadeBase> {
	
	private static EntityManager manager = ConnectionFactory.getEntityManager();;
	
	public T findById(Class<T> clazz, Long id){
		return manager.find(clazz, id);
	}
	
	public T saveOrUpdate(T obj){
		try{
			manager.getTransaction().begin();
			if(obj.getId() == null){
				manager.persist(obj);
			}else{
				manager.merge(obj);
			}
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}
		return obj;
	}
	
	public void remove(Class<T> clazz, Long id){
		T t = findById(clazz, id);
		try{
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	public List<T> getList(Class<T> persistedClass) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return manager.createQuery(query).getResultList();
	}

}
