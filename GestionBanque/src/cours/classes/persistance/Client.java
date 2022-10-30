/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.classes.persistance;

/**
 *
 * @author selwa.elfirdoussi
 */
public class Client {
    
  private int idClient;
  private String nomClient;
  private String prenomClient;
  private float salaire;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", salaire=" + salaire + '}';
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
