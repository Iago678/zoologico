package br.zoo.model.dto;

import br.zoo.model.SaudeAnimal;
import br.zoo.model.SexoAnimal;
import br.zoo.model.TiposCargo;

import java.util.Date;

public class FuncionariosViewDto {

    private Integer id;
    private String nome;
    private String login;
    private TiposCargo cargo;
    private Date dataUltimoAcesso;
    private double salario;

    public FuncionariosViewDto() {
    }

    public FuncionariosViewDto(Integer id, String nome, String login, TiposCargo cargo, Date dataUltimoAcesso, double salario) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.cargo = cargo;
        this.dataUltimoAcesso = dataUltimoAcesso;
        this.salario = salario;
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

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public TiposCargo getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCargo(TiposCargo cargo) {
        this.cargo = cargo;

    }
}
