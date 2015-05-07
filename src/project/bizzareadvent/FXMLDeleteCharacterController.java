/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DBTable2LoginHasCharacters;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLDeleteCharacterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button deleteSlot1, deleteSlot2, deleteSlot3, buttonConfirmDeletion, buttonCancel;
    
    private boolean slot1=false, slot2=false, slot3=false;
    private int slot=0;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        enableButtonSlots();
        
        System.out.println(this.getClass().getName());
        
        

    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage2 = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLScene2.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }

    }

    @FXML
    private void delslot1(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 1;
        disableButtonSlots();
        enableButtonConfirmCancel();
        deleteSlot1.setDefaultButton(true);
        deleteSlot2.setDefaultButton(false);
        deleteSlot3.setDefaultButton(false);

    }

    @FXML
    private void delslot2(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 2;
        disableButtonSlots();
        enableButtonConfirmCancel();
        deleteSlot1.setDefaultButton(false);
        deleteSlot2.setDefaultButton(true);
        deleteSlot3.setDefaultButton(false);
    }

    @FXML
    private void delslot3(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 3;
        disableButtonSlots();
        enableButtonConfirmCancel();
        deleteSlot1.setDefaultButton(false);
        deleteSlot2.setDefaultButton(false);
        deleteSlot3.setDefaultButton(true);
    }
    
    @FXML
    private void handleButtonActionConfirmDeletion(ActionEvent event) {// Only delete fromlocal saving to server
        deleteCharacter();
        enableButtonSlots();
        disableButtonConfirmCancel();
        
    }
    
    @FXML
    private void handleButtonActionCancel(ActionEvent event) {// Only delete fromlocal saving to server
        enableButtonSlots();
        disableButtonConfirmCancel();
        
    }
    

    
    
    
    
    private void deleteCharacter(){
        if(slot == 1){
        AllLocalData.getInstance().deleteCharFromSlot(slot);
        }else if(slot == 2){
        AllLocalData.getInstance().deleteCharFromSlot(slot);
        }else if(slot == 3){
        AllLocalData.getInstance().deleteCharFromSlot(slot);
        }
        DatabaseServer.getInstance().saveToDB();
        //UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
        UserData.getInstance().test001LoadCharDataFromALLLOCALDATA();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void enableButtonSlots() {
        
        
        slot = 0;
        for (DBTable2LoginHasCharacters test : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if (test.getCharacters_idNr() > 0) {
                slot++;
                System.out.println(slot);
            }
        }
        
        if (slot == 3){
            deleteSlot1.setText( "delete Slot1" );
            deleteSlot2.setText( "delete Slot2" );
            deleteSlot3.setText( "delete Slot3" );
        deleteSlot1.setDisable(true);
        deleteSlot2.setDisable(true);
        deleteSlot3.setDisable(true);
        }

        if (slot == 1){
            deleteSlot1.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName() );
            deleteSlot2.setText( "delete Slot2" );
            deleteSlot3.setText( "delete Slot3" );
        deleteSlot1.setDisable(false);
        deleteSlot2.setDisable(true);
        deleteSlot3.setDisable(true);
        }
        if (slot == 2){
            deleteSlot1.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName() );
            deleteSlot2.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(1).getCharacterName() );
            deleteSlot3.setText( "delete Slot3" );
        deleteSlot1.setDisable(false);
        deleteSlot2.setDisable(false);
        deleteSlot3.setDisable(true);
        }
        
        if (slot == 3){
            deleteSlot1.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName() );
            deleteSlot2.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(1).getCharacterName() );
            deleteSlot3.setText( AllLocalData.getInstance().getInfo2LoginHasCharacters().get(2).getCharacterName() );
        deleteSlot1.setDisable(false);
        deleteSlot2.setDisable(false);
        deleteSlot3.setDisable(false);
        }
        
        
        
        
    }
    private void disableButtonSlots(){
        deleteSlot1.setDisable(true);
        deleteSlot2.setDisable(true);
        deleteSlot3.setDisable(true);
    }
    private void enableButtonConfirmCancel(){
        buttonConfirmDeletion.setDisable(false);
        buttonCancel.setDisable(false);
    }
    private void disableButtonConfirmCancel(){
        buttonConfirmDeletion.setDisable(true);
        buttonCancel.setDisable(true);
    }
    

}
