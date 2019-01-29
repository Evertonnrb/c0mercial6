package br.com.comercial.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends GenericDomain {

    @Column(length = 124, nullable = false)
    @NotNull(message = "informe campo nome")
    @NotEmpty(message = "informe campo nome")
    @NotBlank(message = "informe campo nome")
    private String nome;

    @Column(length = 124, nullable = false)
    @NotNull(message = "informe campo sobrenome")
    @NotEmpty(message = "informe campo sobrenome")
    @NotBlank(message = "informe campo sobrenome")
    private String sobenome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobenome() {
        return sobenome;
    }

    public void setSobenome(String sobenome) {
        this.sobenome = sobenome;
    }
}
