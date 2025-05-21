package br.zoo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class VisitaVet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVisita")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Veterinario vet;


    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, length = 20)
    private ConsultaVet servico; //CONSULTA, CIRURGIA, VACINA;

    @Column(nullable = true, length = 100)
    private String diagnostico;

    public VisitaVet() {
    }

    public VisitaVet(Integer id, Animal animal, Veterinario vet, LocalDate data, ConsultaVet servico, String diagnostico) {
        this.id = id;
        this.animal = animal;
        this.vet = vet;
        this.data = data;
        this.servico = servico;
        this.diagnostico = diagnostico;
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

    public Veterinario getVet() {
        return vet;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ConsultaVet getServico() {
        return servico;
    }

    public void setServico(ConsultaVet servico) {
        this.servico = servico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
