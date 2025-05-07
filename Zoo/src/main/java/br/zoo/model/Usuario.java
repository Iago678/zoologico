package br.zoo.model;

import java.util.Date;

public class Usuario {
    private Integer id;
    private String nome;
    private String login;

    private String senha;

    private Date dataUltimoAcesso;

    private ETipoUsuario tipo; //USER, ADMIN, CLIENTE

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String login, String senha, Date dataUltimoAcesso, ETipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataUltimoAcesso = dataUltimoAcesso;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public ETipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(ETipoUsuario tipo) {
        this.tipo = tipo;
    }
}
