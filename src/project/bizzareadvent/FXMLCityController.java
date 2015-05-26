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
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Minkan
 */
public class FXMLCityController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label nameLabel;
    @FXML
    private Label currentHp;
    @FXML
    private Label currentAttack;
    @FXML
    private Label currentDef;
    @FXML
    private Label currentGold;
    @FXML
    private Label currentScore;
    @FXML
    private Label currentWeaponUpgrade;
    @FXML
    private Label currentArmorUpgrade;

    @FXML
    private Label labelWarning;
    
    @FXML
    private Button buttonHeal, buttonWeaponUp, buttonArmorUp;
    
    @FXML
    private Label labelHeal, labelWeaponUp, labelArmorUp;
    
    

    private final int UPGRADE_LIMIT = 10;
    
    int healingCost = 50;
    int upgradeCost = 150;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showStats();

        labelWarning.setOpacity(0);
        
        labelHeal.setText(Integer.toString(healingCost)+" gold");
        labelWeaponUp.setText(Integer.toString(upgradeCost)+" gold");
        labelArmorUp.setText(Integer.toString(upgradeCost)+" gold");
        

    }

    @FXML
    public void handleButtonActionBack(ActionEvent event) {
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
        }
    }

    @FXML
    public void handleButtonActionHeal(ActionEvent event) {
        //check current gold if is enough
        
        int gold = UserData.getInstance().getCharactersArrList().getCurrentGold();
        if (healingCost <= gold && gold > 0 && UserData.getInstance().getCharactersArrList().getCurrentHp() < 100) {
            System.out.println("gega Heal");
            UserData.getInstance().getCharactersArrList().setCurrentGold((gold - healingCost));
            UserData.getInstance().getCharactersArrList().setCurrentHp(100);
            saveToLocalNDb();
            labelWarning.setOpacity(0);
            
        } else {
            labelWarning.setOpacity(100);
        }
        
        if(UserData.getInstance().getCharactersArrList().getCurrentHp() <= 100){
            labelWarning.setOpacity(0);
        } 
        
        showStats();
    }
    
    @FXML
    public void handleButtonActionWeaponUpgrade(ActionEvent event) {
        //check current gold if is enough
        
        int gold = UserData.getInstance().getCharactersArrList().getCurrentGold();
        if (upgradeCost <= gold && gold > 0 && UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade() < UPGRADE_LIMIT) {

            UserData.getInstance().getCharactersArrList().setCurrentGold(UserData.getInstance().getCharactersArrList().getCurrentGold() - upgradeCost);
            UserData.getInstance().getCharactersArrList().setCurrentWeaponUpgrade(UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade() + 1);
            UserData.getInstance().getCharactersArrList().setCurrentAttack(UserData.getInstance().getCharactersArrList().getBaseAttack() + (10 * UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade()));
            UserData.getInstance().getCharactersArrList().setCurrentDmg(UserData.getInstance().getCharactersArrList().getBaseDmg() + (10 * UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade()));
            saveToLocalNDb();
            labelWarning.setOpacity(0);
        } else {
            labelWarning.setOpacity(100);
        }
        showStats();
    }

    @FXML
    public void handleButtonActionArmorUpgrade(ActionEvent event) {
        //check current gold if is enough
        
        int gold = UserData.getInstance().getCharactersArrList().getCurrentGold();
        if (upgradeCost <= gold && gold > 0 && UserData.getInstance().getCharactersArrList().getCurrentArmorUpgrade() < UPGRADE_LIMIT) {

            UserData.getInstance().getCharactersArrList().setCurrentGold(UserData.getInstance().getCharactersArrList().getCurrentGold() - upgradeCost);
            UserData.getInstance().getCharactersArrList().setCurrentArmorUpgrade(UserData.getInstance().getCharactersArrList().getCurrentArmorUpgrade() + 1);
            UserData.getInstance().getCharactersArrList().setCurrentDef(UserData.getInstance().getCharactersArrList().getBaseDef() + (10 * UserData.getInstance().getCharactersArrList().getCurrentArmorUpgrade()));
            saveToLocalNDb();
            labelWarning.setOpacity(0);
        } else {
            labelWarning.setOpacity(100);
        }
        showStats();
    }

    private void saveToLocalNDb() {
        UserData.getInstance().doSaveCharDataToALLLOCALDATA();
        DatabaseServer.getInstance().saveToDB();
    }

    private void showStats() {
        if (AllLocalData.getInstance().getInfo2LoginHasCharacters().isEmpty() == false) {
            nameLabel.setText(UserData.getInstance().getCharactersArrList().getCharacterName());
            currentHp.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentHp()));
            currentAttack.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentAttack()));
            currentDef.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentDef()));
            currentGold.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentGold()));
            currentScore.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentScore()));
            currentWeaponUpgrade.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade()));
            currentArmorUpgrade.setText(Integer.toString(UserData.getInstance().getCharactersArrList().getCurrentArmorUpgrade()));

        }
    }

}
