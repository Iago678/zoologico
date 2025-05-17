package br.zoo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVisita")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario user;

    @Column(nullable = false)
    private LocalDate dia;

    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false)
    private int qtdPessoas;

    public Agendamento(Integer id, Usuario user, LocalDate dia, LocalTime horario, int qtdPessoas) {
        this.id = id;
        this.user = user;
        this.dia = dia;
        this.horario = horario;
        this.qtdPessoas = qtdPessoas;
    }

    public Agendamento() {
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
