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
        if (MusicSettings.getInstance().isMusicOn() == true) {
            buttonOff.setDisable(false);
        } else {
            buttonOn.setDisable(false);
        }

    }

    private void resetButtons() {
        buttonOn.setDisable(true);
        buttonOff.setDisable(true);
    }

    @FXML
    private void buttonActionMusicOn() {
        MusicSettings.getInstance().setMusicOnOff(true);
        resetButtons();
        buttonOff.setDisable(false);
        MusicSettings.getInstance().writeToFile();
        MusicSettings.getInstance().playMusic("main");
    }

    @FXML
    private void buttonActionMusicOff() {
        MusicSettings.getInstance().setMusicOnOff(false);
        resetButtons();
        buttonOn.setDisable(false);
        MusicSettings.getInstance().writeToFile();
        MusicSettings.getInstance().playMusic("main");
    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage2 = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }

    }

}
