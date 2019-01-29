package br.com.comercial.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "endereco")
public class Endereco extends GenericDomain{

    public Endereco(){}

    public Endereco(String lagradouro, String numero, String complemento, String bairro, String cep, Cidade cidade, Estado estado) {
        this.lagradouro = lagradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Column(length = 128,nullable = false)
    @NotNull(message = "lagradouro deve ser informado")
    @NotBlank(message = "lagradoro não pode estar vazio")
    @NotEmpty(message = "Informe o campo lagradouro")
    private String lagradouro;

    @Column(length = 32,nullable = false)
    @NotNull(message = "preencha o campo número")
    @NotBlank(message = "preencha o campo número")
    @NotEmpty(message = "preencha o campo número")
    private String numero;

    @Column(length = 64)
    @Length(max = 64, message = "complemento não deve ter mais que {max} caracteres")
    private String complemento;

    @Column(length = 32,nullable = false)
    @NotNull(message = "preencha o campo bairro")
    @NotBlank(message = "preencha o campo bairro")
    @NotEmpty(message = "preencha o campo bairro")
    private String bairro;

    @Column(length = 10,nullable = false)
    @Length(max = 10, message = "campo CEP não deve ter mais que {max} caracteres")
    @NotNull(message = "preencha o campo número")
    @NotBlank(message = "preencha o campo número")
    @NotEmpty(message = "preencha o campo número")
    private String cep;

    @NotNull(message = "Cidade deve ser informada")
    @OneToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade",referencedColumnName = "id")
    @org.hibernate.annotations.ForeignKey(name = "cidade_id")
    private Cidade cidade;

    @NotNull(message = "estado deve ser informado")
    @OneToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "estado",referencedColumnName = "id")
    @org.hibernate.annotations.ForeignKey(name = "estado_id")
    private Estado estado;

    public String getLagradouro() {
        return lagradouro;
    }

    public void setLagradouro(String lagradouro) {
        this.lagradouro = lagradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(numero, endereco.numero) &&
                Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cep);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "lagradouro='" + lagradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade=" + cidade +
                ", estado=" + estado +
                '}';
    }
}
