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
public class DBTable1Login {
    
    
    //**************************************************************************
    //**************************************************************************
    //**************************************************************************
    //
    // This CLASS is to save all the data FROM the DATABASE
    // And The Data must save here before saving Before saving to the Database
    //
    // DO NOT EDIT* THIS CLASS, ONLY USE THE METHODS FROM THIS CLASS 
    // OR IT WILL F*CK OFF ALL THE CODES
    //
    //
    //
    // *IF YOU DO EDIT YOU'LL ARE RESPOSIBLE TO FIX ALL THE COMMING PROBLEMS
    //
    //**************************************************************************
    //**************************************************************************
    //**************************************************************************
    
    private int idNr;
    private String userName;
    private String password;

    public DBTable1Login(int idNr, String userName, String password) {
        this.idNr = idNr;
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdNr() {
        return idNr;
    }

    public void setIdNr(int idNr) {
        this.idNr = idNr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}
