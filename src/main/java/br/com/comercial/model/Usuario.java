package br.com.comercial.model;


import enums.Perfil;
import enums.Status;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa {

    @Column(nullable = false,length = 64)
    @NotNull(message = "informe o login")
    @NotEmpty(message = "informe o login")
    @NotBlank(message = "informe o login")
    @Length(max = 64,message = "login de usuário não deve ter mais que {max} caracteres")
    private String login;

    @Column(nullable = false,length = 64)
    @NotNull(message = "informe a senha")
    @NotEmpty(message = "informe a senha")
    @NotBlank(message = "informe a senha")
    @Length(max = 64,message = "a senha de usuário não deve ter mais que {max} bits")
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro",nullable = false)
    @NotNull(message = "data de cadastro atributo obrigatorio")
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        super();
        this.login = login;
        this.login = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(login, usuario.login) &&
                Objects.equals(senha, usuario.senha) &&
                perfil == usuario.perfil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, senha, perfil);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", status=" + status +
                ", perfil=" + perfil +
                '}';
    }
}
