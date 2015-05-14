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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.DatabaseServer;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLHighScoreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextArea textareaHighScore1, textareaHighScore2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String HighScore = DatabaseServer.getInstance().getHighScore();
        //String Username = DatabaseServer.getInstance().getUsername();
        //textareaHighScore1.setText(HighScore);
        //textareaHighScore2.setText(Username);
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
    
    
    
}
