/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Atendente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ViniDev
 */
public class AtendenteDao {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public Atendente buscarSenha(String senha)throws Exception{
        Atendente atendente = em.find(Atendente.class, senha);
        return atendente;
    }

    
     public void salvar(Atendente atendente) throws Exception{
        em.getTransaction().begin();
        em.persist(atendente);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
