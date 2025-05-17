package br.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Funcionarios")
public class Funcionario extends Usuario{
    @Column(nullable = false, length = 10)
    private double salario;

    @Column(nullable = false, length = 20)
    private TiposCargo cargo; // CUIDADOR, VETERINARIO, BIOLOGO, ZOOTECNISTA, CURADOR, GUIA

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String login, String senha, Date dataUltimoAcesso, ETipoUsuario tipo, double salario, TiposCargo cargo) {
        super(id, nome, login, senha, dataUltimoAcesso, tipo);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public TiposCargo getCargo() {
        return cargo;
    }

    public void setCargo(TiposCargo cargo) {
        this.cargo = cargo;
    }
}
