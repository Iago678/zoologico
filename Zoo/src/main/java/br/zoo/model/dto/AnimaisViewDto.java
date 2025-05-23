package br.zoo.model.dto;

import br.zoo.model.Habitat;
import br.zoo.model.Recinto;
import br.zoo.model.SaudeAnimal;
import br.zoo.model.SexoAnimal;

import java.util.Date;

public class AnimaisViewDto {

    Integer id;
    String nome;
    String nomeCientifico;
    String especie;
    Date dataChegada;
    SaudeAnimal estadoSaude;
    SexoAnimal sexoAnimal;
    boolean emExpo;
    int idade;
    private Habitat habitat;
    private Recinto recinto;
    private boolean foiAlimentado;

    public AnimaisViewDto() {
    }

    public AnimaisViewDto(Integer id, String nome, String nomeCientifico, String especie, Date dataChegada, SaudeAnimal estadoSaude, SexoAnimal sexoAnimal, int idade, boolean emExpo,  Habitat habitat, Recinto recinto) {
        this.id = id;
        this.nome = nome;
        this.nomeCientifico = nomeCientifico;
        this.especie = especie;
        this.dataChegada = dataChegada;
        this.estadoSaude = estadoSaude;
        this.sexoAnimal = sexoAnimal;
        this.idade = idade;
        this.emExpo = emExpo;
        this.habitat = habitat;
        this.recinto = recinto;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public boolean isFoiAlimentado() {
        return foiAlimentado;
    }

    public void setFoiAlimentado(boolean foiAlimentado) {
        this.foiAlimentado = foiAlimentado;
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

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public SaudeAnimal getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(SaudeAnimal estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isEmExpo() {
        return emExpo;
    }

    public void setEmExpo(boolean emExpo) {
        this.emExpo = emExpo;
    }
}
