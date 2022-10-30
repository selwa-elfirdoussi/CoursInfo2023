/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes.persistance;

import cours.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author selwa.elfirdoussi
 */
public class ClientService {
    
    private static Session session;
    
    public static int createClient(Client clt) {
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();
        int idClient = (int) session.save(clt);
        tx.commit();
        session.close();
        return idClient;
    }
    
    public static Client loadClient(int idClient) {
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        session = sessionFact.openSession();
        Client clt = (Client) session.load(Client.class, new Integer(idClient));
        return clt;
    }
    
    public static void updateClient(Client clt) {
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.update(clt);
        tx.commit();
        session.close();
    }
    
    public static void deleteClient(Client clt) {
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(clt);
        tx.commit();
        session.close();
    }
    
    public static List listClient(){
         SessionFactory sessionFact = HibernateUtil.getSessionFactory();
         Session session = sessionFact.openSession();
         List listClient = session.createQuery("from Client ").list();
         return listClient;
    }
    
    
}
