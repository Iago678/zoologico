package br.zoo.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class Cliente extends Usuario{
    @Column(nullable = false, length = 60)
    private String email;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String login, String senha, Date dataUltimoAcesso, ETipoUsuario tipo, String email) {
        super(id, nome, login, senha, dataUltimoAcesso, tipo);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
