package br.zoo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnimal")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String nomeCientifico;

    @Column(length = 50, nullable = false)
    private String especie;

    @Column(length = 40)
    private Date dataChegada;

    @Column(length = 20, nullable = false)
    private SaudeAnimal estadoSaude; // SAUDAVEL, DOENTE, TRATAMENTO

    @Column(length = 20, nullable = false)
    private SexoAnimal sexoAnimal; //MACHO, FEMEA

    @Column(length = 20, nullable = false)
    private int idade;

    @Column(length = 20, nullable = false)
    private boolean emExpo;

    @Column(length = 20, nullable = false)
    private Habitat habitat; // FLORESTA, SAVANA, DESERTO, MONTANHA, POLAR, AQUATICO;

    @Column(length = 20, nullable = false)
    private Recinto recinto; // VIVEIRO_AVES, TERRARIO_REPTEIS, AQUARIO, CERCADO_GRANDES_MAMIFEROS, BORBOLETARIO, PRIMATAS,


    public Animal(Integer id, String nome, String nomeCientifico, String especie, Date dataChegada, SaudeAnimal estadoSaude, SexoAnimal sexoAnimal, int idade, boolean emExpo, Habitat habitat, Recinto recinto) {
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

    public Animal() {
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

    public SexoAnimal getSexo() {
        return sexoAnimal;
    }

    public void setSexo(SexoAnimal sexoAnimal) {
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

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
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
}
