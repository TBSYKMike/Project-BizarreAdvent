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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Minkan
 */
public class FXMLCityController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void handleButtonActionBack(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMap.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }
    }
    
    
    @FXML
    public void handleButtonActionHeal(ActionEvent event) {
        //check current gold if is enough
            //if its enough do //get currenthp and reset to basehp
    }
    
    @FXML
    public void handleButtonActionWeaponUpgrade(ActionEvent event) {
        //check current gold if is enough
            //if its enough do //get current weapon upgrade and add 1 to current weapon upgrade
    }
    
    @FXML
    public void handleButtonActionArmorUpgrade(ActionEvent event) {
        //check current gold if is enough
            //if its enough do //get current armor upgrade and add 1 to current armor upgrade
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
