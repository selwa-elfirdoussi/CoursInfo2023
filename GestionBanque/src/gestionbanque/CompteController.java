/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanque;

import cours.classes.persistance.Client;
import cours.classes.persistance.ClientService;
import cours.classes.persistance.Compte;
import cours.classes.persistance.CompteService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author selwa.elfirdoussi
 */
public class CompteController implements Initializable {
    
    @FXML
    private TextField solde;
    
    @FXML
    private ComboBox ClientCompte;
    
    @FXML
    private TableView ListeComptes;
    
    @FXML
    private TableColumn ColClient;
    @FXML
    private TableColumn ColSolde;
    
    @FXML
    private void CreateAccount(ActionEvent event) {
        Client clt = (Client) ClientCompte.getSelectionModel().getSelectedItem();
        Compte cpt = new Compte();
        cpt.setSolde(Float.parseFloat(solde.getText()));
        CompteService.createCompte(clt, cpt);
        ListeComptes.getItems().add(cpt);
   }
    
    @FXML
    public void closeCompte(ActionEvent event){
        Stage stage = (Stage) solde.getScene().getWindow();       
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List listClient = ClientService.listClient();
        ClientCompte.getItems().addAll(listClient);
        
        //chager la liste des clients dans la table view listClient
       java.util.List listComptes = CompteService.listComptes();
       ColClient.setCellValueFactory(new PropertyValueFactory<>("Client"));
       ColSolde.setCellValueFactory(new PropertyValueFactory<>("solde"));
       
       ListeComptes.getItems().addAll(listComptes);
    }    
    
}
