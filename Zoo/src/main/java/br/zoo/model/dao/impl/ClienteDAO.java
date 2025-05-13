package br.zoo.model.dao.impl;

import br.zoo.model.Cliente;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;


public class ClienteDAO extends GenericsDAO<Cliente, Integer> {


    @Override
    public Cliente inserir(Cliente obj) throws Exception {
        try {
            connection.getTransaction().begin();
            obj.setSenha(CriptoUtil.getHash( obj.getSenha() ));
            connection.merge(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
        finally {
            close();
        }
    }

    @Override
    public Cliente alterar(Cliente obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.persist(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Cliente apagar(Cliente obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.remove(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Cliente apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Cliente c = buscar(key);
            connection.remove(c);
            connection.getTransaction().commit();
            return c;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Cliente buscar(Integer key) {
        Cliente c = connection.find(Cliente.class, key);
        return c;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> listaCli = connection.createQuery("select c from Cliente c ").getResultList();
        return listaCli;
    }

    public List<Cliente> buscarByName(String nome){
        String jpql = "select c from Cliente c where c.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }

    public Cliente buscarByLoginAndSenha(String login, String senha){
        String jpql = "select c from Cliente c where c.login = :log and c.senha = :sen";
        Query q = connection.createQuery(jpql);
        q.setParameter("log",login);
        q.setParameter("sen",CriptoUtil.getHash(senha));
        try {
            return (Cliente) q.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (NonUniqueResultException e){
            return null;
        }

    }

}
