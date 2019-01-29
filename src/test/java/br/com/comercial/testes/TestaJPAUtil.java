package br.com.comercial.testes;

import br.com.comercial.util.JPAUtil;
import org.junit.Test;

public class TestaJPAUtil {

    @Test
    public void testarPeristence(){
        JPAUtil.getEntityManager();
    }

}
