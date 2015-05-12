/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
import project.bizzareadvent.Characters;
import project.bizzareadvent.Mage;
import project.bizzareadvent.NewGameController;
import project.bizzareadvent.Rogue;
import project.bizzareadvent.Warrior;

/**
 *
 * @author Mike
 */
public class UserData {

    private static UserData instance;
    //private StringProperty previousScene = new SimpleStringProperty();
    private String adventurePosition;

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
    private int charSlot=1;
    private String characterName;
    private String characterType;
    private int currentHp;
    private int currentDef;
    private int currentAttack;
    private int currentDmg;
    private int currentArmorUpgrade;
    private int currentWeaponUpgrade;
    private int currentScore;
    private int currentGold;

    private boolean loadOnce = true;
    private ArrayList<Characters> charactersArrList = new ArrayList<>();
private ArrayList<Characters> charactersArrList0001 = new ArrayList<>();

    

    public void makeChar(){
        charactersArrList0001.add(new Warrior (100, 10, 10, 8, 1, "WarriorKim", 100, 10, 10, 6, 0, 0, 0, 0));
        //charactersArrList.add(new Mage(100, 6, 10, 12, 3, NewGameController.getInstance().characterName.getText(), 100, 6, 10, 9, 0, 0, 0, 0));
        //charactersArrList.add(new Rogue(100, 7, 10, 10, 2, NewGameController.getInstance().characterName.getText(), 100, 7, 10, 10, 0, 0, 0, 0));
        
    
    
    }

    public Characters getCharactersArrList() {
        
        if(charactersArrList0001.isEmpty()){
            makeChar();
        }
        
        return charactersArrList0001.get(0);
    }
    
    
    private int arraylistNumber = 0;
    
    
    private int loadedSlot = 0;
    
    public int getLoadedSlot() {
        return loadedSlot;
    }
    public void setLoadedSlot(int loadedSlot) {
        this.loadedSlot = loadedSlot;
    }
    
    
    
    
    
    private String tempcharType;
    private int tempcharID;
    private int tempbaseHp;
    private int tempbaseDef;
    private int tempbaseAttack;
    private int tempbaseDmg;
    
    private String tempcharacterName;
    private int tempcurrentHp;
    private int tempcurrentDef;
    private int tempcurrentAttack;
    private int tempcurrentDmg;
    private int tempcurrentArmorUpgrade;
    private int tempcurrentWeaponUpgrade;
    private int tempcurrentScore;
    private int tempcurrentGold;
    
    
    
    
    private void test001loadBaseStatsFromALLLOCALDATA(int charID){
        for (DBTable3Characters loadFromInfo3: AllLocalData.getInstance().getInfo3Characters()) {
            if(loadFromInfo3.getIdNr() ==  charID){
                tempcharType = loadFromInfo3.getCharacterType();
                tempcharID = loadFromInfo3.getIdNr();
                tempbaseHp = loadFromInfo3.getBaseHp();
                tempbaseDef = loadFromInfo3.getBaseDef();
                tempbaseAttack = loadFromInfo3.getBaseAttack();
                tempbaseDmg = loadFromInfo3.getBaseDmg();
            }
        }
    }
    private void test001loadCurrentStatsFromALLLOCALDATA(int charSlot){
        for (DBTable2LoginHasCharacters loadFromInfo2: AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            if(loadFromInfo2.getCharSlot() ==  charSlot){
                
                tempcharacterName = loadFromInfo2.getCharacterName();
                tempcurrentHp  = loadFromInfo2.getCurrentHp();
                tempcurrentDef = loadFromInfo2.getCurrentDef();
                tempcurrentAttack = loadFromInfo2.getCurrentAttack();
                tempcurrentDmg = loadFromInfo2.getCurrentDmg();
                tempcurrentArmorUpgrade = loadFromInfo2.getArmorUpgrade();
                tempcurrentWeaponUpgrade = loadFromInfo2.getWeaponUpgrade();
                tempcurrentScore = loadFromInfo2.getScore();
                tempcurrentGold = loadFromInfo2.getGold();
                
            }
        }
    }
    public void test001LoadCharDataFromALLLOCALDATA(){
        reset();
        clear();
        
        int slot=0;
        for (DBTable2LoginHasCharacters loadFromInfo2: AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            slot++;
            
            test001loadCurrentStatsFromALLLOCALDATA(slot);
            
            
            
            if (        loadFromInfo2.getCharacters_idNr()  ==  1   ){
                //make if CharID is 1 make WARRIOR
                
                test001loadBaseStatsFromALLLOCALDATA(1);
                //warriorArrList.add(new Warrior    (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                //warriorArrList.add( new Warrior (100, 100, 100, 100, slot, "warriorname"+slot , 100, 100, 100, 100, 100, 100, 100, 100));
                charactersArrList.add( new Warrior (tempbaseHp, tempbaseDef, tempbaseDmg, tempbaseHp, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
            }
            else if (  loadFromInfo2.getCharacters_idNr()  ==  2   ){
                //make if CharID is 1 make MAGE
                
                test001loadBaseStatsFromALLLOCALDATA(2);
                //mageArrList.add(new Mage          (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                charactersArrList.add(    new Mage    (tempbaseHp, tempbaseDef, tempbaseDmg, tempbaseHp, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
            }
            else if (  loadFromInfo2.getCharacters_idNr()  ==  3   ){
                //make if CharID is 1 make ROGUE
                
                test001loadBaseStatsFromALLLOCALDATA(3);
                //rogueArrList.add(new Rogue        (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                charactersArrList.add(   new Rogue   (tempbaseHp, tempbaseDef, tempbaseDmg, tempbaseHp, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
            }
            else{
                System.out.println("Error loading slot:"+slot+"is empty");
            }
        
        }
        
    }
    
    public void clear(){
        
                charID = 0;
                currentScore = 0;
                characterName = "null";
                currentArmorUpgrade = 0;
                currentWeaponUpgrade = 0;
                currentHp = 0;
                currentGold = 0;
                currentDmg = 0;
                currentDef = 0;
                currentAttack = 0;
                charSlot = 0;
                characterType = "null";
                baseHp = 0;
                baseDmg = 0;
                baseDef = 0;
                baseAttack = 0;
    }
    
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.
    // Use this method to reset the current user to change to another.
    public void reset() {
        charactersArrList.clear();
        loadOnce = true;
        Username = "";
    }

    
    //@return the adventurePosition
     
    public String getAdventurePosition() {
        return adventurePosition;
    }
    //set the aadventurePosition
    
    public void setAdventurePosition(String adventurePosition) {
        this.adventurePosition = adventurePosition;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
