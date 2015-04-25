/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.util.ArrayList;
import project.bizzareadvent.Characters1TEMP;
import project.bizzareadvent.Mage;
import project.bizzareadvent.Rogue;
import project.bizzareadvent.Warrior;

/**
 *
 * @author Mike
 */
public class testData {

    

    public testData(String Username, int charID, int baseHp, int baseDef, int baseAttack, int baseDmg, int charSlot, String characterName, int currentHp, int currentDef, int currentAttack, int currentDmg, int currentArmorUpgrade, int currentWeaponUpgradeHp, int currentScore, int currentGold) {
        this.Username = Username;
        this.charID = charID;
        this.baseHp = baseHp;
        this.baseDef = baseDef;
        this.baseAttack = baseAttack;
        this.baseDmg = baseDmg;
        this.charSlot = charSlot;
        this.characterName = characterName;
        this.currentHp = currentHp;
        this.currentDef = currentDef;
        this.currentAttack = currentAttack;
        this.currentDmg = currentDmg;
        this.currentArmorUpgrade = currentArmorUpgrade;
        this.currentWeaponUpgradeHp = currentWeaponUpgradeHp;
        this.currentScore = currentScore;
        this.currentGold = currentGold;
    }
    

    
    
    
    private String Username;
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
    
    
    
    
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
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

    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }
    

    
    
    
    
    
    
    

}
