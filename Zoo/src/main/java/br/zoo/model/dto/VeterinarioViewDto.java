package br.zoo.model.dto;

import br.zoo.model.TiposCargo;

import java.util.Date;

public class VeterinarioViewDto {

    private Integer id;
    private String nome;
    private String crmv;
    private String telefone;


    public VeterinarioViewDto() {
    }

    public VeterinarioViewDto(Integer id, String nome, String crmv, String telefone) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
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
}
