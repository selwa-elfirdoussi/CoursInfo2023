/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursinfo2023;

import cours.classes.persistance.Client;
import cours.classes.persistance.ClientService;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author selwa.elfirdoussi
 */
public class CoursInfo2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Client Youssef = new Client();
        Youssef.setNomClient("Hamid");
        Youssef.setPrenomClient("Ilham");
        Youssef.setSalaire(12000);
        
        int idYoussef = ClientService.createClient(Youssef);
        
        System.out.println("client crée avec id = " + idYoussef);
             
        List listClient = ClientService.listClient();
        Iterator it = listClient.iterator();
        while (it.hasNext()) {
            Client clt = (Client) it.next();
            System.out.println("client " + clt);
        }
                   */
       System.out.println("donnez l'identifiant du client que vous voulez augmenter ");
       Scanner scan = new Scanner(System.in);
       int id = scan.nextInt();
       
       Client clt = ClientService.loadClient(id);
    
       System.out.println("client est " + clt);
       
       System.out.println("donner le nouveau salaire ");
       float newSalaire = scan.nextFloat();
       clt.setSalaire(newSalaire);
       
       ClientService.updateClient(clt);
       
       ClientService.deleteClient(clt);
               
             
    }
    
}
