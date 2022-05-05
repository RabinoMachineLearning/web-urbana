package com.web.usuario.SpringWeb.models;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioUrbana {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false) 
    private String email;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @ElementCollection
    @Column (name = "cartao", nullable = false)
    private List<String> cartao;


    public List<String> getCartao() {
        return cartao;
    }

    public void setCartao(List<String>cartao){
        this.cartao = cartao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
