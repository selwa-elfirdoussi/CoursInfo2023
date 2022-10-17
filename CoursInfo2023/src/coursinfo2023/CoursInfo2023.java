/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursinfo2023;

import cours.classes.Client;
import cours.classes.ClientService;

/**
 *
 * @author selwa.elfirdoussi
 */
public class CoursInfo2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client berrada = new Client();
        berrada.setNomClient("Berrada");
        berrada.setPrenomClient("youssef");
        berrada.setSalaire(20000);
        
        int idClt = ClientService.createClient(berrada);
        
        System.out.println("client crée avec id "+ idClt);
             
    }
    
}
