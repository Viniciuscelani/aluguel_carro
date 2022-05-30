/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Bairro;
import entidade.Zona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vini
 */
public class BairroDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Bairro bairro) throws Exception{
        em.getTransaction().begin();
        em.persist(bairro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public List<Bairro> lista(){
        List<Bairro> bairros = em.createQuery("from Bairro b").getResultList();
        return bairros;
    }
}
