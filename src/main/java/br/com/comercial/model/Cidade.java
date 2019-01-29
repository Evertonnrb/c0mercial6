package br.com.comercial.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade extends GenericDomain {


    public Cidade() {
    }

    public Cidade(String nome, String sigla, Estado estado) {
        this.nome = nome;
        this.sigla = sigla;
        this.estado = estado;
    }

    @Column(name = "nome", unique = true, length = 100)
    @Length(max = 100, min = 1, message = "Nome da cidade tem que ter no maxímo {max} caracteres")
    @NotBlank(message = "Nome de estado deve ser informado")
    @NotNull(message = "Nome do estado não pode estar vazio")
    private String nome;

    @Column(name = "sigla", unique = true, length = 3)
    @Length(max = 3, min = 2, message = "Tamanho da sigla de estado inválida")
    @NotNull(message = "informe o nome da cidade")
    @NotBlank(message = "informe o nome da cidade")
    private String sigla;

    @NotNull(message = "Estado deve ser informado")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estado", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_estado")
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        Cidade cidade = (Cidade) o;
        return Objects.equals(nome, cidade.nome) &&
                Objects.equals(sigla, cidade.sigla) &&
                Objects.equals(estado, cidade.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sigla, estado);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", estado=" + estado +
                '}';
    }
}
