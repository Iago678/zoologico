package br.zoo.model.dto;

import br.zoo.model.Animal;
import br.zoo.model.ConsultaVet;
import br.zoo.model.Veterinario;

import java.time.LocalDate;

public class VisitaVetViewDto {

    private Integer id;
    private String animalNome;
    private String vetNome;
    private LocalDate data;
    private ConsultaVet servico;
    private double valor;

    public VisitaVetViewDto() {
    }

    public VisitaVetViewDto(Integer id, String animalNome, String vetNome, LocalDate data, ConsultaVet servico, double valor) {
        this.id = id;
        this.animalNome = animalNome;
        this.vetNome = vetNome;
        this.data = data;
        this.servico = servico;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public void setAnimalNome(String animalNome) {
        this.animalNome = animalNome;
    }

    public String getVetNome() {
        return vetNome;
    }

    public void setVetNome(String vetNome) {
        this.vetNome = vetNome;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
