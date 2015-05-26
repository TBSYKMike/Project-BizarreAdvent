/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class AllLocalData {

    private static AllLocalData instance;
    //private StringProperty previousScene = new SimpleStringProperty();

    private AllLocalData() {
    }

    public static AllLocalData getInstance() {

        if (instance == null) {
            instance = new AllLocalData();
        }

        return instance;

    }

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
    private ArrayList<DBTable1Login> info1Login = new ArrayList<>();

    private ArrayList<DBTable2LoginHasCharacters> info2LoginHasCharacters = new ArrayList<>();

    private ArrayList<DBTable3Characters> info3Characters = new ArrayList<>();

    //private int id = info1Login.get(0).getIdNr();
    public ArrayList<DBTable1Login> getInfo1Login() {
        return info1Login;
    }

    public ArrayList<DBTable2LoginHasCharacters> getInfo2LoginHasCharacters() {
        return info2LoginHasCharacters;
    }

    public ArrayList<DBTable3Characters> getInfo3Characters() {
        return info3Characters;
    }

    public void clearAllLocalData() {
        System.out.println(info2LoginHasCharacters.isEmpty());
        info1Login.clear();
        info2LoginHasCharacters.clear();
        info3Characters.clear();
        System.out.println(info2LoginHasCharacters.isEmpty());
    }

    public void clearStatsData() {
        System.out.println(info2LoginHasCharacters.isEmpty());
        info2LoginHasCharacters.clear();
        info3Characters.clear();
        System.out.println(info2LoginHasCharacters.isEmpty());
    }

    public void deleteCharFromSlot(int nr) {
        try {

            info2LoginHasCharacters.remove(nr - 1);
            for (int i = 0; i < info2LoginHasCharacters.size(); i++) {
                info2LoginHasCharacters.get(i).setCharSlot((i + 1));
            }

            info2LoginHasCharacters.add(new DBTable2LoginHasCharacters(info1Login.get(0).getIdNr(), 3, 0, 0, "null", 0, 0, 0, 0, 0, 0, 0));

        } catch (Exception e) {
            System.out.println("Error: deleteCharFromSlot");
        }

    }

}
