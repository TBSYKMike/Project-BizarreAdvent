/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class YYFXMLTestingMethodsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField characterType,baseHp,baseDmg,baseDef,baseAttack;
    @FXML
    private TextField charSlot,Characters_idNr,score,characterName,armorUpgrade,weaponUpgrade,currentHp,gold,currentAttack,currentDef,currentDmg;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserData.getInstance().makeChar();
        
    }    
    
    
    
    
    @FXML
    private void handleButtonActionSavetoDB(ActionEvent event) {
         DatabaseServer.getInstance().saveToDB();
        
    }
    
    /*
    @FXML
    private void LoadFromAllLocalData(ActionEvent event) {
         UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
        
    }
    
    @FXML
    private void LoadSlot1(ActionEvent event) {
         UserData.getInstance().testloadCharFromArrayLists(1);
        showData();
    }
    
    @FXML
    private void LoadSlot2(ActionEvent event) {
         UserData.getInstance().testloadCharFromArrayLists(2);
        showData();
        
    }
    
    @FXML
    private void LoadSlot3(ActionEvent event) {
        UserData.getInstance().testloadCharFromArrayLists(3);
        showData();
        
    }
    
    @FXML
    private void SaveToCurrentSlot(ActionEvent event) {
        
        UserData.getInstance().setCharSlot(Integer.parseInt(charSlot.getText()));
        UserData.getInstance().setCharID(Integer.parseInt(Characters_idNr.getText()));
        UserData.getInstance().setCurrentScore(Integer.parseInt(score.getText()));
        UserData.getInstance().setCharacterName(characterName.getText());
        UserData.getInstance().setCurrentArmorUpgrade(Integer.parseInt(armorUpgrade.getText()));
        UserData.getInstance().setCurrentWeaponUpgrade(Integer.parseInt(weaponUpgrade.getText()));
        UserData.getInstance().setCurrentHp(Integer.parseInt(currentHp.getText()));
        UserData.getInstance().setCurrentGold(Integer.parseInt(gold.getText()));
        UserData.getInstance().setCurrentAttack(Integer.parseInt(currentAttack.getText()));
        UserData.getInstance().setCurrentDef(Integer.parseInt(currentDef.getText()));
        UserData.getInstance().setCurrentDmg(Integer.parseInt(currentDmg.getText()));
        
        
        
        UserData.getInstance().testsaveCharToArrayLists();
        showData();
    }
    
    @FXML
    private void SaveToAllLocalData(ActionEvent event) {
         UserData.getInstance().testSaveFromUSERDATAToALLLOCALDATA();
        
    }
    
    private void showData(){
        characterType.setText(UserData.getInstance().getCharacterType());
        baseHp.setText(Integer.toString(UserData.getInstance().getBaseHp()));
        baseDmg.setText(Integer.toString(UserData.getInstance().getBaseDmg()));
        baseDef.setText(Integer.toString(UserData.getInstance().getBaseDef()));
        baseAttack.setText(Integer.toString(UserData.getInstance().getBaseAttack()));
        
        
        
        
        
        
        
        
        
        charSlot.setText(Integer.toString(UserData.getInstance().getCharSlot()));
        Characters_idNr.setText(Integer.toString(UserData.getInstance().getCharID()));
        score.setText(Integer.toString(UserData.getInstance().getCurrentScore()));
        characterName.setText(UserData.getInstance().getCharacterName());
        armorUpgrade.setText(Integer.toString(UserData.getInstance().getCurrentArmorUpgrade()));
        weaponUpgrade.setText(Integer.toString(UserData.getInstance().getCurrentWeaponUpgrade()));
        currentHp.setText(Integer.toString(UserData.getInstance().getCurrentHp()));
        gold.setText(Integer.toString(UserData.getInstance().getCurrentGold()));
        currentAttack.setText(Integer.toString(UserData.getInstance().getCurrentAttack()));
        currentDef.setText(Integer.toString(UserData.getInstance().getCurrentDef()));
        currentDmg.setText(Integer.toString(UserData.getInstance().getCurrentDmg()));
        
        
        
     
    }
    
    */
    
}
