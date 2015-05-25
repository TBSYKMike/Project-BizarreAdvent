/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import project.bizzareadvent.Characters;
import project.bizzareadvent.Mage;
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

    
    private int selectedSlot = 1;

   

    private boolean loadOnce = true;
    private ArrayList<Characters> charactersArrList = new ArrayList<>(); // arraylist of the loading from database
    private ArrayList<Characters> charactersArrList0001 = new ArrayList<>(); // arraylist from makeChar()

    

    public void makeChar(){
        charactersArrList0001.add(new Warrior (100, 10, 10, 8, 1, "WarriorKim", 100, 10, 10, 6, 0, 0, 0, 0));
        //charactersArrList.add(new Mage(100, 6, 10, 12, 3, FXMLNewGameController.getInstance().characterName.getText(), 100, 6, 10, 9, 0, 0, 0, 0));
        //charactersArrList.add(new Rogue(100, 7, 10, 10, 2, FXMLNewGameController.getInstance().characterName.getText(), 100, 7, 10, 10, 0, 0, 0, 0));
        
    
    
    }

    public Characters getCharactersArrList() {
        
        if(charactersArrList.isEmpty()){    //byta mellan charactersArrList och charactersArrList0001
            makeChar();
        }
        
        return charactersArrList.get(arraylistNumber);  // byta mellan charactersArrList och charactersArrList0001
    }
    
    
    private int arraylistNumber = 0;

    public int getArraylistNumber() {
        return arraylistNumber;
    }

    public void setArraylistNumber(int arraylistNumber) {
        this.arraylistNumber = arraylistNumber;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
        
        
        int slot=0;
        for (DBTable2LoginHasCharacters loadFromInfo2: AllLocalData.getInstance().getInfo2LoginHasCharacters()) {
            slot++;
            
            test001loadCurrentStatsFromALLLOCALDATA(slot);
            
            
            
            if (        loadFromInfo2.getCharacters_idNr()  ==  1   ){
                //make if CharID is 1 make WARRIOR
                
                test001loadBaseStatsFromALLLOCALDATA(1);
                //warriorArrList.add(new Warrior    (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                //warriorArrList.add( new Warrior (100, 100, 100, 100, slot, "warriorname"+slot , 100, 100, 100, 100, 100, 100, 100, 100));
                charactersArrList.add( new Warrior (tempbaseHp, tempbaseDef, tempbaseAttack, tempbaseDmg, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
                //public Warrior                    (int baseHp, int baseDef, int baseAttack, int baseDmg, charSlot, characterName, int currentHp, int currentDef, int currentAttack, int currentDmg, int currentArmorUpgrade, int currentWeaponUpgrade, int currentScore, int currentGold)
            
            }
            else if (  loadFromInfo2.getCharacters_idNr()  ==  2   ){
                //make if CharID is 1 make MAGE
                
                test001loadBaseStatsFromALLLOCALDATA(2);
                //mageArrList.add(new Mage          (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                charactersArrList.add(    new Mage    (tempbaseHp, tempbaseDef, tempbaseAttack, tempbaseDmg, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
            }
            else if (  loadFromInfo2.getCharacters_idNr()  ==  3   ){
                //make if CharID is 1 make ROGUE
                
                test001loadBaseStatsFromALLLOCALDATA(3);
                //rogueArrList.add(new Rogue        (baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
                charactersArrList.add(   new Rogue   (tempbaseHp, tempbaseDef, tempbaseAttack, tempbaseDmg, slot, tempcharacterName , tempcurrentHp, tempcurrentDef, tempcurrentAttack, tempcurrentDmg, tempcurrentArmorUpgrade, tempcurrentWeaponUpgrade, tempcurrentScore, tempcurrentGold));
            }
            else{
                System.out.println("Error No character in slot: "+slot+" ");
            }
        
        }
        
    }
    
    
    
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.
    // Use this method to reset the current user to change to another.
    public void reset() {
        charactersArrList.clear();
        loadOnce = true;
    }

    
    //@return the adventurePosition
     
    public String getAdventurePosition() {
        return adventurePosition;
    }
    //set the aadventurePosition
    
    public void setAdventurePosition(String adventurePosition) {
        this.adventurePosition = adventurePosition;
    }
    
    
    
    
    
    
    public void test001SaveCharDataToALLLOCALDATA(){
        
        for (int slot = 0; slot < 3; slot++) {
            
            for (Characters charactersArrList1: charactersArrList) {
                int characters_idNr = 0;
                if (charactersArrList1 instanceof Warrior) {
                    characters_idNr = 1;
                }
                if (charactersArrList1 instanceof Mage) {
                    characters_idNr = 2;
                }
                if (charactersArrList1 instanceof Rogue) {
                    characters_idNr = 3;
                }
                
                
                if(charactersArrList1.getCharSlot() == slot+1){
                    //write data to AllLOCALDATA            
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setArmorUpgrade(      charactersArrList1.getCurrentArmorUpgrade()   );
                    //AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCharSlot(          warriorArrList1.getCurrentArmorUpgrade()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCharacterName(     charactersArrList1.getCharacterName()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCharacters_idNr(   characters_idNr   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCurrentAttack(     charactersArrList1.getCurrentAttack()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCurrentDef(        charactersArrList1.getCurrentDef()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCurrentDmg(        charactersArrList1.getCurrentDmg()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setCurrentHp(         charactersArrList1.getCurrentHp()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setGold(              charactersArrList1.getCurrentGold()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setArmorUpgrade(      charactersArrList1.getCurrentArmorUpgrade()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setScore(             charactersArrList1.getCurrentScore()   );
                    AllLocalData.getInstance().getInfo2LoginHasCharacters().get(slot).setWeaponUpgrade(     charactersArrList1.getCurrentWeaponUpgrade()   );
                }
            }
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    private boolean gameClear = false;

    public boolean isGameClear() {
        return gameClear;
    }

    public void setGameClear(boolean gameClear) {
        this.gameClear = gameClear;
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
