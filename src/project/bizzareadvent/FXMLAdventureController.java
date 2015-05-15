/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.w3c.dom.UserDataHandler;
import project.bizzareadvent.SaveLoad.UserData;

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
    @FXML
    private Button attackButton;
    @FXML
    private Button secondaryButton;
    @FXML
    private Button continueButton;
    @FXML
    private Button runButton;
    
    Random randomGenerator = new Random();
    
    private int stepCounter = 0;
    private int randomInt;
    
    private String position;
    private boolean run = false;
    private boolean deadCharacter = false;
    
    NormalMonster monster;
    MonsterGenerator generator;
    
    //test arraylist
    ArrayList<Warrior> list = new ArrayList<>();
    
    
    @FXML
    private void handleButtonAttack(ActionEvent event) {
        
        randomInt = randomGenerator.nextInt(6) + 1;
        
        System.out.println(monster.getBaseHp());
        
        
        if(list.get(0).getCurrentAttack() > monster.getBaseDef()){
            
            if(randomInt > 2){
                monster.setBaseHp(monster.getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nYou miss!");
            }
        }
        else if(list.get(0).getCurrentAttack() == monster.getBaseDef()){
            
            if(randomInt > 3){
                monster.setBaseHp(monster.getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nYou miss!");
            }
        }else{
            
            if(randomInt > 4){
                monster.setBaseHp(monster.getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nYou miss!");
            }    
        }
            
        if(monster.getBaseHp() <= 0){
            adventureLog.appendText("\n\nYou are victorious! You have slain the " + monster.getMonsterType() + ".");
            adventureLog.appendText("\nYou add " + monster.getAmountGold() + " gold to your purse and");
            adventureLog.appendText("\nyou gain " + monster.getAmountScore() + " score.");
            
            list.get(0).setCurrentGold(list.get(0).getCurrentGold() + monster.getAmountGold());
            list.get(0).setCurrentScore(list.get(0).getCurrentScore() + monster.getAmountScore());
            
            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
        }else{
            monsterAttack();
        }
        
        showStats();
    }
    
    @FXML
    private void handleButtonSecondary(ActionEvent event) {
        

        
    }
    
    @FXML
    private void handleButtonRun(ActionEvent event) {

        randomInt = randomGenerator.nextInt(100);
        
        if(randomInt < 51){
            run = true;
            adventureLog.appendText("\n\nYour attempt to run away was successful!");
            adventureLog.appendText("\nYou run away like the coward you are.\n");
            adventureLog.appendText("\n\nPress continue to enter the world map.");
            
            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
        }else{
            adventureLog.appendText("\n\nYour attempt to run away failed!");
            monsterAttack();
            run = false;
        }    
    }
    
    @FXML
    private void handleButtonContinue(ActionEvent event) {
        if(run == true || stepCounter > 10){
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
                ex.printStackTrace();
            }
        }
        else if(deadCharacter == true){
            
        }else{
            if (position.equals("plains")){
                plains();
            }
            else if(position.equals("forest")){
                forest();
            }
            else if(position.equals("mountain")){
                mountains();
            }
            else if(position.equals("swamp")){
                swamp();
            }else{
                castle();
            }
        }
    }
    
    @FXML
    private void handleButtonMenu(ActionEvent event) {
        

        
    }
    
    public void plains(){
   
        
        randomInt = randomGenerator.nextInt(100) + 1;
        
        if(stepCounter == 0){
            adventureLog.appendText("\n\nYou arrive at the plain of eehh... how does one even pronounce that?!");
            adventureLog.appendText("\n'Nevermind.. get on with it!'");
            adventureLog.appendText("\nTo the east you spot a crag of purple rocks in a strange formation,");
            adventureLog.appendText("\nto the west a field of grains stretches far and wide.");
            adventureLog.appendText("\nIn front of you a path leads the way, time to go exploring!\n\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\n\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt <= 20){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt > 20 && randomInt < 60){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt >= 60 ){
                adventureLog.appendText("\n\n");
            }
        }
        stepCounter++;
    }
    
    public void mountains(){
        if(stepCounter == 0){
            adventureLog.appendText("\n\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\n\nYou have reached the end of this path, there seems to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt <= 20){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt > 20 && randomInt < 60){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt >= 60 ){
                adventureLog.appendText("\n\n");
            }
        }
        stepCounter++;
    }
    
    public void forest(){
        
        randomInt = randomGenerator.nextInt(100) + 1;
        
        if(stepCounter == 0){
            adventureLog.appendText("\n\nYou enter the dark, dark forest of Adabûn.");
            adventureLog.appendText("\nStrangely shaped trees grow tall as mountains and wide as rivers.");
            adventureLog.appendText("\nYou see nothing but the trees and a small path leading into the center of the forest.");
            adventureLog.appendText("\nThe feeling from you get from this place is very unpleasant.");
            adventureLog.appendText("\nAnywho, you follow the dark path into the forest to continue your journey.\n\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\n\nYou have made it through the forest alive, there seems to be nothing more to explore.");
            adventureLog.appendText("\n'Oh well.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt <= 20){
                adventureLog.appendText("\n\nYou look around and see nothing of interest.");
                adventureLog.appendText("\n 'Better keep moving'");
            }
            else if(randomInt > 20 && randomInt < 60){
                generateTreasure();
            }
            else if(randomInt >= 60 ){
                //monster = generator.generateMonster(position);
                monster = new NormalMonster(200,10,10,10,10,10,"spider");
                
                adventureLog.appendText("\n\nYou encounter a " + monster.getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");
                
                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();
        
        stepCounter++;
    }
    
    public void swamp(){
        if(stepCounter == 0){
            adventureLog.appendText("\n\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\n\nYou have reached the end of this path, there seems to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt <= 20){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt > 20 && randomInt < 60){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt >= 60 ){
                adventureLog.appendText("\n\n");
            }
        }
        stepCounter++;
    }
    
    public void castle(){
        if(stepCounter == 0){
            adventureLog.appendText("\n\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
            adventureLog.appendText("\n");
        }
        else if(stepCounter >= 10){
            adventureLog.appendText("\n\nYou have reached the end of this path, there seems to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }
        else{
            if(randomInt <= 20){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt > 20 && randomInt < 60){
                adventureLog.appendText("\n\n");
            }
            else if(randomInt >= 60 ){
                adventureLog.appendText("\n\n");
            }
        }
        stepCounter++;
    }
    
    public void generateTreasure(){
        //generate treasure and add it to the character//
        //under construction//
        
        int gold = 0;
        randomInt = randomGenerator.nextInt(100) + 1;
        
        if(randomInt <= 15){
            gold = 50;
            
            adventureLog.appendText("\n\nYou stumble upon a chest hidden behind some rocks,");
            adventureLog.appendText("\nYou open it and find a mustash made of the purest gold.");
            adventureLog.appendText("\n'It must be worth a fortune!'");
            adventureLog.appendText("\nYou ad " + gold + " gold to your purse.");
    
        }
        else if(randomInt > 15 && randomInt <= 40 ){
            gold = 20;
            
            adventureLog.appendText("\n\nYou trip over something and start to curse.");
            adventureLog.appendText("\nYou look behind you to see it was a small jewel encrusted box.");
            adventureLog.appendText("\n'Hot damn!'");
            adventureLog.appendText("\nYou open it to find that it is empty.");
            adventureLog.appendText("\nYou take it anyway and ad " + gold + " gold to your purse.");
        }
        else if(randomInt > 40 && randomInt <= 65){
            gold = 20;
            
            adventureLog.appendText("\n\nYou see something shining in the distance.");
            adventureLog.appendText("\nYou start to run towards it and find a small pile of gold pieces.");
            adventureLog.appendText("\n'WOHO!'");
            adventureLog.appendText("\nYou ad " + gold + " gold to your purse.");
        }
        else if(randomInt > 65 && randomInt <= 85){
            gold = 30;
            
            adventureLog.appendText("\n\nYou are walking around admiring the enviroment,");
            adventureLog.appendText("\nwhen all of a sudden something drops on your head.");
            adventureLog.appendText("\n'WTF!'");
            adventureLog.appendText("\nYou look around to see what hit you in the head to find a goldnugget");
            adventureLog.appendText("\n'Ohhh nice!'");
            adventureLog.appendText("\nYou ad " + gold + " gold to your purse.");
        }
        else if(randomInt > 85 && randomInt <= 95){
            gold = 50;
            
            adventureLog.appendText("\n\nYou hear someone moaning.");
            adventureLog.appendText("\nYou look around and see an old, fragile and weak man sitting with a bag of gold under his arm.");
            adventureLog.appendText("\n'That looks heavy old man, you need help with that?'");
            adventureLog.appendText("\nThe old man looks up to you with an angry look on his face");
            adventureLog.appendText("\n'PISS OFF YOU SILLY CUNT, IT'S MINE, MY OWN, MY PRECIOUS'");
            adventureLog.appendText("\nWithout hesitation you suckerpunch the old man and steal his bag of gold");
            adventureLog.appendText("\nYou ad " + gold + " gold to your purse.");
        }
        else if(randomInt >= 96){
            gold = 100;
            
            adventureLog.appendText("\n\nAn ugly dwarf jumps you from behind and kicks you");
            adventureLog.appendText("\nin the groin and steals some of your gold.");
            adventureLog.appendText("\n'Get rekt noob!'");
            adventureLog.appendText("\nYou lose " + gold + " gold.");
           
        }
        
        list.get(0).setCurrentGold(list.get(0).getCurrentGold() + gold);
    }
    
    public void secondaryAttackMage(){
        
    }
    
    public void secondaryAttackWarrior(){
        
    }
    
    public void secondaryAttackAssassin(){
        
    }
    
    public void monsterAttack(){
       
        randomInt = randomGenerator.nextInt(6) + 1;
        
        if(monster.getBaseAttack() > list.get(0).getCurrentDef()){
            
            if(randomInt > 2){
                list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monster.getBaseDmg());
                adventureLog.appendText("\n\nThe monster strikes you for " + monster.getBaseDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nThe monster misses!");
            }
        }
        else if(monster.getBaseAttack() == list.get(0).getCurrentDef()){
            
            if(randomInt > 3){
                list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monster.getBaseDmg());
                adventureLog.appendText("\n\nThe monster strikes you for " + monster.getBaseDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nThe monster misses!");
            }
        }else{
            
            if(randomInt > 4){
                list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monster.getBaseDmg());
                adventureLog.appendText("\n\nThe monster strikes you for " + monster.getBaseDmg() + " Damage!");
            }else{
                adventureLog.appendText("\n\nThe monster misses!");
            }    
        }
        
        if(list.get(0).getCurrentHp() <= 0){
            
            deadCharacter = true;
            
            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
            
            adventureLog.appendText("\n\nYou have died. As your spirit leaves your body you can see your enemy");
            adventureLog.appendText("\nrip your lifeless body limb from limb.");
            adventureLog.appendText("\nMaybe it will fashion a nice hat from your body.");
            adventureLog.appendText("\n\nPress continue to enter your score.");
            // change scene to death scene
        }else{
         
            showStats();
        }
    }
    
    public void gameOver(){
        
    }
    
    public void showStats(){
        
        attackLabel.setText(Integer.toString(list.get(0).getCurrentAttack()));
        defenceLabel.setText(Integer.toString(list.get(0).getCurrentDef()));
        hpLabel.setText(Integer.toString(list.get(0).getCurrentHp()));
        goldLabel.setText(Integer.toString(list.get(0).getCurrentGold()));
        scoreLabel.setText(Integer.toString(list.get(0).getCurrentScore()));
    }
    
    
    public void switchScene(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        position = UserData.getInstance().getAdventurePosition();
        
        
        //Warrior warr = new Warrior(0,0,0,0,0,"test",0,0,0,0,0,0,0,0); //test
        
        Warrior warr = (Warrior)UserData.getInstance().getCharactersArrList();
        
        list.add(warr);
        
        attackButton.setDisable(true);
        secondaryButton.setDisable(true);
        runButton.setDisable(true);
        continueButton.setDisable(false);
        
        System.out.println(list.get(0).getCharacterName());
        
        showStats();
    }    
}
