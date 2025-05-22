package br.zoo.model;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "data", nullable = false)
    private LocalDate data;


    public Alimentacao() {
    }

    public Alimentacao(Integer id, Animal animal, Funcionario funcionario, LocalDate data) {
        this.id = id;
        this.animal = animal;
        this.funcionario = funcionario;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
