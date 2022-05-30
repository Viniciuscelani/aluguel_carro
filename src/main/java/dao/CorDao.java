/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Cor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vini
 */
public class CorDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Cor cor) throws Exception{
        em.getTransaction().begin();
        em.persist(cor);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public List<Cor> lista(){
        List<Cor> cors = em.createQuery("from Cor c").getResultList();
        return cors;
    }
}
