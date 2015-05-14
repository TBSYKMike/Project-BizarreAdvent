/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
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
    
}
