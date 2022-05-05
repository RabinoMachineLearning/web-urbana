package com.web.usuario.SpringWeb.models;



import javax.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador {


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




    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }
    
}
