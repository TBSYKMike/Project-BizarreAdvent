/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
import project.bizzareadvent.Characters1TEMP;
import project.bizzareadvent.Mage;

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
    private int selectedSlot = 1;
    private int charID;
    private int baseHp;
    private int baseDef;
    private int baseAttack;
    private int baseDmg;
    private int charSlot;
    private String characterName;
    private int currentHp;
    private int currentDef;
    private int currentAttack;
    private int currentDmg;
    private int currentArmorUpgrade;
    private int currentWeaponUpgradeHp;
    private int currentScore;
    private int currentGold;
    
    private boolean loadOnce = true;
    private ArrayList<Characters1TEMP> ArrList = new ArrayList<>();
    private ArrayList<Mage> mageArrList = new ArrayList<>();
    private ArrayList<Mage> warriorArrList = new ArrayList<>();
    private ArrayList<Mage> assassinArrList = new ArrayList<>();

    
    
    public void makeChar() {
        if (loadOnce) {
            //ArrList.add( new Characters(int CharSlot, String Name, int HPcurrent, int HPBase, int Attack, int Defense, int Damage, int Upgrades));
            //ArrList.add(new Characters1TEMP(1, "Char1Warrior", 100, 100, 50, 50, 50, 0));
            //ArrList.add(new Characters1TEMP(2, "Char2Mage", 100, 100, 50, 50, 50, 0));
            //ArrList.add(new Characters1TEMP(3, "Char3Assassin", 100, 100, 50, 50, 50, 0));
            
            //mageArrList.add(new Mage(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold))
           //   mageArrList.add(new Mage(100, 50, 50, 50, 1, "Mage", 100, 50, 50, 50, 0, 0, 0, 0));
             // warriorArrList.add(new Mage(100, 50, 50, 50, 2, "Warrior", 100, 50, 50, 50, 0, 0, 0, 0));
            //  assassinArrList.add(new Mage(100, 50, 50, 50, 3, "Assassin", 100, 50, 50, 50, 0, 0, 0, 0));
            warriorArrList.add(new Mage(0, 0, 0, 0, 1, null, 0, 0, 0, 0, 0, 0, 0, 0));  
            mageArrList.add(new Mage(0, 0, 0, 0, 2, null, 0, 0, 0, 0, 0, 0, 0, 0));
            assassinArrList.add(new Mage(0, 0, 0, 0, 3, null, 0, 0, 0, 0, 0, 0, 0, 0));
              
            
            loadOnce = false;
        }
    }
    
    public void loadCharTo(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public String getUsername() {
        return Username;
    }
    public int getSelectedSlot() {
        return selectedSlot;
    }
    
    
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.

    
    // Use this method to reset the current user to change to another.
    public void reset(){
        mageArrList.clear();
        warriorArrList.clear();
        assassinArrList.clear();
        loadOnce = true;
        Username = "";
    }

    
    
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.
    public void loadFromSlot(int slot){
        selectedSlot = slot;
        boolean slotempty = true;
        
        
        if(selectedSlot==1){
            for (Mage warriorArrList1 : warriorArrList) {
                
                    baseHp = warriorArrList1.getHp();
                    baseDef = warriorArrList1.getDef();
                    baseAttack = warriorArrList1.getAttack();
                    baseDmg = warriorArrList1.getDmg();
                    charSlot = warriorArrList1.getCharSlot();
                    characterName = warriorArrList1.getCharacterName();
                    currentHp = warriorArrList1.getCurrentHp();
                    currentDef = warriorArrList1.getCurrentDef();
                    currentAttack = warriorArrList1.getCurrentAttack();
                    currentDmg = warriorArrList1.getCurrentDmg();
                    currentArmorUpgrade = warriorArrList1.getCurrentArmorUpgrade();
                    currentWeaponUpgradeHp = warriorArrList1.getCurrentWeaponUpgrade();
                    currentScore = warriorArrList1.getCurrentScore();
                    currentGold = warriorArrList1.getCurrentGold();
                    slotempty = false; 
                    charID = 1;
                
            }
        }
        if(selectedSlot==2){
            for (Mage mageArrList1 : mageArrList) {
                
                    baseHp = mageArrList1.getHp();
                    baseDef = mageArrList1.getDef();
                    baseAttack = mageArrList1.getAttack();
                    baseDmg = mageArrList1.getDmg();
                    charSlot = mageArrList1.getCharSlot();
                    characterName = mageArrList1.getCharacterName();
                    currentHp = mageArrList1.getCurrentHp();
                    currentDef = mageArrList1.getCurrentDef();
                    currentAttack = mageArrList1.getCurrentAttack();
                    currentDmg = mageArrList1.getCurrentDmg();
                    currentArmorUpgrade = mageArrList1.getCurrentArmorUpgrade();
                    currentWeaponUpgradeHp = mageArrList1.getCurrentWeaponUpgrade();
                    currentScore = mageArrList1.getCurrentScore();
                    currentGold = mageArrList1.getCurrentGold();
                    slotempty = false; 
                    charID = 2;
                
            }
        }    
        if(selectedSlot==3){
            for (Mage assassinArrList1 : assassinArrList) {
                
                    baseHp = assassinArrList1.getHp();
                    baseDef = assassinArrList1.getDef();
                    baseAttack = assassinArrList1.getAttack();
                    baseDmg = assassinArrList1.getDmg();
                    charSlot = assassinArrList1.getCharSlot();
                    characterName = assassinArrList1.getCharacterName();
                    currentHp = assassinArrList1.getCurrentHp();
                    currentDef = assassinArrList1.getCurrentDef();
                    currentAttack = assassinArrList1.getCurrentAttack();
                    currentDmg = assassinArrList1.getCurrentDmg();
                    currentArmorUpgrade = assassinArrList1.getCurrentArmorUpgrade();
                    currentWeaponUpgradeHp = assassinArrList1.getCurrentWeaponUpgrade();
                    currentScore = assassinArrList1.getCurrentScore();
                    currentGold = assassinArrList1.getCurrentGold();
                    slotempty = false; 
                    charID = 3;
                
            }
        }
        
        
    }
    
    
    public void saveToSlot(){
        
        boolean slotempty = true;
        
        if(selectedSlot==1){
            for (Mage warriorArrList1 : warriorArrList) {
                
                    warriorArrList1.setCharSlot(selectedSlot);
                    warriorArrList1.setCharacterName(characterName);
                    warriorArrList1.setCurrentHp(currentHp);
                    warriorArrList1.setCurrentDef(currentDef);
                    warriorArrList1.setCurrentAttack(currentAttack);
                    warriorArrList1.setCurrentDmg(currentDmg);
                    warriorArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                    warriorArrList1.setCurrentWeaponUpgrade(currentWeaponUpgradeHp);
                    warriorArrList1.setCurrentScore(currentScore);
                    warriorArrList1.setCurrentGold(currentGold);
                    slotempty = false; 
                
            }
        }
        
        if(selectedSlot==2){
            for (Mage mageArrList1 : mageArrList) {
                
                    mageArrList1.setCharSlot(selectedSlot);
                    mageArrList1.setCharacterName(characterName);
                    mageArrList1.setCurrentHp(currentHp);
                    mageArrList1.setCurrentDef(currentDef);
                    mageArrList1.setCurrentAttack(currentAttack);
                    mageArrList1.setCurrentDmg(currentDmg);
                    mageArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                    mageArrList1.setCurrentWeaponUpgrade(currentWeaponUpgradeHp);
                    mageArrList1.setCurrentScore(currentScore);
                    mageArrList1.setCurrentGold(currentGold);
                    slotempty = false; 
                
            }
        }    
        if(selectedSlot==3){
            for (Mage assassinArrList1 : assassinArrList) {
               
                    assassinArrList1.setCharSlot(selectedSlot);
                    assassinArrList1.setCharacterName(characterName);
                    assassinArrList1.setCurrentHp(currentHp);
                    assassinArrList1.setCurrentDef(currentDef);
                    assassinArrList1.setCurrentAttack(currentAttack);
                    assassinArrList1.setCurrentDmg(currentDmg);
                    assassinArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                    assassinArrList1.setCurrentWeaponUpgrade(currentWeaponUpgradeHp);
                    assassinArrList1.setCurrentScore(currentScore);
                    assassinArrList1.setCurrentGold(currentGold);
                    slotempty = false; 
                
            }
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Getter and Setter Method to set or get Character Stats
    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    public int getCharSlot() {
        return charSlot;
    }

    public void setCharSlot(int charSlot) {
        this.charSlot = charSlot;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCurrentDef() {
        return currentDef;
    }

    public void setCurrentDef(int currentDef) {
        this.currentDef = currentDef;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public int getCurrentDmg() {
        return currentDmg;
    }

    public void setCurrentDmg(int currentDmg) {
        this.currentDmg = currentDmg;
    }

    public int getCurrentArmorUpgrade() {
        return currentArmorUpgrade;
    }

    public void setCurrentArmorUpgrade(int currentArmorUpgrade) {
        this.currentArmorUpgrade = currentArmorUpgrade;
    }

    public int getCurrentWeaponUpgradeHp() {
        return currentWeaponUpgradeHp;
    }

    public void setCurrentWeaponUpgradeHp(int currentWeaponUpgradeHp) {
        this.currentWeaponUpgradeHp = currentWeaponUpgradeHp;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    // Getter and Setter Method to set or get Character Stats
    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }
    
    

    
    

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }
    
    
    
    
    
    
    
    
    

}
