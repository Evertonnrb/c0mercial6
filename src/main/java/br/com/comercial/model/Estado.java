package br.com.comercial.model;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado extends GenericDomain {

    public Estado() {
    }

    public Estado(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    @Column(name = "nome",unique = true,nullable = false, length = 50)
    @Length(min = 2, max = 50, message = "Nome do estado não deve ter mais que {max} caracteres")
    @NotEmpty(message = "Nome do estado deve ser informado")
    @NotBlank(message = "Nome do estado deve ser informado")
    private String nome;

    @Column(name = "uf",unique = true, nullable = false, length = 2)
    @Length(min = 2, max = 2, message = "UF deve ter {max} caracteres")
    @NotEmpty(message = "UF deve ser informada")
    @NotBlank(message = "UF não pode esta vazio")
    private String uf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(nome, estado.nome) &&
                Objects.equals(uf, estado.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, uf);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
