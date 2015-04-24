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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NewGameController implements Initializable {
    
    @FXML
    private Button buttonDone;
    @FXML
    private Button buttonWarrior;
    @FXML
    private Button buttonMage;
    @FXML
    private Button buttonAssassin;
    @FXML
    private Button buttonBack;
    @FXML
    private ImageView imageWarrior;
    @FXML
    private ImageView imageMage;
    @FXML
    private ImageView imageAssassin;
    @FXML
    private ImageView backGroundImage;
    @FXML
    private TextField characterName;
    @FXML
    private Label Error1;
    
    public boolean chosenCharacter = false;
    // 3 booleans for marking chosen hero
    public boolean warriorChosen = false;
    public boolean mageChosen = false;
    public boolean assassinChosen = false;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    // method when done should check if hero is chosen and name is valid before saving to database and sending to worldmap
    @FXML
    public void handleButtonActionDone(ActionEvent event){
        String charName = characterName.getText();
        try{
            if(chosenCharacter = true && charName.length() != 0){
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMapController.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
            }else{
             Error1.setText("You have to pick a hero or have a valid name to continue");
            }
        
        }catch(IOException ex){
            System.out.println("Scene change error1");
        }
    }
    // methods below for marking hero as chosen
    @FXML
    public void warriorChosen(ActionEvent event){
        warriorChosen = true;
        mageChosen = false;
        assassinChosen = false;
    }
    @FXML
    public void mageChosen(ActionEvent event){
        mageChosen = true;
        warriorChosen = false;
        assassinChosen = false;
    }
    @FXML
    public void assassinChosen(ActionEvent event){
        assassinChosen = true;
        warriorChosen = false;
        mageChosen = false;
    }    
    
}
