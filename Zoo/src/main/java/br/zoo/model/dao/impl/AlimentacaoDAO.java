package br.zoo.model.dao.impl;

import br.zoo.model.Alimentacao;
import br.zoo.model.Usuario;
import br.zoo.model.dao.GenericsDAO;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class AlimentacaoDAO extends GenericsDAO<Alimentacao, Integer> {

    @Override
    public Alimentacao inserir(Alimentacao obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.persist(obj);
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
    public Alimentacao alterar(Alimentacao obj) throws Exception {
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
    public Alimentacao apagar(Alimentacao obj) throws Exception {
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
    public Alimentacao apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Alimentacao a = buscar(key);
            connection.remove(a);
            connection.getTransaction().commit();
            return a;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Alimentacao buscar(Integer key) {
        Alimentacao a = connection.find(Alimentacao.class, key);
        return a;
    }

    @Override
    public List<Alimentacao> buscarTodos() {
        List<Alimentacao> listaAge = connection.createQuery("select a from Alimentacao a ").getResultList();
        return listaAge;
    }

    public List<Alimentacao> buscarByDate(LocalDate data){
        String jpql = "select a from Alimentacao a where a.dia = :data";
        Query q = connection.createQuery(jpql);
        q.setParameter("data", data);
        return q.getResultList();
    }

    public boolean foiAlimentadoHoje(Integer idAnimal){
        String jpql = "SELECT COUNT(a) FROM Alimentacao a WHERE a.animal.id = :idAnimal AND a.data = :hoje";
        Query q = connection.createQuery(jpql);
        q.setParameter("idAnimal", idAnimal);
        q.setParameter("hoje", LocalDate.now());

        Long count = (Long) q.getSingleResult();
        return count > 0;
    }
}
