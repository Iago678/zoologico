package br.zoo.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idUser")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String login;

    @Column(length = 70, nullable = false)
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimoAcesso;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private ETipoUsuario tipo; //USER, ADMIN, VISITANTE, FUNCIONARIO

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
