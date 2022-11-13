/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes.persistance;

import cours.hibernate.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author selwa.elfirdoussi
 */
public class CompteService {
    
    public static void createCompte(Client clt, Compte cpt){
        // builds a session factory from the service registry
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
         
        // obtains the session       
        session.beginTransaction();
         
        cpt.setClient(clt);
        Set<Compte> comptes = new HashSet<Compte>();
        comptes.add(cpt);
        clt.setComptes(comptes);
         
        session.save(clt);
         
        session.getTransaction().commit();
        session.close();       
    }
    
    public static List listComptes(){
         SessionFactory sessionFact = HibernateUtil.getSessionFactory();
         Session session = sessionFact.openSession();
         List listComptes = session.createQuery("from Compte ").list();
         return listComptes;
    }
    
}
