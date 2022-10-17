/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes;

import cours.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author selwa.elfirdoussi
 */
public class ClientService {
    
    public static int createClient(Client clt) {
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();       
        Transaction tx = session.beginTransaction();
        int idClient = (int) session.save(clt);
        tx.commit();
        return idClient;
    }
    
}
