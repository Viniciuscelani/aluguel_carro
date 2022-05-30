/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Bairro;
import entidade.Modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vini
 */
public class ModeloDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Modelo modelo) throws Exception{
        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public List<Modelo> lista(){
        List<Modelo> modelos = em.createQuery("from Modelo m").getResultList();
        return modelos;
    }
}
