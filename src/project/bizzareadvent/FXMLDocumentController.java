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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private Label labelMessage;
    
    @FXML
    private TextField textfieldUsername, textfieldPassword;
    

    @FXML
    private void handleButtonActionLogin(ActionEvent event) {
        boolean login = false;
        
        if (checkLogin()){
            login = true;
        }else {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        

    }
    
    
    private boolean checkLogin(){
        boolean correct = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/testdb0001?user=root&password=root";
            Connection c = DriverManager.getConnection(URL);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login");
            
            String name0 = textfieldUsername.getText();
            String password0 = textfieldPassword.getText();
            
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                //System.out.println("Customer Name: " + name + " \nand customer number " + password + "\n\n");
                if (name.equals(name0) && password.equals(password0)) {
                    System.out.println("Clear");
                    correct = true;
                }
            }
            c.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
        return correct;
    }
    
    
    
    

}
