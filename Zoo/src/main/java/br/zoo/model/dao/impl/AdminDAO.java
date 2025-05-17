package br.zoo.model.dao.impl;

import br.zoo.model.Admin;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

import static br.zoo.model.Usuario_.nome;

public class AdminDAO extends GenericsDAO<Admin, Integer> {
    @Override
    public Admin inserir(Admin obj) throws Exception {
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
    public Admin alterar(Admin obj) throws Exception {
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
    public Admin apagar(Admin obj) throws Exception {
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
    public Admin apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Admin a = buscar(key);
            connection.remove(a);
            connection.getTransaction().commit();
            return a;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Admin buscar(Integer key) {
        Admin a = connection.find(Admin.class, key);
        return a;
    }

    @Override
    public List<Admin> buscarTodos() {
        String jpql = "select a from Admin a where a.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }
}
