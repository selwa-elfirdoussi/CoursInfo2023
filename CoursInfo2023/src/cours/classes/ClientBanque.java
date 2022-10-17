/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes;

/**
 *
 * @author selwa.elfirdoussi
 */
public class ClientBanque {
    private int id;
    private String nom;
    private String prenom;
    private double salaire;

    public ClientBanque(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public ClientBanque() {
    }

    @Override
    public String toString() {
        return  nom + " " + prenom+ " - " + salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String newName) {
        nom = newName;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    
    
}
