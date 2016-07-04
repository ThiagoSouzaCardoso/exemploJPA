package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;

public class GenericDao<T> implements Dao<T> {

	private Class<T> clazz;
	protected EntityManager em;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public void adicionar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T busca(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(clazz,id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}

	@Override
	public List<T> listar() {
		em = JPAUtil.getEntityManager();
		return em.createQuery("From " + clazz.getSimpleName()).getResultList();
	}

}