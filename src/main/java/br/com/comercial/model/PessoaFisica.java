package br.com.comercial.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pfisica")
public class PessoaFisica extends Pessoa {

    public PessoaFisica(){}

    public PessoaFisica(String cpf, String rg, Date dataNascimento, Contato contato, Usuario usuario) {
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.contato = contato;
        this.usuario = usuario;
    }

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

    @NotNull
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_usuario")
    private Usuario usuario;


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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(cpf, that.cpf) &&
                Objects.equals(rg, that.rg) &&
                Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, rg, dataNascimento);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", contato=" + contato +
                ", usuario=" + usuario +
                '}';
    }
}
