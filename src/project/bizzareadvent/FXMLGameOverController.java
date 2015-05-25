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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.MusicSettings;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLGameOverController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label labelGameOver,labelScore, labelThankMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String charName = UserData.getInstance().getCharactersArrList().getCharacterName();
        int charScore = UserData.getInstance().getCharactersArrList().getCurrentScore();
        
        String scoreText = charName + "'s final score is: " + charScore;
        
        isDeadOrGameCleared();
        deleteCharacter();
        setToHighScore();
        labelScore.setText(scoreText);
        
        MusicSettings.getInstance().playMusic("main");
        
    }    
    
    
    private void isDeadOrGameCleared(){
        if(UserData.getInstance().isGameClear()){
            labelGameOver.setText( "Game Cleared");
            UserData.getInstance().setGameClear(false);
            labelThankMessage.setText("Thank you for playing and hope you enjoyed our game!");
        }
        
    }
    
    private void deleteCharacter(){
        int charSlot = (UserData.getInstance().getArraylistNumber()+1);
        AllLocalData.getInstance().deleteCharFromSlot( charSlot );
        DatabaseServer.getInstance().saveToDB();
        UserData.getInstance().test001LoadCharDataFromALLLOCALDATA();
    }
    
    private void setToHighScore(){
        
    }
    
    public void buttonActionContinue(ActionEvent event) {
        
        try{
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
                //UserData.getInstance().setRememeberLastClass(this.getClass().getName());
        
        }catch(IOException ex){
            System.out.println("Scene change error1rrr");
        }
        

    }
    
    
}
