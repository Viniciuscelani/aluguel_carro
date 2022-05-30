/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Bairro;
import entidade.Fabricante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vini
 */
public class FabricanteDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Fabricante fabricante) throws Exception{
        em.getTransaction().begin();
        em.persist(fabricante);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public List<Fabricante> lista(){
        List<Fabricante> fabricantes = em.createQuery("from Fabricante b").getResultList();
        return fabricantes;
    }
  
}
