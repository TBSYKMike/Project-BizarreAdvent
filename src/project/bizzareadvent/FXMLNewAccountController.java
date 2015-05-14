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
import java.sql.*;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.DatabaseServer;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLNewAccountController implements Initializable {

    @FXML
    private Label labelMessage;

    @FXML
    private TextField textfieldUsername, textfieldPassword1, textfieldPassword2;

    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();

        } catch (IOException ex) {
            System.out.println("Scene change error1");
        }

    }

    //test of adding new stuff to database
    private int countIdNr;

    @FXML
    public void handleButtonActionCreate(ActionEvent event) {

        boolean createYesNo = true;

        DatabaseServer.getInstance().connectToDB();

        try ( Connection c = DriverManager.getConnection( DatabaseServer.getInstance().getURL() ) ) {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login");

            String name0 = textfieldUsername.getText();
            String password1 = textfieldPassword1.getText();
            String password2 = textfieldPassword2.getText();

            if (name0.length() > 0 && password1.equals(password2) && password1.length() > 0) {

                while (rs.next()) {
                    String nameDB = rs.getString("userName");
                    String passwordDB = rs.getString("password");
                    System.out.println("Customer Name: " + nameDB + " \nand customer number " + passwordDB + "\n\n");
                    countIdNr = rs.getInt("idNr");
                    countIdNr++;

                    if (nameDB.equalsIgnoreCase(name0)) {
                        createYesNo = false;
                        labelMessage.setText("name exists");
                    }

                }

                if (createYesNo) {
                    st.execute("INSERT INTO login (idNr, userName, password) VALUES ('" + countIdNr + "', '" + name0 + "', '" + password1 + "')");
                    //st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + countIdNr + "', '1', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                    //st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + countIdNr + "', '2', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                    //st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + countIdNr + "', '3', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");

                    labelMessage.setText("new account created");
                    textfieldUsername.clear();
                    textfieldPassword1.clear();
                    textfieldPassword2.clear();
                    labelMessage.requestFocus();
                    
                    textfieldUsername.setDisable(true);
                    button.setDisable(true);
                    textfieldPassword1.setDisable(true);
                    textfieldPassword2.setDisable(true);
                    
                    
                }

            } else {
                labelMessage.setText("error");
            }

            c.close();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }

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
    public void handleMouseEvent(MouseEvent ke) {

        labelMessage.setText(null);

    }
}
