package br.zoo.model;

import javax.persistence.*;

@Entity
@Table
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVet")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String crmv;

    @Column(length = 50, nullable = false)
    private String telefone;

    @Column(length = 50, nullable = false)
    private String nome;

    public Veterinario(Integer id, String crmv, String telefone, String nome) {
        this.id = id;
        this.crmv = crmv;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Veterinario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
