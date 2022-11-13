/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanque;

import cours.classes.persistance.Client;
import cours.classes.persistance.ClientService;
import cours.classes.persistance.Compte;
import cours.hibernate.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author selwa.elfirdoussi
 */
public class TestCompte {
    public static void main(String[] args) {
         
        // builds a session factory from the service registry
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
         
        // obtains the session       
        session.beginTransaction();
         
        Compte compteBerrada = new Compte();
         
        Client clt = (Client) session.load(Client.class, 2);
         
        compteBerrada.setClient(clt);
        compteBerrada.setSolde(1600000);
        Set<Compte> comptes = new HashSet<Compte>();
        comptes.add(compteBerrada);
        clt.setComptes(comptes);
         
        session.save(clt);
         
        session.getTransaction().commit();
        session.close();       
    }
}
