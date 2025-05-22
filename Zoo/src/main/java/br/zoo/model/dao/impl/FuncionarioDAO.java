package br.zoo.model.dao.impl;

import br.zoo.model.Funcionario;
import br.zoo.model.Visitante;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.model.dto.AnimaisViewDto;
import br.zoo.model.dto.FuncionariosViewDto;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


public class FuncionarioDAO extends GenericsDAO<Funcionario, Integer> {
    @Override
    public Funcionario inserir(Funcionario obj) throws Exception {
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
    public Funcionario alterar(Funcionario obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.merge(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario apagar(Funcionario obj) throws Exception {
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
    public Funcionario apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Funcionario f = buscar(key);
            connection.remove(f);
            connection.getTransaction().commit();
            return f;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario buscar(Integer key) {
        Funcionario f = connection.find(Funcionario.class, key);
        return f;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        String jpql = "select f from Funcionario f";
        Query q = connection.createQuery(jpql);
        return q.getResultList();
    }

    public List<Funcionario> buscarByName(String nome){
        String jpql = "select f from Funcionario f where f.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }
    public List<FuncionariosViewDto> buscarTodosView() {
        String jpql = "select new br.zoo.model.dto.FuncionariosViewDto(" +
                "f.id, f.nome, f.login, f.cargo, f.dataUltimoAcesso, f.salario)" +
                "from Funcionario f";
        Query q = connection.createQuery(jpql);
        return q.getResultList();
    }
}
