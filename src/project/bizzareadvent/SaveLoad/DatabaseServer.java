/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mike
 */
public class DatabaseServer {
    //kod för att inloggning och skapa ny konto och andra koder för att spara information

    private static DatabaseServer instance;

    private DatabaseServer() {
    }

    public static DatabaseServer getInstance() {

        if (instance == null) {
            instance = new DatabaseServer();
        }

        return instance;

    }

    public boolean loginToDB(String inputUsername, String inputPassword) {  // getting username and password from the login scene

        AllLocalData.getInstance().clearAllLocalData();     // to clear all local data before login
        UserData.getInstance().reset();                     // to clear all local data before login

        boolean correct = false;        // value use for checking if login is successful or unsuccessful

        connectToDB(); // establishing connetion to database 
        try (Connection c = DriverManager.getConnection(URL)) {    // sql Commands
            Statement st = c.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT * FROM login");

            String name0 = inputUsername;
            String password0 = inputPassword;

            while (rs1.next()) {
                String username = rs1.getString("userName");
                String password = rs1.getString("password");
                //System.out.println("Customer Name: " + name + " \nand customer number " + password + "\n\n");
                if (username.equals(name0) && password.equals(password0)) {
                    System.out.println("Clear");
                    correct = true;

                    AllLocalData.getInstance().getInfo1Login().add(new DBTable1Login(rs1.getInt("idNr"), rs1.getString("userName"), rs1.getString("password")));
                }

            }

            c.close();  // closing connection

            if (true) { //printing out all data from all arraylists
                System.out.println("\n\n\n");
                System.out.println("loginToDB method");
                System.out.println("DBTable1Login");
                for (DBTable1Login info1Login1 : AllLocalData.getInstance().getInfo1Login()) {
                    System.out.println(info1Login1.getIdNr() + " " + info1Login1.getUserName() + " " + info1Login1.getPassword());
                }
                System.out.println("DBTable2LoginHasCharacters");
                for (DBTable2LoginHasCharacters info2LoginHasCharacters1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
                    System.out.println(info2LoginHasCharacters1.getLogin_idNr() + " " + info2LoginHasCharacters1.getCharSlot() + " " + info2LoginHasCharacters1.getCharacters_idNr() + " " + info2LoginHasCharacters1.getScore() + " " + info2LoginHasCharacters1.getCharacterName() + " " + info2LoginHasCharacters1.getArmorUpgrade() + " " + info2LoginHasCharacters1.getWeaponUpgrade() + " " + info2LoginHasCharacters1.getCurrentHp() + " " + info2LoginHasCharacters1.getGold() + " " + info2LoginHasCharacters1.getCurrentDmg() + " " + info2LoginHasCharacters1.getCurrentDef() + " " + info2LoginHasCharacters1.getCurrentAttack());

                }
                System.out.println("DBTable3Characters");
                for (DBTable3Characters info3Characters1 : AllLocalData.getInstance().getInfo3Characters()) {
                    System.out.println(info3Characters1.getIdNr() + " " + info3Characters1.getCharacterType() + " " + info3Characters1.getBaseHp() + " " + info3Characters1.getBaseDmg() + " " + info3Characters1.getBaseDef() + " " + info3Characters1.getBaseAttack());

                }

            }

        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return correct;
    }

    public void saveToDB() {
        //int counter = 0;

        connectToDB();

        try (Connection c = DriverManager.getConnection(URL)) {

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login_has_characters");

            Statement st1 = c.createStatement();
            Statement st2 = c.createStatement();
            Statement st3 = c.createStatement();

            // alternative 1
            boolean doONCE = true;
            while (rs.next()) {
                int idNRDDB = rs.getInt("Login_idNr");

                if (AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() == idNRDDB && doONCE) {
                    doONCE = false;
                    if (true) {
                        //int GET_IDNR = AllLocalData.getInstance().getInfo1Login().get(0).getIdNr();
                        int IDNR_COUNTER = 0;
                        for (DBTable2LoginHasCharacters info2LoginHasCharacter1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) { // saving all local character data to database
                            IDNR_COUNTER++;

                            String sqlCmd = "UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='" + info2LoginHasCharacter1.getCharacters_idNr() + "', `score`='" + info2LoginHasCharacter1.getScore() + "', `characterName`='" + info2LoginHasCharacter1.getCharacterName() + "', `armorUpgrade`='" + info2LoginHasCharacter1.getArmorUpgrade() + "', `weaponUpgrade`='" + info2LoginHasCharacter1.getWeaponUpgrade() + "', `currentHp`='" + info2LoginHasCharacter1.getCurrentHp() + "', `gold`='" + info2LoginHasCharacter1.getGold() + "', `currentDmg`='" + info2LoginHasCharacter1.getCurrentDmg() + "', `currentDef`='" + info2LoginHasCharacter1.getCurrentDef() + "', `currentAttack`='" + info2LoginHasCharacter1.getCurrentAttack() + "' WHERE `Login_idNr`='" + info2LoginHasCharacter1.getLogin_idNr() + "' and`charSlot`='" + info2LoginHasCharacter1.getCharSlot() + "'";

                            if (IDNR_COUNTER == 1) {
                                st1.execute(sqlCmd);
                            }
                            if (IDNR_COUNTER == 2) {
                                st2.execute(sqlCmd);
                            }
                            if (IDNR_COUNTER == 3) {
                                st3.execute(sqlCmd);
                            }

                        }

                    }
                }
            }

            /*
             //alternative 2
             if (AllLocalData.getInstance().getInfo2LoginHasCharacters().isEmpty()) {
             st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '1', '1', '111', 'p1 char3', '1', '2', '3', '4', '5', '6', '7');");
             st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '2', '2', '111', 'p1 char3', '1', '2', '3', '4', '5', '6', '7');");
             st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '3', '3', '111', 'p1 char3', '1', '2', '3', '4', '5', '6', '7');");

             } else {

             int GET_IDNR = AllLocalData.getInstance().getInfo1Login().get(0).getIdNr();
             int IDNR_COUNTER = 0;
             for (DBTable2LoginHasCharacters info2LoginHasCharacter1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
             IDNR_COUNTER++;

             st.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='" + info2LoginHasCharacter1.getCharacters_idNr() + "', `score`='" + info2LoginHasCharacter1.getScore() + "', `characterName`='" + info2LoginHasCharacter1.getCharacterName() + "', `armorUpgrade`='" + info2LoginHasCharacter1.getArmorUpgrade() + "', `weaponUpgrade`='" + info2LoginHasCharacter1.getWeaponUpgrade() + "', `currentHp`='" + info2LoginHasCharacter1.getCurrentHp() + "', `gold`='" + info2LoginHasCharacter1.getGold() + "', `currentDmg`='" + info2LoginHasCharacter1.getCurrentDmg() + "', `currentDef`='" + info2LoginHasCharacter1.getCurrentDef() + "', `currentAttack`='" + info2LoginHasCharacter1.getCurrentAttack() + "' WHERE `Login_idNr`='" + GET_IDNR + "' and`charSlot`='" + IDNR_COUNTER + "'");

             }

             }

             */
            c.close();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }

    }

    public void loadDATAFromDB() {

        for (int i = 0; i < 2; i++) {

            AllLocalData.getInstance().clearStatsData();

            connectToDB();

            try (Connection c = DriverManager.getConnection(URL)) {

                Statement st = c.createStatement();

                for (int CHARidNr = 1; CHARidNr <= 3; CHARidNr++) {    // adding all basedata from database to local
                    ResultSet rs2alternative = st.executeQuery("SELECT * FROM characters");
                    while (rs2alternative.next()) {
                        if (rs2alternative.getInt("idNr") == CHARidNr) {

                            AllLocalData.getInstance().getInfo3Characters().add(new DBTable3Characters(rs2alternative.getInt("idNr"), rs2alternative.getString("characterType"), rs2alternative.getInt("baseHp"), rs2alternative.getInt("baseDmg"), rs2alternative.getInt("baseDef"), rs2alternative.getInt("baseAttack")));

                        }
                    }
                }

                for (int slot = 1; slot <= 3; slot++) {     // adding all currentdata from database to local
                    ResultSet rs3alternative = st.executeQuery("SELECT * FROM login_has_characters");
                    while (rs3alternative.next()) {
                        if (AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() == rs3alternative.getInt("Login_idNr") && rs3alternative.getInt("charSlot") == slot) {

                            AllLocalData.getInstance().getInfo2LoginHasCharacters().add(new DBTable2LoginHasCharacters(rs3alternative.getInt("Login_idNr"), rs3alternative.getInt("charSlot"), rs3alternative.getInt("Characters_idNr"), rs3alternative.getInt("score"), rs3alternative.getString("characterName"), rs3alternative.getInt("armorUpgrade"), rs3alternative.getInt("weaponUpgrade"), rs3alternative.getInt("currentHp"), rs3alternative.getInt("gold"), rs3alternative.getInt("currentDmg"), rs3alternative.getInt("currentDef"), rs3alternative.getInt("currentAttack")));

                        }
                    }
                }

                if (AllLocalData.getInstance().getInfo2LoginHasCharacters().isEmpty()) {  // if arraylist is empty that means that characters does not exits in the database
                    st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '1', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                    st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '2', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                    st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '3', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                }

                if (true) {   // printing all local data from all arraylists
                    System.out.println("\n\n\n");
                    System.out.println("loadDATAFromDB method");
                    System.out.println("DBTable1Login");
                    for (DBTable1Login info1Login1 : AllLocalData.getInstance().getInfo1Login()) {
                        System.out.println(info1Login1.getIdNr() + " " + info1Login1.getUserName() + " " + info1Login1.getPassword());
                    }
                    System.out.println("DBTable2LoginHasCharacters");
                    for (DBTable2LoginHasCharacters info2LoginHasCharacters1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
                        System.out.println(info2LoginHasCharacters1.getLogin_idNr() + " " + info2LoginHasCharacters1.getCharSlot() + " " + info2LoginHasCharacters1.getCharacters_idNr() + " " + info2LoginHasCharacters1.getScore() + " " + info2LoginHasCharacters1.getCharacterName() + " " + info2LoginHasCharacters1.getArmorUpgrade() + " " + info2LoginHasCharacters1.getWeaponUpgrade() + " " + info2LoginHasCharacters1.getCurrentHp() + " " + info2LoginHasCharacters1.getGold() + " " + info2LoginHasCharacters1.getCurrentDmg() + " " + info2LoginHasCharacters1.getCurrentDef() + " " + info2LoginHasCharacters1.getCurrentAttack());

                    }
                    System.out.println("DBTable3Characters");
                    for (DBTable3Characters info3Characters1 : AllLocalData.getInstance().getInfo3Characters()) {
                        System.out.println(info3Characters1.getIdNr() + " " + info3Characters1.getCharacterType() + " " + info3Characters1.getBaseHp() + " " + info3Characters1.getBaseDmg() + " " + info3Characters1.getBaseDef() + " " + info3Characters1.getBaseAttack());

                    }

                }

                c.close();

            } catch (SQLException e) {
                System.err.println("ERROR: " + e);
            }
        }
    }

    private String URL;

    public String getURL() {
        return URL;
    }

    public void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            URL = "jdbc:mysql://127.0.0.1:3306/gamedb?user=root&password=root";
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Error Connecting to Database");
            System.err.println("ERROR: " + e);
        }
    }

}
