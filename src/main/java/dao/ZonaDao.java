package dao;

import entidade.Zona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ZonaDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Zona zona){
        em.getTransaction().begin();
        em.persist(zona);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public void alterar(Zona zona){
        em.getTransaction().begin();
        em.merge(zona);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public void excluir(int id){
        Zona zona = em.find(Zona.class, id);
        em.getTransaction().begin();
        em.remove(zona);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public Zona buscarId(int id){
        Zona zona = em.find(Zona.class, id);
        return zona;
    }
    public List<Zona> lista(){
        List<Zona> zonas = em.createQuery("from Zona z").getResultList();
        return zonas;
    }

}
