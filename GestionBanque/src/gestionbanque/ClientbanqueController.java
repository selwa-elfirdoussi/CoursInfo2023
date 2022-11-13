/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanque;

import cours.classes.persistance.Client;
import cours.classes.persistance.ClientService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author selwa.elfirdoussi
 */
public class ClientbanqueController implements Initializable {
    @FXML
    private ComboBox civilite;
    @FXML
    private TextField name;
    @FXML
    private TextField firstName;
    @FXML
    private TextField salaire;
    @FXML
    private DatePicker birthDate;
    @FXML
    private Button closeButtom;
    
    @FXML
    private TableView ListClient;
    @FXML
    private TableColumn cltId;
    @FXML
    private TableColumn cltName;
    @FXML
    private TableColumn cltFirstName;
    @FXML
    private TableColumn cltSalaire;
    
    @FXML
    public void saveClient(ActionEvent event) {
        Client clt = new Client();
        clt.setNomClient(name.getText());
        clt.setPrenomClient(firstName.getText());
        clt.setSalaire(Float.parseFloat(salaire.getText()));
        ClientService.createClient(clt);
        ListClient.getItems().add(clt);
    }
    
    @FXML
    public void closeClient(ActionEvent event){
        Stage stage = (Stage) closeButtom.getScene().getWindow();       
        stage.close();
        System.exit(0);
    }
    
    @FXML
    public void AddAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Compte.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
   
    
    @FXML
    public void deleteClient(ActionEvent event){
        Client cltToDel = (Client) ListClient.getSelectionModel().getSelectedItem();
        Alert alertDel = new Alert(Alert.AlertType.CONFIRMATION);
        alertDel.setHeaderText("Voulez supprimer le client "+ cltToDel);
        Optional<ButtonType> result = alertDel.showAndWait();
        if (result.get() == ButtonType.OK){
            ClientService.deleteClient(cltToDel);
            ListClient.getItems().remove(cltToDel);
        } else {
            closeClient(event);
        }
    }
    
    @FXML
    public void editFirstNameFromList(TableColumn.CellEditEvent<Client,String> 
        ClientFirstNameEvent){
        Client cltToEdit = (Client) ListClient.getSelectionModel().getSelectedItem();
        cltToEdit.setPrenomClient(ClientFirstNameEvent.getNewValue());
        ClientService.updateClient(cltToEdit);
    }
    
    @FXML
    public void editSalaireFromList(TableColumn.CellEditEvent<Client,Float> 
        ClientSalaireEvent){
        Client cltToEdit = (Client) ListClient.getSelectionModel().getSelectedItem();
        cltToEdit.setSalaire(ClientSalaireEvent.getNewValue());
        ClientService.updateClient(cltToEdit);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //Ajouter les élémenst dans la combooBox Civilite
      civilite.getItems().addAll("Mr","Mme");
      civilite.getSelectionModel().select("Mr");
        
       //chager la liste des clients dans la table view listClient
       java.util.List listClients = ClientService.listClient();
       cltId.setCellValueFactory(new PropertyValueFactory<>("idClient"));
       cltName.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
       cltFirstName.setCellValueFactory(new PropertyValueFactory<>("prenomClient"));
       cltSalaire.setCellValueFactory(new PropertyValueFactory<>("salaire")); 
       
       ListClient.setEditable(true);
       cltFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
       cltSalaire.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
       civilite.setCellFactory(ComboBoxTableCell.forTableColumn("Mr", "Mme"));
              
       ListClient.getItems().addAll(listClients);
       
       
    }    
    
}
