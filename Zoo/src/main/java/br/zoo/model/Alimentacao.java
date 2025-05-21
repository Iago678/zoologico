package br.zoo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Alimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlimentacao")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column
    private boolean foiAlimentado;

    public Alimentacao() {
    }

    public Alimentacao(Integer id, Animal animal, Funcionario funcionario, Date data, boolean foiAlimentado) {
        this.id = id;
        this.animal = animal;
        this.funcionario = funcionario;
        this.data = data;
        this.foiAlimentado = foiAlimentado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isFoiAlimentado() {
        return foiAlimentado;
    }

    public void setFoiAlimentado(boolean foiAlimentado) {
        this.foiAlimentado = foiAlimentado;
    }
}
