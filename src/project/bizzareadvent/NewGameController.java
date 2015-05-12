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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DBTable2LoginHasCharacters;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

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
    private ImageView imageRogue;
    @FXML
    private ImageView backGroundImage;
    @FXML
    public TextField characterName;
    @FXML
    private Label Error1;

    public boolean chosenCharacter = false;
    // 3 booleans for marking chosen hero
    public boolean warriorChosen = false;
    public boolean mageChosen = false;
    public boolean assassinChosen = false;
    private static NewGameController instance;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                loadCharacterImage();
    }

    // method when done should check if hero is chosen and name is valid before saving to database and sending to worldmap
    public static NewGameController getInstance() {

        if (instance == null) {
            instance = new NewGameController();
            
            
        }

        return instance;

    }
    @FXML
    public void handleButtonActionDone(ActionEvent event) {
        boolean slotEmpty = false;
        if (chosenCharacter) {

            String charName = characterName.getText();
            try {
                if (warriorChosen == true && charName.length() != 0 ) {
                    boolean controllData = true;
                    for (int i = 0; i < 3; i++) {
                        if (AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).getCharacters_idNr() == 0 && controllData) {
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(1);
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(charName);
                            
                            
                            loadSetBaseData(i);  
                            
                            
                            
                            controllData = false;
                            slotEmpty = true;
                        } else {
                            System.out.println("slot" + (i + 1) + " is not emtpy ");

                        }
                    }
                //UserData.getInstance().testSaveFromUSERDATAToALLLOCALDATA();

                //DatabaseServer.getInstance().saveToDB();
                    //UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
                   // DatabaseServer.getInstance().saveToDB();
                   // UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();

                } else if (mageChosen == true && charName.length() != 0) {

                    boolean controllData = true;
                    for (int i = 0; i < 3; i++) {
                        if (AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).getCharacters_idNr() == 0 && controllData) {
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(2);
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(charName);
                            
                            loadSetBaseData(i); 
                            
                            controllData = false;
                            slotEmpty = true;
                        } else {
                            System.out.println("slot" + (i + 1) + " is not emtpy ");

                        }
                    }
               // UserData.getInstance().testSaveFromUSERDATAToALLLOCALDATA();

              //  DatabaseServer.getInstance().saveToDB();
                    //  UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
                } else if (assassinChosen == true && charName.length() != 0 ) {

                    boolean controllData = true;
                    for (int i = 0; i < 3; i++) {
                        if (AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).getCharacters_idNr() == 0 && controllData) {
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(3);
                            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(charName);
                            
                            loadSetBaseData(i); 
                            
                            controllData = false;
                            slotEmpty = true;
                        } else {
                            System.out.println("slot" + (i + 1) + " is not emtpy ");

                        }
                    }
           //     UserData.getInstance().testSaveFromUSERDATAToALLLOCALDATA();

             //   DatabaseServer.getInstance().saveToDB();
                    //   UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
                }

                if (slotEmpty && charName.length() != 0 ) {
                    DatabaseServer.getInstance().saveToDB();
                    //UserData.getInstance().testLoadAllDataFromALLLOCALDATAToUSERDATA();
                    UserData.getInstance().test001LoadCharDataFromALLLOCALDATA();
                    setLoadSlot();
                }

            } catch (Exception ex) {
                System.out.println(ex.getClass() + "new game error");
            }

            if (slotEmpty) {
                try {
                    if (chosenCharacter = true && charName.length() != 0) {
                        Node node = (Node) event.getSource();
                        Stage stageLogin = (Stage) node.getScene().getWindow();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMap.fxml"));
                        Parent root = loader.load();

                        Scene scene = new Scene(root);
                        stageLogin.setScene(scene);
                        stageLogin.show();
                    } else {
                        Error1.setText("You have to pick a hero or have a valid name to continue");
                        
                    }

                } catch (Exception ex) {
                    System.out.println("Scene change error1");
                }

            } else {
                System.out.println("All Slots are Full AND/OR TextField is Empty");
                Error1.setText("All Slots are Full");
            }

        } else {
            System.out.println("no character selected, FFS select someting!!!!!!!!!!!!!!!!!");

        }

    }

    @FXML
    public void handleButtonActionBack(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLScene2.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }
    }

    // methods below for marking hero as chosen
    @FXML
    public void warriorChosen(ActionEvent event) {
        warriorChosen = true;
        mageChosen = false;
        assassinChosen = false;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }

    @FXML
    public void mageChosen(ActionEvent event) {
        mageChosen = true;
        warriorChosen = false;
        assassinChosen = false;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }

    @FXML
    public void assassinChosen(ActionEvent event) {
        assassinChosen = true;
        warriorChosen = false;
        mageChosen = false;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }
    
    
    
    
    private void loadSetBaseData(int i){
        if (warriorChosen){
            
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(    AllLocalData.getInstance().getInfo3Characters().get(0).getBaseAttack()           );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(    AllLocalData.getInstance().getInfo3Characters().get(0).getBaseDef()     );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(   AllLocalData.getInstance().getInfo3Characters().get(0).getBaseDmg()         );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(    AllLocalData.getInstance().getInfo3Characters().get(0).getBaseHp()       );
        }
        if (mageChosen){
            
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(    AllLocalData.getInstance().getInfo3Characters().get(1).getBaseAttack()           );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(    AllLocalData.getInstance().getInfo3Characters().get(1).getBaseDef()     );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(   AllLocalData.getInstance().getInfo3Characters().get(1).getBaseDmg()         );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(    AllLocalData.getInstance().getInfo3Characters().get(1).getBaseHp()       );
        }
        if (assassinChosen){
            
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(    AllLocalData.getInstance().getInfo3Characters().get(2).getBaseAttack()           );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(    AllLocalData.getInstance().getInfo3Characters().get(2).getBaseDef()     );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(   AllLocalData.getInstance().getInfo3Characters().get(2).getBaseDmg()         );
        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(    AllLocalData.getInstance().getInfo3Characters().get(2).getBaseHp()       );
        }
        
    }
    
    
    private void setLoadSlot(){
        int slots=0;
        
        for (DBTable2LoginHasCharacters test : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if (test.getCharacters_idNr() > 0) {
                slots++;
                System.out.println(slots);
            }
        }
        
        UserData.getInstance().setArraylistNumber(slots-1);
    }
    
    
    
    
    
    
    //private Image characterImage = new Image("chosecharacter.bmp", true);
    private void loadCharacterImage(){
        
        
        
        
        Image characterImage1 = new Image("ms-warrior0.png", true);
        Image characterImage2 = new Image("ms-mage0.png", true);
        Image characterImage3 = new Image("ms-rogue0.png", true);
       
        imageWarrior.setImage(  characterImage1 );
        
        imageMage.setImage(  characterImage2 );
        
        imageRogue.setImage(  characterImage3   );
        
        
        imageWarrior.setOpacity(0.3);
        imageMage.setOpacity(0.3);
        imageRogue.setOpacity(0.3);
        
        
        if(warriorChosen == true){
            imageWarrior.setOpacity(1);
        }else if(mageChosen == true){
            imageMage.setOpacity(1);
        }else if(assassinChosen == true){
            imageRogue.setOpacity(1);
        }
        
    }

}
