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
import java.sql.*;

/**
 *
 * @author Mike
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/testdb0001?user=root&password=root";
            Connection c = DriverManager.getConnection(URL);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login");
            String name0 = "test";
            String password0 = "pass";
            while(rs.next()){
                String name = rs.getString("name");
                String password = rs.getString("password");
                //System.out.println("Customer Name: " + name + " \nand customer number " + password + "\n\n");
                if(name.equals(name0) && password.equals(password0) ){
                    System.out.println("Clear");
                }
            }
            c.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
        
        
        
        
        
        
        
        
    }    
    
}
