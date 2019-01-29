package br.com.comercial.testes;

import br.com.comercial.dao.GenericDao;
import br.com.comercial.util.ValidadorUtil;
import br.com.comercial.model.Estado;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestValidacoesEstados {

    GenericDao<Estado> daoEstado = new GenericDao<Estado>();
    ValidadorUtil<Estado> estadoValidador = new ValidadorUtil<Estado>();

    Estado estado = new Estado("Estado teste2","T2");

    @Test
    public void naoDeveSalvarEstado(){
        assertFalse(daoEstado.salvar(estado));
    }

    @Test
    public void deveSavarEstado(){
        assertTrue(daoEstado.salvar(estado));
    }
}
