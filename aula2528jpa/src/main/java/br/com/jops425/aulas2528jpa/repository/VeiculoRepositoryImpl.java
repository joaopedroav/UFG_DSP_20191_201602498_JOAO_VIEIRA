package br.com.jops425.aulas2528jpa.repository;

import br.com.jops425.aulas2528jpa.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aluno on 24/04/19.
 */
public class VeiculoRepositoryImpl implements VeiculoRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.jops425.aulas2528jpa");
    private EntityManager em;

    public VeiculoRepositoryImpl() {
        em = emf.createEntityManager();
    }

    @Override
    public Veiculo create(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public Veiculo read(Long id) {
        Veiculo veiculo = em.find(Veiculo.class, id);
        return veiculo;
    }

    @Override
    public List<Veiculo> findByModelo(String modelo) {
        Query query = em.createQuery("Select v from Veiculo v where v.modelo like :modelo");
        query.setParameter("modelo", modelo);
        return query.getResultList();
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        em.getTransaction().begin();
        veiculo = em.merge(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }
}
