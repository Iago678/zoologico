package br.zoo.model.dao.impl;

import br.zoo.model.Usuario;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

public class UsuarioDAO extends GenericsDAO<Usuario, Integer> {

    public UsuarioDAO() {
        super();
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public Usuario inserir(Usuario obj) throws Exception {
        return null;
    }

    @Override
    public Usuario alterar(Usuario obj) throws Exception {
        return null;
    }

    @Override
    public Usuario apagar(Usuario obj) throws Exception {
        return null;
    }

    @Override
    public Usuario apagarByKey(Integer key) throws Exception {
        return null;
    }

    @Override
    public Usuario buscar(Integer key) {
        Usuario u = connection.find(Usuario.class, key);
        return u;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return List.of();
    }

    public Usuario buscarByLoginAndSenha(String login, String senha){
        String jpql = "select u from Usuario u where u.login = :log and u.senha = :sen";
        Query q = connection.createQuery(jpql);
        q.setParameter("log",login);
        q.setParameter("sen", CriptoUtil.getHash(senha));
        try {
            return (Usuario) q.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (NonUniqueResultException e){
            return null;
        }
    }

    public Date buscarUltimoAcesso(Integer idUsuario) {
        String jpql = "SELECT MAX(u.dataUltimoAcesso) FROM Usuario u";
        Query q = connection.createQuery(jpql);
        q.setParameter("id", idUsuario);

        try{
            return (Date) q.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }
}
