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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DBTable2LoginHasCharacters;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLLoadCharacterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button loadSlot1, loadSlot2, loadSlot3, buttonConfirmDeletion, buttonCancel;

    @FXML
    private ImageView chosenCharacter;

    private boolean slot1 = false, slot2 = false, slot3 = false;
    private int slot = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        enableButtonSlots();

        System.out.println(this.getClass().getName());
        chosenCharacter.setImage(characterImage);

    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage2 = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }

    }

    @FXML
    private void handleButtonActionLoadSlot1(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 1;
        disableButtonSlots();
        enableButtonConfirmCancel();
        loadSlot1.setDefaultButton(true);
        loadSlot2.setDefaultButton(false);
        loadSlot3.setDefaultButton(false);
        loadCharacterImage(1);
    }

    @FXML
    private void handleButtonActionLoadSlot2(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 2;
        disableButtonSlots();
        enableButtonConfirmCancel();
        loadSlot1.setDefaultButton(false);
        loadSlot2.setDefaultButton(true);
        loadSlot3.setDefaultButton(false);
        loadCharacterImage(2);
    }

    @FXML
    private void handleButtonActionLoadSlot3(ActionEvent event) {// Only delete fromlocal saving to server
        slot = 3;
        disableButtonSlots();
        enableButtonConfirmCancel();
        loadSlot1.setDefaultButton(false);
        loadSlot2.setDefaultButton(false);
        loadSlot3.setDefaultButton(true);
        loadCharacterImage(3);
    }

    @FXML
    private void handleButtonActionConfirmLoad(ActionEvent event) {// Only delete fromlocal saving to server
        //deleteCharacter();
        //enableButtonSlots();
        disableButtonConfirmCancel();

        UserData.getInstance().doLoadCharDataFromALLLOCALDATA();

        System.out.println(slot);
        UserData.getInstance().setArraylistNumber((slot - 1));

        try {

            Node node = (Node) event.getSource();
            Stage stage2 = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMap.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }

    }

    @FXML
    private void handleButtonActionCancel(ActionEvent event) {// Only delete fromlocal saving to server
        enableButtonSlots();
        disableButtonConfirmCancel();

        loadCharacterImage(0);
    }

    private void enableButtonSlots() {

        slot = 0;
        for (DBTable2LoginHasCharacters test : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if (test.getCharacters_idNr() > 0) {
                slot++;
                System.out.println(slot);
            }
        }

        if (slot == 3) {
            loadSlot1.setText("delete Slot1");
            loadSlot2.setText("delete Slot2");
            loadSlot3.setText("delete Slot3");
            loadSlot1.setDisable(true);
            loadSlot2.setDisable(true);
            loadSlot3.setDisable(true);
        }

        if (slot == 1) {
            loadSlot1.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName());
            loadSlot2.setText("delete Slot2");
            loadSlot3.setText("delete Slot3");
            loadSlot1.setDisable(false);
            loadSlot2.setDisable(true);
            loadSlot3.setDisable(true);
        }
        if (slot == 2) {
            loadSlot1.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName());
            loadSlot2.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(1).getCharacterName());
            loadSlot3.setText("delete Slot3");
            loadSlot1.setDisable(false);
            loadSlot2.setDisable(false);
            loadSlot3.setDisable(true);
        }

        if (slot == 3) {
            loadSlot1.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(0).getCharacterName());
            loadSlot2.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(1).getCharacterName());
            loadSlot3.setText(AllLocalData.getInstance().getInfo2LoginHasCharacters().get(2).getCharacterName());
            loadSlot1.setDisable(false);
            loadSlot2.setDisable(false);
            loadSlot3.setDisable(false);
        }

    }

    private void disableButtonSlots() {
        loadSlot1.setDisable(true);
        loadSlot2.setDisable(true);
        loadSlot3.setDisable(true);
    }

    private void enableButtonConfirmCancel() {
        buttonConfirmDeletion.setDisable(false);
        buttonCancel.setDisable(false);
    }

    private void disableButtonConfirmCancel() {
        buttonConfirmDeletion.setDisable(true);
        buttonCancel.setDisable(true);
    }

    private Image characterImage;

    private void loadCharacterImage(int getSlot) {
        int tempCharID = 0;
        for (DBTable2LoginHasCharacters getLHC : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if (getLHC.getCharSlot() == getSlot) {
                tempCharID = getLHC.getCharacters_idNr();
            }
        }

        if (tempCharID == 1) {
            characterImage = new Image("warrior.png", true);
        } else if (tempCharID == 2) {
            characterImage = new Image("mage.png", true);
        } else if (tempCharID == 3) {
            characterImage = new Image("rogue.png", true);
        }

        chosenCharacter.setImage(characterImage);
    }

}
