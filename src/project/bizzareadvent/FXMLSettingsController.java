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
import javafx.scene.control.Button;
import project.bizzareadvent.SaveLoad.MusicSettings;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLSettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button buttonOn, buttonOff;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        resetButtons();
        if (MusicSettings.getInstance().isMusicOn() == true ){
            buttonOff.setDisable(false);
        }else {
            buttonOn.setDisable(false);
        }
        
        
    }    
    
    private void resetButtons(){
        buttonOn.setDisable(true);
        buttonOff.setDisable(true);
    }
    
    
    @FXML
    private void buttonActionMusicOn(){
        MusicSettings.getInstance().setMusicOnOff(true);
        resetButtons();
        buttonOff.setDisable(false);
        MusicSettings.getInstance().writeToFile();
        MusicSettings.getInstance().playMusic("main");
    }
    @FXML
    private void buttonActionMusicOff(){
        MusicSettings.getInstance().setMusicOnOff(false);
        resetButtons();
        buttonOn.setDisable(false);
        MusicSettings.getInstance().writeToFile();
        MusicSettings.getInstance().playMusic("main");
    }
    
    
    
}
