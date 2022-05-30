package dao;

import entidade.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();

   
    public Cliente buscarCNH(String cnh)throws Exception{
        Cliente cliente = em.find(Cliente.class, cnh);
        return cliente;
    }
  
    public void salvar(Cliente cliente) throws Exception{
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    
}
