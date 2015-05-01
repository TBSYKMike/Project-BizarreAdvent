/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Minkan
 */
public class FXMLAdventureController implements Initializable {

    @FXML
    private TextArea adventureLog;
    @FXML
    private Label hpLabel;
    @FXML
    private Label attackLabel;
    @FXML
    private Label defenceLabel;
    @FXML
    private Label goldLabel;
    @FXML
    private Label scoreLabel;
    
    private int stepCounter = 0;
    
    Random randomGenerator = new Random();
    
    private int randomInt;
    
    private boolean run = false;
    private boolean deadCharacter = false;
    
    @FXML
    private void handleButtonAttack(ActionEvent event) {
        

        
    }
    
    @FXML
    private void handleButtonSecondary(ActionEvent event) {
        

        
    }
    
    @FXML
    private void handleButtonRun(ActionEvent event) {

        randomInt = randomGenerator.nextInt(100);
        
        if(randomInt < 51){
            run = true;
            adventureLog.appendText("\nYour attempt to run away was successful!");
            adventureLog.appendText("\nYou run away like the coward you are.\n");
            adventureLog.appendText("\nPress continue to enter the world map.");
        }else{
            monsterAttack();
            run = false;
        }    
    }
    
    @FXML
    private void handleButtonContinue(ActionEvent event) {
        if(run == true || deadCharacter == true){
            switchScene();
        }
    }
    
    @FXML
    private void handleButtonMenu(ActionEvent event) {
        

        
    }
    
    public void plains(){
   
        
        randomInt = randomGenerator.nextInt(100);
        
        if(stepCounter == 0){
            adventureLog.appendText("\nYou arrive at the plain of eehh... how does one even pronounce that?!");
            adventureLog.appendText("\n'Nevermind.. get on with it!'");
            adventureLog.appendText("\nTo the east you spot a crag of purple rocks in a strange formation,");
            adventureLog.appendText("\nto the west a field of grains stretches far and wide.");
            adventureLog.appendText("\nIn front of you a path leads the way, time to go exploring!\n\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt == 0){
              
            }
            else if(randomInt == 1){
                
            }else{
                
            }
        }
        stepCounter++;
    }
    
    public void mountains(){
        if(stepCounter == 0){
            adventureLog.appendText("\nYou arrive at the plain of eehh... how does one even pronounce that?!");
            adventureLog.appendText("\n'Nevermind.. get on with it!'");
            adventureLog.appendText("\nTo the east you spot a crag of purple rocks in a strange formation,");
            adventureLog.appendText("\nto the west a field of grains stretches far and wide.");
            adventureLog.appendText("\nIn front of you a path leads the way, time to go exploring!\n\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\nPress the continue button again to return to the world map.");
        }
        stepCounter++;
    }
    
    public void forest(){
        if(stepCounter == 0){
            adventureLog.appendText("\nYou enter the dark, dark forest of Adabûn.");
            adventureLog.appendText("\nStrangely shaped trees grow tall as mountains and wide as rivers.");
            adventureLog.appendText("\nYou see nothing but the trees and a small path leading into the center of the forest.");
            adventureLog.appendText("\nThe feeling from you get from this place is very unpleasant.");
            adventureLog.appendText("\nAnywho, you follow the dark path into the forest to continue your journey.\n\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\nYou have made it through the forest alive, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'Oh well.'");
            adventureLog.appendText("\nPress the continue button again to return to the world map.");
        }
        stepCounter++;
    }
    
    public void swamp(){
        if(stepCounter == 0){
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\nPress the continue button again to return to the world map.");
        }
        stepCounter++;
    }
    
    public void castle(){
        if(stepCounter == 0){
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\nPress the continue button again to return to the world map.");
        }
        stepCounter++;
    }
    
    public void secondaryAttackMage(){
        
    }
    
    public void secondaryAttackWarrior(){
        
    }
    
    public void secondaryAttackAssassin(){
        
    }
    
    public void monsterAttack(){
        
    }
    
    public void gameOver(){
        
    }
    
    public void showStats(){
        
    }
    
    public void switchScene(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
