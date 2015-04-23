/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

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
    
    private String HighScore = 
                " 1\n"
                + " 2\n"
                + " 3\n"
                + " 4\n"
                + " 5\n"
                + " 6\n"
                + " 7\n"
                + " 8\n"
                + " 9\n"
                + "10";
    
    private String Username = 
                " Username  1\n"
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
    
    
    
    
}
