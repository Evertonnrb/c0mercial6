package br.com.comercial.dao;

import br.com.comercial.util.JPAUtil;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<E> {

    private Class<E> classe;
    private EntityManager em = JPAUtil.getEntityManager();
    private EntityTransaction transaction;

    @SuppressWarnings("unchecked")
    public GenericDao(){
        this.classe =
                (Class<E>)((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public boolean salvar(E e) {
        transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        return true;
    }

    public E merge(E e) {
        transaction = em.getTransaction();
        transaction.begin();
        em.merge(e);
        transaction.commit();
        return e;
    }

    public boolean remover(E e) {
        transaction = em.getTransaction();
        transaction.begin();
        em.remove(e);
        transaction.commit();
        return true;
    }

    public List<E> listar(Class<E> e) {
        transaction = em.getTransaction();
        transaction.begin();
        List<E> retorno = em.createQuery("from "+e.getName()).getResultList();
        transaction.commit();
        return retorno;
    }

    public List<E> listarEntidade() {
        transaction = em.getTransaction();
        transaction.begin();
        List<E> retorno = em.createQuery("from "+classe).getResultList();
        transaction.commit();
        return retorno;
    }

    public E pesquisarPorCodigo(Long cod){
        transaction = em.getTransaction();
        transaction.begin();
        E retorno = (E) em.createQuery("select from "+classe+" where id = "+cod).getSingleResult();
        transaction.commit();
        return retorno;
    }





}
