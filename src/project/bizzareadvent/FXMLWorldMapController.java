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
    private ImageView mapCityPosition;
    @FXML
    private ImageView mapPlainsposition;
    @FXML
    private ImageView mapForestPosition;
    @FXML
    private ImageView mapSwampPosition;
    @FXML
    private ImageView mapMountainPosition;
    @FXML
    private ImageView mapCastlePosition;

    boolean cityPosition = false;
    boolean plainsPosition = false;
    boolean forestPosition = false;
    boolean swampPosition = false;
    boolean mountainPosition = false;
    boolean castlePosition = false;

    private String adventurePosition;

    File file = new File("src/warrior.jpg");
    Image image = new Image(file.toURI().toString());

    File file2 = new File("src/possiblePosition.jpg");
    Image image2 = new Image(file2.toURI().toString());

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapCityPosition.setImage(image);
        mapPlainsposition.setImage(image2);
        mapForestPosition.setImage(image2);
        mapSwampPosition.setImage(image2);
        mapMountainPosition.setImage(image2);
        mapCastlePosition.setImage(image2);

        nameLabel.setText(UserData.getInstance().getWarriorArrList().getCharacterName());
        hpLabel.setText(Integer.toString(UserData.getInstance().getMageArrList().getCurrentHp()));

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
        cityPosition = true;

        updatePosition();
    }

    public void movementAction2(ActionEvent event) {
        falseMethod();
        plainsPosition = true;
        adventurePosition = "plains";

        UserData.getInstance().setAdventurePosition(adventurePosition);

        updatePosition();
    }

    public void movementAction3(ActionEvent event) {
        falseMethod();
        forestPosition = true;
        adventurePosition = "forest";

        UserData.getInstance().setAdventurePosition(adventurePosition);

        updatePosition();
    }

    public void movementAction4(ActionEvent event) {
        falseMethod();
        swampPosition = true;
        adventurePosition = "swamp";

        UserData.getInstance().setAdventurePosition(adventurePosition);

        updatePosition();
    }

    public void movementAction5(ActionEvent event) {
        falseMethod();
        mountainPosition = true;
        adventurePosition = "mountain";

        UserData.getInstance().setAdventurePosition(adventurePosition);

        updatePosition();
    }

    public void movementAction6(ActionEvent event) {
        falseMethod();
        castlePosition = true;
        adventurePosition = "castle";

        UserData.getInstance().setAdventurePosition(adventurePosition);

        updatePosition();
    }

    public void updatePosition() {
        // method for updating the position picture
        if (cityPosition = true) {
            mapCityPosition.setImage(image);
            mapPlainsposition.setImage(image2);
            mapForestPosition.setImage(image2);
            mapSwampPosition.setImage(image2);
            mapMountainPosition.setImage(image2);
            mapCastlePosition.setImage(image2);

        }
        if (plainsPosition = true) {
            mapCityPosition.setImage(image2);
            mapPlainsposition.setImage(image);
            mapForestPosition.setImage(image2);
            mapSwampPosition.setImage(image2);
            mapMountainPosition.setImage(image2);
            mapCastlePosition.setImage(image2);

        }
        if (forestPosition = true) {
            mapCityPosition.setImage(image2);
            mapPlainsposition.setImage(image2);
            mapForestPosition.setImage(image);
            mapSwampPosition.setImage(image2);
            mapMountainPosition.setImage(image2);
            mapCastlePosition.setImage(image2);

        }
        if (swampPosition = true) {
            mapCityPosition.setImage(image2);
            mapPlainsposition.setImage(image2);
            mapForestPosition.setImage(image2);
            mapSwampPosition.setImage(image);
            mapMountainPosition.setImage(image2);
            mapCastlePosition.setImage(image2);

        }
        if (mountainPosition = true) {
            mapCityPosition.setImage(image2);
            mapPlainsposition.setImage(image2);
            mapForestPosition.setImage(image2);
            mapSwampPosition.setImage(image2);
            mapMountainPosition.setImage(image);
            mapCastlePosition.setImage(image2);

        }
        if (castlePosition = true) {
            mapCityPosition.setImage(image2);
            mapPlainsposition.setImage(image2);
            mapForestPosition.setImage(image2);
            mapSwampPosition.setImage(image2);
            mapMountainPosition.setImage(image2);
            mapCastlePosition.setImage(image);

        }
    }

    public void falseMethod() {
        // sets all positions to false before setting a new one to true 
        
        cityPosition = false;
        plainsPosition = false;
        forestPosition = false;
        swampPosition = false;
        mountainPosition = false;
        castlePosition = false;

    }
}
