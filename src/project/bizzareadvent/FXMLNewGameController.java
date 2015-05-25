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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.AllLocalData;
import project.bizzareadvent.SaveLoad.DBTable2LoginHasCharacters;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

public class FXMLNewGameController implements Initializable {

    @FXML
    private Button buttonDone;
    @FXML
    private Button buttonWarrior;
    @FXML
    private Button buttonMage;
    @FXML
    private Button buttonRogue;
    @FXML
    private Button buttonBack;
    @FXML
    private ImageView imageClass;
    @FXML
    private TextArea classInfo;
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
    public boolean rogueChosen = false;
    private static FXMLNewGameController instance;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCharacterImage();
    }

    // method when done should check if hero is chosen and name is valid before saving to database and sending to worldmap
    public static FXMLNewGameController getInstance() {

        if (instance == null) {
            instance = new FXMLNewGameController();

        }

        return instance;

    }

    @FXML
    public void handleButtonActionDone(ActionEvent event) {
       
        createNewCharacter(event, "FXMLWorldMap.fxml");

    }

    @FXML
    public void handleButtonActionBack(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
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
        reset();
        warriorChosen = true;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }

    @FXML
    public void mageChosen(ActionEvent event) {
        reset();
        mageChosen = true;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }

    @FXML
    public void rogueChosen(ActionEvent event) {
        reset();
        rogueChosen = true;

        chosenCharacter = true;
        buttonDone.setDisable(false);
        loadCharacterImage();
    }

    private void reset() {
        rogueChosen = false;
        warriorChosen = false;
        mageChosen = false;
    }

    private void loadSetBaseData(int i) {
        int charType = 0;
        if (warriorChosen) {
            charType = 0;
        }
        else if (mageChosen) {
            charType = 1;
        }
        else if (rogueChosen) {
            charType = 2;
        }

        if (true) {
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(AllLocalData.getInstance().getInfo3Characters().get(charType).getBaseAttack());
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(AllLocalData.getInstance().getInfo3Characters().get(charType).getBaseDef());
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(AllLocalData.getInstance().getInfo3Characters().get(charType).getBaseDmg());
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(AllLocalData.getInstance().getInfo3Characters().get(charType).getBaseHp());

        }

    }

    

    //private Image characterImage = new Image("chosecharacter.bmp", true);
    private void loadCharacterImage() {

        Image characterImage1 = new Image("ms-warrior0.png", true);
        Image characterImage2 = new Image("ms-mage0.png", true);
        Image characterImage3 = new Image("ms-rogue0.png", true);

        if (warriorChosen == true) {
            imageClass.setImage(characterImage1);
            classInfo.setText("You have chosen the Warrior!"
                            + "\n\nThe warrior uses her melee weapon"
                            + "\nto slay her foes. With the lowest base damage"
                            + "\nof the three she compensates with wielding heavy"
                            + "\narmor and a shield, making her base defence"
                            + "\nthe highest of the three."
                            + "\nThe warriors' secondary attack is a shield bash that has"
                            + "\na chance to stun the enemy for two turns, but only does"
                            + "\nhalf the damage of a normal attack.");
        } else if (mageChosen == true) {
            imageClass.setImage(characterImage2);
            classInfo.setText("You have chosen the Mage!"
                            + "\n\nWearing only a robe, the mages'"
                            + "\nbase defence is the lowest."
                            + "\nBut do not let him fool you!"
                            + "\nInstead he uses powerful magic to overcome"
                            + "\nhis enemies, causing him to have the"
                            + "\nhighest base damage."
                            + "\nThe mages' secondary attack is a spell"
                            + "\nnamed flame burst. If it hits, the monster"
                            + "\nwill first take double damage, then it will"
                            + "\nget a burn effect, making it take a small amount"
                            + "\nof damage for five turns.");
        } else if (rogueChosen == true) {
            imageClass.setImage(characterImage3);
            classInfo.setText("You have chosen the Rogue!"
                            + "\n\nWearing leather gear to make him more"
                            + "\nagile and dual wielding weapons to strike"
                            + "\nhis enemies. This makes the rogues' base damage"
                            + "\nand base defence to be inbetween the other two."
                            + "\nThe rogues' secondary attack is assassinate."
                            + "\nWhen used it doubles his defence that turn and"
                            + "\nhas a small chance to kill you enemy in one"
                            + "\nsingle hit.");
        }

    }

    private void createNewCharacter(ActionEvent event, String path) {

        int arraySlot = 0;
        String charName = characterName.getText();

        for (DBTable2LoginHasCharacters test : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if (test.getCharacters_idNr() > 0) {
                arraySlot++;
            }
        }
        System.out.println(arraySlot);
        if (chosenCharacter) {
            if (charName.length() > 0) {
                if (arraySlot < 3) {
                    if (warriorChosen) {
                        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(arraySlot).setCharacters_idNr(1);
                    } else if (mageChosen) {
                        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(arraySlot).setCharacters_idNr(2);
                    } else if (rogueChosen) {
                        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(arraySlot).setCharacters_idNr(3);
                    }
                    if (true) {
                        AllLocalData.getInstance().getInfo2LoginHasCharacters().get(arraySlot).setCharacterName(charName);
                        loadSetBaseData(arraySlot);
                        
                        
                        DatabaseServer.getInstance().saveToDB();
                        UserData.getInstance().test001LoadCharDataFromALLLOCALDATA();
                    
                        
                        UserData.getInstance().setArraylistNumber(arraySlot);
                        
                        loadScene(event, path);
                    }

                } else {
                    System.out.println("All Slot Are Full");
                    Error1.setText("All Slot Are Full");
                }
            } else {
                System.out.println("no charactername");
                Error1.setText("no charactername");
            }
        } else {
            System.out.println("No character Chosen");
            Error1.setText("No character Chosen");
        }
    }
    
    
    
    
    
    
    private void loadScene(ActionEvent event, String path) {
        try {

            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
            //stage1.setFullScreen(true);
            stage1.setResizable(false);

        } catch (Exception ex) {
            System.out.println("Loading " + path + " error!");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    

}
