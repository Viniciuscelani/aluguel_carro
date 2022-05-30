package dao;

import entidade.Aluguel;
import entidade.Zona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AluguelDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Aluguel aluguel) throws Exception{
        em.getTransaction().begin();
        em.persist(aluguel);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
