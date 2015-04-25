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
public class DBTable2LoginHasCharacters {
    
    private int Login_idNr;
    private int charSlot;
    private int Characters_idNr;
    private int score;
    private String characterName;
    private int armorUpgrade;
    private int weaponUpgrade;
    private int currentHp;
    private int gold;
    private int currentDmg;
    private int currentDef;
    private int currentAttack;

    public DBTable2LoginHasCharacters(int Login_idNr, int charSlot, int Characters_idNr, int score, String characterName, int armorUpgrade, int weaponUpgrade, int currentHp, int gold, int currentDmg, int currentDef, int currentAttack) {
        this.Login_idNr = Login_idNr;
        this.charSlot = charSlot;
        this.Characters_idNr = Characters_idNr;
        this.score = score;
        this.characterName = characterName;
        this.armorUpgrade = armorUpgrade;
        this.weaponUpgrade = weaponUpgrade;
        this.currentHp = currentHp;
        this.gold = gold;
        this.currentDmg = currentDmg;
        this.currentDef = currentDef;
        this.currentAttack = currentAttack;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public int getLogin_idNr() {
        return Login_idNr;
    }

    public void setLogin_idNr(int Login_idNr) {
        this.Login_idNr = Login_idNr;
    }

    public int getCharSlot() {
        return charSlot;
    }

    public void setCharSlot(int charSlot) {
        this.charSlot = charSlot;
    }

    public int getCharacters_idNr() {
        return Characters_idNr;
    }

    public void setCharacters_idNr(int Characters_idNr) {
        this.Characters_idNr = Characters_idNr;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getArmorUpgrade() {
        return armorUpgrade;
    }

    public void setArmorUpgrade(int armorUpgrade) {
        this.armorUpgrade = armorUpgrade;
    }

    public int getWeaponUpgrade() {
        return weaponUpgrade;
    }

    public void setWeaponUpgrade(int weaponUpgrade) {
        this.weaponUpgrade = weaponUpgrade;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getCurrentDmg() {
        return currentDmg;
    }

    public void setCurrentDmg(int currentDmg) {
        this.currentDmg = currentDmg;
    }

    public int getCurrentDef() {
        return currentDef;
    }

    public void setCurrentDef(int currentDef) {
        this.currentDef = currentDef;
    }
    
    
    
    
    
}
