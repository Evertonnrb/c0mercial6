package br.com.comercial.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pjuridica")
public class PessoaJuridica extends Pessoa {

    @Column(length = 15)
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    @Column(length = 15, name = "inscricao_estadual")
    @NotNull(message = "informe inscrição estadual")
    @NotBlank(message = "informe inscrição estadual")
    @NotEmpty(message = "informe inscrição estadual")
    private String ie;

    @Column(length = 15, name = "razao_social")
    @NotNull(message = "informe razão social")
    @NotBlank(message = "informe razão social")
    @NotEmpty(message = "informe razão social")
    private String razaoSocial;

    @NotNull
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_usuario")
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contato", referencedColumnName = "id")
    @org.hibernate.annotations.ForeignKey(name = "fk_contato")
    private Contato contato;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(ie, that.ie) &&
                Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, ie, razaoSocial);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", ie='" + ie + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", usuario=" + usuario +
                ", contato=" + contato +
                '}';
    }
}
