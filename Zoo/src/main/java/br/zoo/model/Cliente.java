package br.zoo.model;

import java.util.Date;

public class Cliente extends Usuario{
    public Cliente() {
    }

    public Cliente(Integer id, String nome, String login, String senha, Date dataUltimoAcesso, ETipoUsuario tipo) {
        super(id, nome, login, senha, dataUltimoAcesso, tipo);
    }
}
