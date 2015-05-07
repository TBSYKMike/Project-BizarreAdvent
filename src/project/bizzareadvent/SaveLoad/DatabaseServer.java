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
import java.util.ArrayList;

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

    private String HighScore
            = " 1\n"
            + " 2\n"
            + " 3\n"
            + " 4\n"
            + " 5\n"
            + " 6\n"
            + " 7\n"
            + " 8\n"
            + " 9\n"
            + "10";

    private String Username
            = " Username  1\n"
            + " Username  2\n"
            + " Username  3\n"
            + " Username  4\n"
            + " Username  5\n"
            + " Username  6\n"
            + " Username  7\n"
            + " Username  8\n"
            + " Username  9\n"
            + " Username 10";

    public String getHighScore() {
        return HighScore;
    }

    public String getUsername() {
        return Username;
    }

    public boolean loginToDB(String inputUsername, String inputPassword) {
        clearDATA();
        AllLocalData.getInstance().clearAllLocalData();
        UserData.getInstance().reset();

        boolean correct = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/gamedb?user=root&password=root";
            Connection c = DriverManager.getConnection(URL);
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
                    LOGINTABLE_idNr = rs1.getInt("idNr");
                    LOGINTABLE_userName = rs1.getString("userName");
                    LOGINTABLE_password = rs1.getString("password");

                    AllLocalData.getInstance().getInfo1Login().add(new DBTable1Login(rs1.getInt("idNr"), rs1.getString("userName"), rs1.getString("password")));
                }

            }

            c.close();

           
            if (true) {
                System.out.println("\n\n\n");
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

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return correct;
    }

    private int LOGINTABLE_idNr;
    private String LOGINTABLE_userName;
    private String LOGINTABLE_password;

    private int CHARACTERSTABLE1_idNr;
    private String CHARACTERSTABLE1_characterType;
    private int CHARACTERSTABLE1_baseHp;
    private int CHARACTERSTABLE1_baseDmg;
    private int CHARACTERSTABLE1_baseDef;
    private int CHARACTERSTABLE1_baseAttack;

    private int CHARACTERSTABLE2_idNr;
    private String CHARACTERSTABLE2_characterType;
    private int CHARACTERSTABLE2_baseHp;
    private int CHARACTERSTABLE2_baseDmg;
    private int CHARACTERSTABLE2_baseDef;
    private int CHARACTERSTABLE2_baseAttack;

    private int CHARACTERSTABLE3_idNr;
    private String CHARACTERSTABLE3_characterType;
    private int CHARACTERSTABLE3_baseHp;
    private int CHARACTERSTABLE3_baseDmg;
    private int CHARACTERSTABLE3_baseDef;
    private int CHARACTERSTABLE3_baseAttack;

    private int LOGINHASCHARACTERSTABLE1_Login_idNr;
    private int LOGINHASCHARACTERSTABLE1_charSlot;
    private int LOGINHASCHARACTERSTABLE1_Characters_idNr;
    private int LOGINHASCHARACTERSTABLE1_score;
    private String LOGINHASCHARACTERSTABLE1_characterName;
    private int LOGINHASCHARACTERSTABLE1_armorUpgrade;
    private int LOGINHASCHARACTERSTABLE1_weaponUpgrade;
    private int LOGINHASCHARACTERSTABLE1_currentHp;
    private int LOGINHASCHARACTERSTABLE1_gold;
    private int LOGINHASCHARACTERSTABLE1_currentDmg;
    private int LOGINHASCHARACTERSTABLE1_currentDef;
    private int LOGINHASCHARACTERSTABLE1_currentAttack;

    private int LOGINHASCHARACTERSTABLE2_Login_idNr;
    private int LOGINHASCHARACTERSTABLE2_charSlot;
    private int LOGINHASCHARACTERSTABLE2_Characters_idNr;
    private int LOGINHASCHARACTERSTABLE2_score;
    private String LOGINHASCHARACTERSTABLE2_characterName;
    private int LOGINHASCHARACTERSTABLE2_armorUpgrade;
    private int LOGINHASCHARACTERSTABLE2_weaponUpgrade;
    private int LOGINHASCHARACTERSTABLE2_currentHp;
    private int LOGINHASCHARACTERSTABLE2_gold;
    private int LOGINHASCHARACTERSTABLE2_currentDmg;
    private int LOGINHASCHARACTERSTABLE2_currentDef;
    private int LOGINHASCHARACTERSTABLE2_currentAttack;

    private int LOGINHASCHARACTERSTABLE3_Login_idNr;
    private int LOGINHASCHARACTERSTABLE3_charSlot;
    private int LOGINHASCHARACTERSTABLE3_Characters_idNr;
    private int LOGINHASCHARACTERSTABLE3_score;
    private String LOGINHASCHARACTERSTABLE3_characterName;
    private int LOGINHASCHARACTERSTABLE3_armorUpgrade;
    private int LOGINHASCHARACTERSTABLE3_weaponUpgrade;
    private int LOGINHASCHARACTERSTABLE3_currentHp;
    private int LOGINHASCHARACTERSTABLE3_gold;
    private int LOGINHASCHARACTERSTABLE3_currentDmg;
    private int LOGINHASCHARACTERSTABLE3_currentDef;
    private int LOGINHASCHARACTERSTABLE3_currentAttack;

    private void clearDATA() {
        LOGINTABLE_idNr = 0;
        LOGINTABLE_userName = null;
        LOGINTABLE_password = null;

        CHARACTERSTABLE1_idNr = 0;
        CHARACTERSTABLE1_characterType = null;
        CHARACTERSTABLE1_baseHp = 0;
        CHARACTERSTABLE1_baseDmg = 0;
        CHARACTERSTABLE1_baseDef = 0;
        CHARACTERSTABLE1_baseAttack = 0;

        CHARACTERSTABLE2_idNr = 0;
        CHARACTERSTABLE2_characterType = null;
        CHARACTERSTABLE2_baseHp = 0;
        CHARACTERSTABLE2_baseDmg = 0;
        CHARACTERSTABLE2_baseDef = 0;
        CHARACTERSTABLE2_baseAttack = 0;

        CHARACTERSTABLE3_idNr = 0;
        CHARACTERSTABLE3_characterType = null;
        CHARACTERSTABLE3_baseHp = 0;
        CHARACTERSTABLE3_baseDmg = 0;
        CHARACTERSTABLE3_baseDef = 0;
        CHARACTERSTABLE3_baseAttack = 0;

        LOGINHASCHARACTERSTABLE1_Login_idNr = 0;
        LOGINHASCHARACTERSTABLE1_charSlot = 0;
        LOGINHASCHARACTERSTABLE1_Characters_idNr = 0;
        LOGINHASCHARACTERSTABLE1_score = 0;
        LOGINHASCHARACTERSTABLE1_characterName = null;
        LOGINHASCHARACTERSTABLE1_armorUpgrade = 0;
        LOGINHASCHARACTERSTABLE1_weaponUpgrade = 0;
        LOGINHASCHARACTERSTABLE1_currentHp = 0;
        LOGINHASCHARACTERSTABLE1_gold = 0;
        LOGINHASCHARACTERSTABLE1_currentDmg = 0;
        LOGINHASCHARACTERSTABLE1_currentDef = 0;
        LOGINHASCHARACTERSTABLE1_currentAttack = 0;

        LOGINHASCHARACTERSTABLE2_Login_idNr = 0;
        LOGINHASCHARACTERSTABLE2_charSlot = 0;
        LOGINHASCHARACTERSTABLE2_Characters_idNr = 0;
        LOGINHASCHARACTERSTABLE2_score = 0;
        LOGINHASCHARACTERSTABLE2_characterName = null;
        LOGINHASCHARACTERSTABLE2_armorUpgrade = 0;
        LOGINHASCHARACTERSTABLE2_weaponUpgrade = 0;
        LOGINHASCHARACTERSTABLE2_currentHp = 0;
        LOGINHASCHARACTERSTABLE2_gold = 0;
        LOGINHASCHARACTERSTABLE2_currentDmg = 0;
        LOGINHASCHARACTERSTABLE2_currentDef = 0;
        LOGINHASCHARACTERSTABLE2_currentAttack = 0;

        LOGINHASCHARACTERSTABLE3_Login_idNr = 0;
        LOGINHASCHARACTERSTABLE3_charSlot = 0;
        LOGINHASCHARACTERSTABLE3_Characters_idNr = 0;
        LOGINHASCHARACTERSTABLE3_score = 0;
        LOGINHASCHARACTERSTABLE3_characterName = null;
        LOGINHASCHARACTERSTABLE3_armorUpgrade = 0;
        LOGINHASCHARACTERSTABLE3_weaponUpgrade = 0;
        LOGINHASCHARACTERSTABLE3_currentHp = 0;
        LOGINHASCHARACTERSTABLE3_gold = 0;
        LOGINHASCHARACTERSTABLE3_currentDmg = 0;
        LOGINHASCHARACTERSTABLE3_currentDef = 0;
        LOGINHASCHARACTERSTABLE3_currentAttack = 0;
    }

    public void saveToDB() {
        //int counter = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/gamedb?user=root&password=root";
            Connection c = DriverManager.getConnection(URL);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login_has_characters");

            Statement st1 = c.createStatement();
            Statement st2 = c.createStatement();
            Statement st3 = c.createStatement();


            /*    
             // Method 1
            
             while (rs.next()) {
             int idNRDDB = rs.getInt("Login_idNr");
             int charSlotDB = rs.getInt("charSlot");
                    
                    
             if( AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() == idNRDDB){
             counter++;
             System.out.println(counter);
             if (charSlotDB==1){
                            
             //st.execute("UPDATE `gamedb`.`login_has_characters` SET `characterName`='p2Change1', `armorUpgrade`='1', `weaponUpgrade`='2', `currentHp`='3', `gold`='4', `currentDmg`='5', `currentDef`='6', `currentAttack`='7' WHERE `Login_idNr`='"+LOGINTABLE_idNr+"' and`charSlot`='1'");

             //st.execute("UPDATE `gamedb`.`login_has_characters` SET `characterName`='p2Change2', `score`='11', `armorUpgrade`='1', `weaponUpgrade`='2', `currentHp`='3', `gold`='4', `currentDmg`='5', `currentDef`='3', `currentAttack`='7' WHERE `Login_idNr`='"+LOGINTABLE_idNr+"' and`charSlot`='2'");

             //st.execute("UPDATE `gamedb`.`login_has_characters` SET `score`='11', `characterName`='p2Change3lol', `armorUpgrade`='2', `weaponUpgrade`='3', `currentHp`='4', `gold`='5', `currentDmg`='6', `currentDef`='7', `currentAttack`='13' WHERE `Login_idNr`='"+LOGINTABLE_idNr+"' and`charSlot`='3'");
             int counting = 0;
             for (DBTable2LoginHasCharacters info2LoginHasCharacter1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
             counting++;
             //st.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='"+info2LoginHasCharacter1.getCharacters_idNr()+"', `score`='"+info2LoginHasCharacter1.getScore()+"', `characterName`='"+info2LoginHasCharacter1.getCharacterName()+"', `armorUpgrade`='"+info2LoginHasCharacter1.getArmorUpgrade()+"', `weaponUpgrade`='"+info2LoginHasCharacter1.getWeaponUpgrade()+"', `currentHp`='"+info2LoginHasCharacter1.getCurrentHp()+"', `gold`='"+info2LoginHasCharacter1.getGold()+"', `currentDmg`='"+info2LoginHasCharacter1.getCurrentDmg()+"', `currentDef`='"+info2LoginHasCharacter1.getCurrentDef()+"', `currentAttack`='"+info2LoginHasCharacter1.getCurrentAttack()+"' WHERE `Login_idNr`='"+LOGINTABLE_idNr+"' and`charSlot`='"+info2LoginHasCharacter1.getCharSlot()+"'");

             st.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='"+info2LoginHasCharacter1.getCharacters_idNr()+"', `score`='"+info2LoginHasCharacter1.getScore()+"', `characterName`='"+info2LoginHasCharacter1.getCharacterName()+"', `armorUpgrade`='"+info2LoginHasCharacter1.getArmorUpgrade()+"', `weaponUpgrade`='"+info2LoginHasCharacter1.getWeaponUpgrade()+"', `currentHp`='"+info2LoginHasCharacter1.getCurrentHp()+"', `gold`='"+info2LoginHasCharacter1.getGold()+"', `currentDmg`='"+info2LoginHasCharacter1.getCurrentDmg()+"', `currentDef`='"+info2LoginHasCharacter1.getCurrentDef()+"', `currentAttack`='"+info2LoginHasCharacter1.getCurrentAttack()+"' WHERE `Login_idNr`='"+LOGINTABLE_idNr+"' and`charSlot`='"+counting+"'");

                                
             }
                            
                            
                            
                            
                           
             }
                        
                        
             }

             }
                    
             */
            // Method 1 alternative 1
            boolean doONCE = true;
            while (rs.next()) {
                int idNRDDB = rs.getInt("Login_idNr");

                if (AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() == idNRDDB && doONCE) {
                    doONCE = false;
                    if (true) {
                        int GET_IDNR = AllLocalData.getInstance().getInfo1Login().get(0).getIdNr();
                        int IDNR_COUNTER = 0;
                        for (DBTable2LoginHasCharacters info2LoginHasCharacter1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
                            IDNR_COUNTER++;
                            if (IDNR_COUNTER == 1) {
                                st1.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='" + info2LoginHasCharacter1.getCharacters_idNr() + "', `score`='" + info2LoginHasCharacter1.getScore() + "', `characterName`='" + info2LoginHasCharacter1.getCharacterName() + "', `armorUpgrade`='" + info2LoginHasCharacter1.getArmorUpgrade() + "', `weaponUpgrade`='" + info2LoginHasCharacter1.getWeaponUpgrade() + "', `currentHp`='" + info2LoginHasCharacter1.getCurrentHp() + "', `gold`='" + info2LoginHasCharacter1.getGold() + "', `currentDmg`='" + info2LoginHasCharacter1.getCurrentDmg() + "', `currentDef`='" + info2LoginHasCharacter1.getCurrentDef() + "', `currentAttack`='" + info2LoginHasCharacter1.getCurrentAttack() + "' WHERE `Login_idNr`='" + info2LoginHasCharacter1.getCharSlot() + "' and`charSlot`='" + info2LoginHasCharacter1.getCharacters_idNr() + "'");
                            }
                            if (IDNR_COUNTER == 2) {
                                st2.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='" + info2LoginHasCharacter1.getCharacters_idNr() + "', `score`='" + info2LoginHasCharacter1.getScore() + "', `characterName`='" + info2LoginHasCharacter1.getCharacterName() + "', `armorUpgrade`='" + info2LoginHasCharacter1.getArmorUpgrade() + "', `weaponUpgrade`='" + info2LoginHasCharacter1.getWeaponUpgrade() + "', `currentHp`='" + info2LoginHasCharacter1.getCurrentHp() + "', `gold`='" + info2LoginHasCharacter1.getGold() + "', `currentDmg`='" + info2LoginHasCharacter1.getCurrentDmg() + "', `currentDef`='" + info2LoginHasCharacter1.getCurrentDef() + "', `currentAttack`='" + info2LoginHasCharacter1.getCurrentAttack() + "' WHERE `Login_idNr`='" + info2LoginHasCharacter1.getCharSlot() + "' and`charSlot`='" + info2LoginHasCharacter1.getCharacters_idNr() + "'");
                            }
                            if (IDNR_COUNTER == 3) {
                                st3.execute("UPDATE `gamedb`.`login_has_characters` SET `Characters_idNr`='" + info2LoginHasCharacter1.getCharacters_idNr() + "', `score`='" + info2LoginHasCharacter1.getScore() + "', `characterName`='" + info2LoginHasCharacter1.getCharacterName() + "', `armorUpgrade`='" + info2LoginHasCharacter1.getArmorUpgrade() + "', `weaponUpgrade`='" + info2LoginHasCharacter1.getWeaponUpgrade() + "', `currentHp`='" + info2LoginHasCharacter1.getCurrentHp() + "', `gold`='" + info2LoginHasCharacter1.getGold() + "', `currentDmg`='" + info2LoginHasCharacter1.getCurrentDmg() + "', `currentDef`='" + info2LoginHasCharacter1.getCurrentDef() + "', `currentAttack`='" + info2LoginHasCharacter1.getCurrentAttack() + "' WHERE `Login_idNr`='" + info2LoginHasCharacter1.getCharSlot() + "' and`charSlot`='" + info2LoginHasCharacter1.getCharacters_idNr() + "'");
                            }

                        }

                    }
                }
            }

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

            c.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println("ERROR: " + e);
        }

    }

    public void loadDATAFromDB() {

        AllLocalData.getInstance().clearStatsData();
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/gamedb?user=root&password=root";
            Connection c = DriverManager.getConnection(URL);
            Statement st = c.createStatement();
            //ResultSet rs = st.executeQuery("SELECT * FROM login_has_characters");

            for (int CHARidNr = 1; CHARidNr <= 3; CHARidNr++) {
                ResultSet rs2alternative = st.executeQuery("SELECT * FROM characters");
                while (rs2alternative.next()) {
                    if (rs2alternative.getInt("idNr") == CHARidNr) {

                        AllLocalData.getInstance().getInfo3Characters().add(new DBTable3Characters(rs2alternative.getInt("idNr"), rs2alternative.getString("characterType"), rs2alternative.getInt("baseHp"), rs2alternative.getInt("baseDmg"), rs2alternative.getInt("baseDef"), rs2alternative.getInt("baseAttack")));

                    }
                }
            }

            for (int slot = 1; slot <= 3; slot++) {
                ResultSet rs3alternative = st.executeQuery("SELECT * FROM login_has_characters");
                while (rs3alternative.next()) {
                    if (AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() == rs3alternative.getInt("Login_idNr") && rs3alternative.getInt("charSlot") == slot) {

                        AllLocalData.getInstance().getInfo2LoginHasCharacters().add(new DBTable2LoginHasCharacters(rs3alternative.getInt("Login_idNr"), rs3alternative.getInt("charSlot"), rs3alternative.getInt("Characters_idNr"), rs3alternative.getInt("score"), rs3alternative.getString("characterName"), rs3alternative.getInt("armorUpgrade"), rs3alternative.getInt("weaponUpgrade"), rs3alternative.getInt("currentHp"), rs3alternative.getInt("gold"), rs3alternative.getInt("currentDmg"), rs3alternative.getInt("currentDef"), rs3alternative.getInt("currentAttack")));

                    }
                }
            }

            if (AllLocalData.getInstance().getInfo2LoginHasCharacters().isEmpty()) {
                st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '1', '0', '0', 'null1 ', '0', '0', '0', '0', '0', '0', '0');");
                st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '2', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");
                st.execute("INSERT INTO `gamedb`.`login_has_characters` (`Login_idNr`, `charSlot`, `Characters_idNr`, `score`, `characterName`, `armorUpgrade`, `weaponUpgrade`, `currentHp`, `gold`, `currentDmg`, `currentDef`, `currentAttack`) VALUES ('" + AllLocalData.getInstance().getInfo1Login().get(0).getIdNr() + "', '3', '0', '0', 'null1', '0', '0', '0', '0', '0', '0', '0');");

            }

            if (true) {
                System.out.println("\n\n\n");
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println("ERROR: " + e);
        }

    }

}
