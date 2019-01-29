package br.com.comercial.testes;

import br.com.comercial.model.Pessoa;
import br.com.comercial.model.PessoaFisica;
import br.com.comercial.repository.IPessaoDaoImpl;

public class TestPessoas {

    IPessaoDaoImpl p = new IPessaoDaoImpl();


    public void salvarP(){
        Pessoa p = new PessoaFisica();
        ((PessoaFisica) p).setNome("Davis");
    }
}
