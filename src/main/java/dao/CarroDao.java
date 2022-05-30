package dao;

import entidade.Carro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();

   
    public Carro buscarPlaca(String placa) throws Exception{
        Carro carro = em.find(Carro.class, placa);
        return carro;
    }
    
    public void salvar(Carro carro) throws Exception{
        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
