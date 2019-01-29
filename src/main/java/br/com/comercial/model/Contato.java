package br.com.comercial.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "contato")
public class Contato extends GenericDomain {

    public Contato(){}

    public Contato(String email_principal, String telefone1) {
        this.email_principal = email_principal;
        this.telefone1 = telefone1;
    }

    @NotNull(message = "email principal obrigatorio")
    @NotEmpty(message = "email principal obrigatorio")
    @NotBlank(message = "email principal obrigatorio")
    @Email(message = "email inválido")
    @Length(max = 50, message = "tamanho maximo de caracteres {30}")
    @Column(length = 50, nullable = false)
    private String email_principal;


    @Email(message = "email inválido")
    @Column(length = 50)
    @Length(max = 50, message = "tamanho maximo de caracteres {30}")
    private String email_secundario;

    @NotNull(message = "email principal obrigatorio")
    @NotEmpty(message = "email principal obrigatorio")
    @NotBlank(message = "email principal obrigatorio")
    @Length(max = 15, message = "tamanho maximo de caracteres {30}")
    @Column(length = 15, nullable = false)
    private String telefone1;

    @Length(max = 15, message = "tamanho maximo de caracteres {30}")
    @Column(length = 15)
    private String telefone2;

    public String getEmail_principal() {
        return email_principal;
    }

    public void setEmail_principal(String email_principal) {
        this.email_principal = email_principal;
    }

    public String getEmail_secundario() {
        return email_secundario;
    }

    public void setEmail_secundario(String email_secundario) {
        this.email_secundario = email_secundario;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(email_principal, contato.email_principal) &&
                Objects.equals(telefone1, contato.telefone1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email_principal, telefone1);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "email_principal='" + email_principal + '\'' +
                ", email_secundario='" + email_secundario + '\'' +
                ", telefone1='" + telefone1 + '\'' +
                ", telefone2='" + telefone2 + '\'' +
                '}';
    }
}
