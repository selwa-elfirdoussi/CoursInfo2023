/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes.persistance;

import java.util.Set;

/**
 *
 * @author selwa.elfirdoussi
 */
public class Client {
    
  private int idClient;
  private String nomClient;
  private String prenomClient;
  private float salaire;
  private Set<Compte> comptes;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + nomClient + " "+  prenomClient + "}";
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
  
  

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }
  
  
    
}
