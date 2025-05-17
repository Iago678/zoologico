package br.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Admins")
public class Admin extends Usuario{

    public Admin() {
    }

    public Admin(Integer id, String nome, String login, String senha, Date dataUltimoAcesso, ETipoUsuario tipo) {
        super(id, nome, login, senha, dataUltimoAcesso, tipo);
    }
}
