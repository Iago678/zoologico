package br.zoo.model.dao.impl;

import br.zoo.model.Visitante;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;


public class VisitanteDAO extends GenericsDAO<Visitante, Integer> {

    @Override
    public Visitante inserir(Visitante obj) throws Exception {
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
    public Visitante alterar(Visitante obj) throws Exception {
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
    public Visitante apagar(Visitante obj) throws Exception {
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
    public Visitante apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Visitante v = buscar(key);
            connection.remove(v);
            connection.getTransaction().commit();
            return v;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Visitante buscar(Integer key) {
        Visitante v = connection.find(Visitante.class, key);
        return v;
    }

    @Override
    public List<Visitante> buscarTodos() {
        List<Visitante> listaVis = connection.createQuery("select v from Visitante v ").getResultList();
        return listaVis;
    }

    public List<Visitante> buscarByName(String nome){
        String jpql = "select v from Visitante v where v.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }

    public Visitante buscarByLoginAndSenha(String login, String senha){
        String jpql = "select v from Visitante v where v.login = :log and v.senha = :sen";
        Query q = connection.createQuery(jpql);
        q.setParameter("log",login);
        q.setParameter("sen",CriptoUtil.getHash(senha));
        try {
            return (Visitante) q.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (NonUniqueResultException e){
            return null;
        }

    }

}
