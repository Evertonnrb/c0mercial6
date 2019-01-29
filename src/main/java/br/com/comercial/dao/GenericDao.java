package br.com.comercial.dao;

import br.com.comercial.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDao<E> {

    private EntityManager em = JPAUtil.getEntityManager();
    private EntityTransaction transaction;

    public boolean salvar(E e){
        transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        return true;
    }
}
