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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLScene2Controller implements Initializable {
    
    @FXML
    private Button buttonBack;
    @FXML
    private Button NewGame;
    @FXML
    private Button Continue;
    @FXML
    private Button Load;
    @FXML
    private Button HighScore;
    @FXML
    private Button Exit;
    @FXML
    private ImageView imageView;
    
    @FXML
    private void handleButtonActionBack(ActionEvent event) {
        
            try {

                Node node = (Node) event.getSource();
                Stage stage2 = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
            }
        
    }
    
    @FXML
    private void handleButtonActionWorldMap(ActionEvent event) {
        
            try {

                Node node = (Node) event.getSource();
                Stage stage2 = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMap.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
            }
        
    }
    
    
    
    @FXML
    public void handleKeyEvent(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            System.out.println("back button");
            buttonBack.fire();
        }
    }
    @FXML
    public void HandleButtonExit(ActionEvent event){
        Stage stage2 = (Stage) Exit.getScene().getWindow();
        
        stage2.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/MenuCastle.jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    @FXML
    private void handleButtonActionNewGame(ActionEvent event){
        try{
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("newGame.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
        
        }catch(IOException ex){
            System.out.println("Scene change error1");
        }
    }
    
    
    
    @FXML
    private void handleButtonActionChangeTestScene(ActionEvent event){
        try{
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("YYFXMLTestingMethods.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
                UserData.getInstance().setRememeberLastClass(this.getClass().getName());
        
        }catch(IOException ex){
            System.out.println("Scene change error1rrr");
        }
    }
    
    
    @FXML
    private void handleButtonActionDeleteScene(ActionEvent event){
        try{
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDeleteCharacter.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
        
        }catch(IOException ex){
            System.out.println("Scene change error1rrr");
        }
    }
    
    
    @FXML
    private void handleButtonActionLoadScene(ActionEvent event){
        try{
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLoadCharacter.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();
        
        }catch(IOException ex){
            System.out.println("Scene change error1rrr");
        }
    }
    
    
    
}
