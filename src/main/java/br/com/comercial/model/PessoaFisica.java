package br.com.comercial.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "pfisica")
public class PessoaFisica extends Pessoa {

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

    @Column(length = 13, nullable = false)
    @NotNull(message = "informe campo CPF")
    @NotEmpty(message = "informe campo nome CPF")
    @NotBlank(message = "informe campo nome CPF")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(length = 10)
    private String rg;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "informe campo data de nascimento")
    @NotEmpty(message = "informe campo data de nascimento")
    @NotBlank(message = "informe campo data de nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contato", referencedColumnName = "id")
    @org.hibernate.annotations.ForeignKey(name = "fk_contato")
    private Contato contato;


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
