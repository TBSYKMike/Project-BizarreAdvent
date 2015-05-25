/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.DatabaseServer;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLHighScoreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextArea textareaHighScore1, textareaHighScore2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String HighScore = DatabaseServer.getInstance().getHighScore();
        //String Username = DatabaseServer.getInstance().getUsername();
        //textareaHighScore1.setText(HighScore);
        //textareaHighScore2.setText(Username);
        String testPrint = "";
        
        
        DatabaseServer.getInstance().connectToDB();
        try (Connection c = DriverManager.getConnection(DatabaseServer.getInstance().getURL())) {    // sql Commands
            Statement st = c.createStatement();
            ResultSet rs1 = st.executeQuery(
                "SELECT gamedb.login.userName, gamedb.login_has_characters.characterName, gamedb.login_has_characters.score\n" +
                "FROM gamedb.login_has_characters, gamedb.login \n" +
                "WHERE score > 0 && gamedb.login.idNr = gamedb.login_has_characters.Login_idNr \n" +
                "ORDER BY score DESC;");

            while (rs1.next()) {
                //String username = rs1.getString("userName");
                //String password = rs1.getString("password");
                //System.out.println("Customer Name: " + name + " \nand customer number " + password + "\n\n");
                
                if (rs1.getRow() <= 10){
                    System.out.printf( rs1.getRow() + " " + rs1.getString(1) + " " + rs1.getString(2) + " " + rs1.getString(3)  );
                    testPrint += rs1.getRow() + " " + rs1.getString(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " \n";
                }
            }

            c.close();  // closing connection

            

            

        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        textareaHighScore1.setText(testPrint);
        
        
    }    
    
    
    @FXML
    private void handleButtonActionBack(ActionEvent event) {
        
            try {

                Node node = (Node) event.getSource();
                Stage stage2 = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
            }
        
    }
    
    
    
}
