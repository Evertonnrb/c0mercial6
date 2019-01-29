package br.com.comercial.model;


import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends GenericDomain {

    @NotNull
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "endereco")
    @JoinColumn(name = "endereco",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_endereco")
    private List<Endereco> enderecos = new ArrayList<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
