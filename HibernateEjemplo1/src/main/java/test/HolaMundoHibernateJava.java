/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.wilmer.domain.Persona;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;

/**
 *
 * @author wilmer
 */
public class HolaMundoHibernateJava {

    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(hql);

        List<Persona> listaPersonas = query.getResultList();

        for (Persona listaPersona : listaPersonas) {
            System.out.println(listaPersona);
        }

    }
}
