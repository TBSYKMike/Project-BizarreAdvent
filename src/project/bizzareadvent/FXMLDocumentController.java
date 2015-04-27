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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.DatabaseServer;
import project.bizzareadvent.SaveLoad.UserData;

/**
 *
 * @author Mike
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelMessage;
    
    @FXML
    private Label forgotPassword;
    //***********************************Commit test /Kim**************************

    @FXML
    private TextField textfieldUsername, textfieldPassword;

    @FXML
    private Button button;
    @FXML
    private ImageView imageView;

    @FXML
    private void handleButtonActionLogin(ActionEvent event) {
        boolean login = false;

        if (checkLogin()) {
            login = true;
            
            DatabaseServer.getInstance().loadDATAFromDB();
            DatabaseServer.getInstance().loadDATAFromDB();
        } else {
            System.out.println("failed login");
            labelMessage.setText("failed login");
        }

        if (login) {
            try {

                Node node = (Node) event.getSource();
                Stage stage1 = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLScene2.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage1.setScene(scene);
                stage1.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
            }
        }
    }
    
    @FXML
    private void handleButtonActionNewAccount(ActionEvent event) {
        
            try {

                Node node = (Node) event.getSource();
                Stage stageNewAccount = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNewAccount.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageNewAccount.setScene(scene);
                stageNewAccount.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
            }
        
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/login_dragon.jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        
        
    }

    private boolean checkLogin() {
        boolean correct = false;
        try {
            
                    correct = correct = DatabaseServer.getInstance().loginToDB(textfieldUsername.getText(), textfieldPassword.getText());
                
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
        return correct;
    }

    @FXML
    public void handleKeyEvent(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            System.out.println("enter");
            button.fire();
            labelMessage.requestFocus();
        }
    }

    @FXML
    public void handleForgottPassword (){
        forgotPassword.setText("Contact admin at: kim_krok@hotmail.com");
    }
    

    @FXML
    public void handleMouseEvent(MouseEvent ke) {
        
        forgotPassword.setText("Forgot password?");
        labelMessage.setText(null);

    }
    
}
