package br.com.comercial.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf = null;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager() {
        emf.close();
    }

}
