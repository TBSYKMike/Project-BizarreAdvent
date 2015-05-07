/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.UserData;

public class FXMLWorldMapController implements Initializable {

    
    @FXML
    private Label nameLabel;
    
    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonCity;
    @FXML
    private Button buttonAdventure;
    @FXML
    private Label hpLabel;
    @FXML
    private Label attackLabel;
    @FXML
    private Label defensLabel;
    @FXML
    private Label goldLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label currentHp;
    @FXML
    private Label currentAttack;
    @FXML
    private Label currentDefens;
    @FXML
    private Label currentGold;
    @FXML
    private Label currentScore;
    @FXML
    private ImageView background;
    @FXML
    private ImageView worldMap;
    @FXML
    private ImageView mapPosition1;
    @FXML
    private ImageView mapPosition2;
    @FXML
    private ImageView mapPosition3;
    @FXML
    private ImageView mapPosition4;
    @FXML
    private ImageView mapPosition5;

    boolean position1 = false;
    boolean position2 = false;
    boolean position3 = false;
    boolean position4 = false;
    boolean position5 = false;

    File file = new File("src/warrior.jpg");
    Image image = new Image(file.toURI().toString());

    File file2 = new File("src/possiblePosition.jpg");
    Image image2 = new Image(file2.toURI().toString());

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapPosition1.setImage(image);
        mapPosition2.setImage(image2);
        mapPosition3.setImage(image2);
        mapPosition4.setImage(image2);
        mapPosition5.setImage(image2);
        
        
        
        nameLabel.setText( UserData.getInstance().getWarriorArrList().getCharacterName() );
        hpLabel.setText( Integer.toString(UserData.getInstance().getMageArrList().getCurrentHp()) );
        
        
        
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

    @FXML
    public void handleButtonActionCity(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCity.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }
    }

    @FXML
    public void handleButtonActionAdventure(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAdventure.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }
    }

    public void movementAction1(ActionEvent event) {
        falseMethod();
        position1 = true;

        updatePosition();
    }

    public void movementAction2(ActionEvent event) {
        falseMethod();
        position2 = true;

        updatePosition();
    }

    public void movementAction3(ActionEvent event) {
        falseMethod();
        position3 = true;

        updatePosition();
    }

    public void movementAction4(ActionEvent event) {
        falseMethod();
        position4 = true;

        updatePosition();
    }

    public void movementAction5(ActionEvent event) {
        falseMethod();
        position5 = true;

        updatePosition();
    }

    public void updatePosition() {
        if (position1 = true) {
            mapPosition1.setImage(image);
            mapPosition2.setImage(image2);
            mapPosition3.setImage(image2);
            mapPosition4.setImage(image2);
            mapPosition5.setImage(image2);

        }
        if (position2 = true) {
            mapPosition1.setImage(image2);
            mapPosition2.setImage(image);
            mapPosition3.setImage(image2);
            mapPosition4.setImage(image2);
            mapPosition5.setImage(image2);

        }
        if (position3 = true) {
            mapPosition1.setImage(image2);
            mapPosition2.setImage(image2);
            mapPosition3.setImage(image);
            mapPosition4.setImage(image2);
            mapPosition5.setImage(image2);

        }
        if (position4 = true) {
            mapPosition1.setImage(image2);
            mapPosition2.setImage(image2);
            mapPosition3.setImage(image2);
            mapPosition4.setImage(image);
            mapPosition5.setImage(image2);

        }
        if (position5 = true) {
            mapPosition1.setImage(image2);
            mapPosition2.setImage(image2);
            mapPosition3.setImage(image2);
            mapPosition4.setImage(image2);
            mapPosition5.setImage(image);

        }
    }

    public void falseMethod() {

        position1 = false;
        position2 = false;
        position3 = false;
        position4 = false;
        position5 = false;

    }

}
