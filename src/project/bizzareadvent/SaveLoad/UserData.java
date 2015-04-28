/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
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
    private ArrayList<Warrior> warriorArrList = new ArrayList<>();
    private ArrayList<Mage> mageArrList = new ArrayList<>();
    private ArrayList<Rogue> rogueArrList = new ArrayList<>();

    

    public void makeChar(){
        warriorArrList.add( new Warrior (100, 100, 100, 100, 1, "char1name", 100, 100, 100, 100, 100, 100, 100, 100));
        mageArrList.add(    new Mage    (102, 102, 102, 102, 3, "char2name", 102, 102, 102, 102, 102, 102, 102, 102));
        //rogueArrList.add(   new Rogue   (104, 104, 104, 104, 2, "char3name", 104, 104, 104, 104, 104, 104, 104, 104));
        warriorArrList.add( new Warrior (130, 130, 130, 130, 2, "char1name", 300, 300, 300, 300, 300, 300, 300, 300));
        
    
    
    }
    
    
    
    
    // Set slot must be done to Load correct Character, Slot input should be 1, 2 or 3.
    // Use this method to reset the current user to change to another.
    public void reset() {
        mageArrList.clear();
        warriorArrList.clear();
        rogueArrList.clear();
        loadOnce = true;
        Username = "";
    }

    // Getter and Setter Method to set or get Character Stats
    public void testLoadAllDataFromALLLOCALDATAToUSERDATA() {
        reset();
        for (int CharacterSlot = 1; CharacterSlot <= 3; CharacterSlot++) {

            if (!(AllLocalData.getInstance().getInfo1Login().isEmpty())) {
                Username = AllLocalData.getInstance().getInfo1Login().get(0).getUserName();
            }
            for (DBTable2LoginHasCharacters info2LoginHasCharacter1 : AllLocalData.getInstance().getInfo2LoginHasCharacters()) {

                if (info2LoginHasCharacter1.getCharSlot() == CharacterSlot) {

                    charSlot = info2LoginHasCharacter1.getCharSlot();
                    charID = info2LoginHasCharacter1.getCharacters_idNr();
                    currentScore = info2LoginHasCharacter1.getScore();
                    characterName = info2LoginHasCharacter1.getCharacterName();
                    currentArmorUpgrade = info2LoginHasCharacter1.getArmorUpgrade();
                    currentWeaponUpgrade = info2LoginHasCharacter1.getWeaponUpgrade();
                    currentHp = info2LoginHasCharacter1.getCurrentHp();
                    currentGold = info2LoginHasCharacter1.getGold();
                    currentDmg = info2LoginHasCharacter1.getCurrentDmg();
                    currentDef = info2LoginHasCharacter1.getCurrentDef();
                    currentAttack = info2LoginHasCharacter1.getCurrentAttack();

                }

            }

            for (DBTable3Characters info3Characters1 : AllLocalData.getInstance().getInfo3Characters()) {
                if (info3Characters1.getIdNr() == charID) {
                    characterType = info3Characters1.getCharacterType();
                    baseHp = info3Characters1.getBaseHp();
                    baseDmg = info3Characters1.getBaseDmg();
                    baseDef = info3Characters1.getBaseDef();
                    baseAttack = info3Characters1.getBaseAttack();

                }

            }
            doCreateChar(charID);
        }
    }

    private void doCreateChar(int charID) {
        //warriorArrList.clear();
        //mageArrList.clear();
        //rogueArrList.clear();

        if (1 == charID) {
            warriorArrList.add(new Warrior(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
        } else if (2 == charID) {
            mageArrList.add(new Mage(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
        } else if (3 == charID) {
            rogueArrList.add(new Rogue(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold));
        }

    }

    public void testSaveFromUSERDATAToALLLOCALDATA() {
        int saveCharSlot = charSlot;
        testloadCharFromArrayLists(1);
        if (charSlot == 1) {
            int i = 0;
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharSlot(charSlot);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(charID);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setScore(currentScore);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(characterName);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setArmorUpgrade(currentArmorUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setWeaponUpgrade(currentWeaponUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(currentHp);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setGold(currentGold);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(currentDmg);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(currentDef);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(currentAttack);
        }
        testloadCharFromArrayLists(2);
        if (charSlot == 2) {
            int i = 1;
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharSlot(charSlot);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(charID);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setScore(currentScore);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(characterName);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setArmorUpgrade(currentArmorUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setWeaponUpgrade(currentWeaponUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(currentHp);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setGold(currentGold);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(currentDmg);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(currentDef);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(currentAttack);
        }
        testloadCharFromArrayLists(3);
        if (charSlot == 3) {
            int i = 2;
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharSlot(charSlot);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacters_idNr(charID);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setScore(currentScore);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCharacterName(characterName);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setArmorUpgrade(currentArmorUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setWeaponUpgrade(currentWeaponUpgrade);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentHp(currentHp);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setGold(currentGold);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDmg(currentDmg);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentDef(currentDef);
            AllLocalData.getInstance().getInfo2LoginHasCharacters().get(i).setCurrentAttack(currentAttack);
        }
        charSlot = saveCharSlot;
    }

    public void testloadCharFromArrayLists(int loadCharSlot) {
        for (Warrior warriorArrList1 : warriorArrList) {
            if (warriorArrList1.getCharSlot() == loadCharSlot) {
                charSlot = warriorArrList1.getCharSlot();
                charID = 1;
                currentScore = warriorArrList1.getCurrentScore();
                characterName = warriorArrList1.getCharacterName();
                currentArmorUpgrade = warriorArrList1.getCurrentArmorUpgrade();
                currentWeaponUpgrade = warriorArrList1.getCurrentWeaponUpgrade();
                currentHp = warriorArrList1.getCurrentHp();
                currentGold = warriorArrList1.getCurrentGold();
                currentDmg = warriorArrList1.getCurrentDmg();
                currentDef = warriorArrList1.getCurrentDef();
                currentAttack = warriorArrList1.getCurrentAttack();

                characterType = AllLocalData.getInstance().getInfo3Characters().get(charID - 1).getCharacterType();
                baseHp = warriorArrList1.getBaseHp();
                baseDmg = warriorArrList1.getBaseDmg();
                baseDef = warriorArrList1.getBaseDef();
                baseAttack = warriorArrList1.getBaseAttack();
            }
        }
        for (Mage mageArrList1 : mageArrList) {
            if (mageArrList1.getCharSlot() == loadCharSlot) {
                charSlot = mageArrList1.getCharSlot();
                charID = 2;
                currentScore = mageArrList1.getCurrentScore();
                characterName = mageArrList1.getCharacterName();
                currentArmorUpgrade = mageArrList1.getCurrentArmorUpgrade();
                currentWeaponUpgrade = mageArrList1.getCurrentWeaponUpgrade();
                currentHp = mageArrList1.getCurrentHp();
                currentGold = mageArrList1.getCurrentGold();
                currentDmg = mageArrList1.getCurrentDmg();
                currentDef = mageArrList1.getCurrentDef();
                currentAttack = mageArrList1.getCurrentAttack();

                characterType = AllLocalData.getInstance().getInfo3Characters().get(charID - 1).getCharacterType();
                baseHp = mageArrList1.getBaseHp();
                baseDmg = mageArrList1.getBaseDmg();
                baseDef = mageArrList1.getBaseDef();
                baseAttack = mageArrList1.getBaseAttack();
            }
        }
        for (Rogue rogueArrList1 : rogueArrList) {
            if (rogueArrList1.getCharSlot() == loadCharSlot) {
                charSlot = rogueArrList1.getCharSlot();
                charID = 3;
                currentScore = rogueArrList1.getCurrentScore();
                characterName = rogueArrList1.getCharacterName();
                currentArmorUpgrade = rogueArrList1.getCurrentArmorUpgrade();
                currentWeaponUpgrade = rogueArrList1.getCurrentWeaponUpgrade();
                currentHp = rogueArrList1.getCurrentHp();
                currentGold = rogueArrList1.getCurrentGold();
                currentDmg = rogueArrList1.getCurrentDmg();
                currentDef = rogueArrList1.getCurrentDef();
                currentAttack = rogueArrList1.getCurrentAttack();

                characterType = AllLocalData.getInstance().getInfo3Characters().get(charID - 1).getCharacterType();
                baseHp = rogueArrList1.getBaseHp();
                baseDmg = rogueArrList1.getBaseDmg();
                baseDef = rogueArrList1.getBaseDef();
                baseAttack = rogueArrList1.getBaseAttack();
            }
        }

    }
    
    public void testsaveCharToArrayLists() {
        for (Warrior warriorArrList1 : warriorArrList) {
            if (warriorArrList1.getCharSlot() == charSlot) {
                //warriorArrList1.setCharSlot(charSlot);
                warriorArrList1.setCurrentScore(currentScore);
                warriorArrList1.setCharacterName(characterName);
                warriorArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                warriorArrList1.setCurrentWeaponUpgrade(currentWeaponUpgrade);
                warriorArrList1.setCurrentHp(currentHp);
                warriorArrList1.setCurrentGold(currentGold);
                warriorArrList1.setCurrentDmg(currentDmg);
                warriorArrList1.setCurrentDef(currentDef);
                warriorArrList1.setCurrentAttack(currentAttack);

                
            }
        }
        for (Mage mageArrList1 : mageArrList) {
            if (mageArrList1.getCharSlot() == charSlot) {
                //mageArrList1.setCharSlot(charSlot);
                mageArrList1.setCurrentScore(currentScore);
                mageArrList1.setCharacterName(characterName);
                mageArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                mageArrList1.setCurrentWeaponUpgrade(currentWeaponUpgrade);
                mageArrList1.setCurrentHp(currentHp);
                mageArrList1.setCurrentGold(currentGold);
                mageArrList1.setCurrentDmg(currentDmg);
                mageArrList1.setCurrentDef(currentDef);
                mageArrList1.setCurrentAttack(currentAttack);
            }
        }
        for (Rogue rogueArrList1 : rogueArrList) {
            if (rogueArrList1.getCharSlot() == charSlot) {
                //rogueArrList1.setCharSlot(charSlot);
                rogueArrList1.setCurrentScore(currentScore);
                rogueArrList1.setCharacterName(characterName);
                rogueArrList1.setCurrentArmorUpgrade(currentArmorUpgrade);
                rogueArrList1.setCurrentWeaponUpgrade(currentWeaponUpgrade);
                rogueArrList1.setCurrentHp(currentHp);
                rogueArrList1.setCurrentGold(currentGold);
                rogueArrList1.setCurrentDmg(currentDmg);
                rogueArrList1.setCurrentDef(currentDef);
                rogueArrList1.setCurrentAttack(currentAttack);
            }
        }
    }
    
    
    

    public String getUsername() {
        return Username;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(int selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

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

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
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

    public int getCurrentWeaponUpgrade() {
        return currentWeaponUpgrade;
    }

    public void setCurrentWeaponUpgrade(int currentWeaponUpgrade) {
        this.currentWeaponUpgrade = currentWeaponUpgrade;
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

    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }
    
    
    
    
    
    
    
    
    
    
    
    private String rememeberLastClass;

    public String getRememeberLastClass() {
        return rememeberLastClass;
    }

    public void setRememeberLastClass(String rememeberLastClass) {
        this.rememeberLastClass = rememeberLastClass;
    }
    
    
    
    
    
    
    
    
}
