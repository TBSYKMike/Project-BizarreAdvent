/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
import project.bizzareadvent.Characters;

/**
 *
 * @author Mike
 */
public class UserData {

    private static UserData instance;
    //private StringProperty previousScene = new SimpleStringProperty();

    private UserData() {
    }

    public static UserData getInstance() {

        if (instance == null) {
            instance = new UserData();
        }

        return instance;

    }

    private String Username;
    private int selectedSlot;
    private boolean loadOnce = true;
    private ArrayList<Characters> ArrList = new ArrayList<>();

    public void makeChar() {
        if (loadOnce) {
            //ArrList.add( new Characters(int CharSlot, String Name, int HPcurrent, int HPBase, int Attack, int Defense, int Damage, int Upgrades));
            ArrList.add(new Characters(1, "Char1Warrior", 100, 100, 50, 50, 50, 0));
            ArrList.add(new Characters(2, "Char2Mage", 100, 100, 50, 50, 50, 0));
            ArrList.add(new Characters(3, "Char3Assassin", 100, 100, 50, 50, 50, 0));
            loadOnce = false;
        }
    }

    /**
     * Set slot must be done to Load correct Character, Slot input should be 1,
     * 2 or 3.
     */
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.
    public void setSelectedSlot(int slot) {
        selectedSlot = slot - 1;
    }
    
    
    // Use this method to reset the current user to change to another.
    public void reset(){
        ArrList.clear();
        loadOnce = true;
        Username = "";
    }
    
    
    
    
    
    
    
    
    
    // Getter and Setter Method to set or get Character Stats

    public String getName() {
        return ArrList.get(selectedSlot).getName();
    }

    public void setName(String Name) {
        ArrList.get(selectedSlot).setName(Name);
    }

    public int getHPcurrent() {
        return ArrList.get(selectedSlot).getHPcurrent();
    }

    public void setHPcurrent(int HPcurrent) {
        ArrList.get(selectedSlot).setHPcurrent(HPcurrent);
    }

    public int getHPbase() {
        return ArrList.get(selectedSlot).getHPbase();
    }

    public void setHPbase(int HPcase) {
        ArrList.get(selectedSlot).setHPbase(HPcase);
    }

    public int getAttack() {
        return ArrList.get(selectedSlot).getAttack();
    }

    public void setAttack(int Attack) {
        ArrList.get(selectedSlot).setAttack(Attack);
    }

    public int getDefense() {
        return ArrList.get(selectedSlot).getDefense();
    }

    public void setDefense(int Defense) {
        ArrList.get(selectedSlot).setDefense(Defense);
    }

    public int getDamage() {
        return ArrList.get(selectedSlot).getDamage();
    }

    public void setDamage(int Damage) {
        ArrList.get(selectedSlot).setDamage(Damage);
    }

    public int getUpgrades() {
        return ArrList.get(selectedSlot).getUpgrades();
    }

    public void setUpgrades(int Upgrades) {
        ArrList.get(selectedSlot).setUpgrades(Upgrades);
    }

}
