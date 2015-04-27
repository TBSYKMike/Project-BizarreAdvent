/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

/**
 *
 * @author Mike
 */
public abstract class Characters extends Creature {
    
    private int charSlot;
    private String characterName;
    private int currentHp;
    private int currentDef;
    private int currentAttack;
    private int currentDmg;
    private int currentArmorUpgrade;
    private int currentWeaponUpgrade;
    private int currentScore;
    private int currentGold;
   

    public Characters(int baseHp, int baseDef, int baseAttack, int baseDmg, int charSlot, String characterName, int currentHp, int currentDef, int currentAttack, int currentDmg, int currentArmorUpgrade, int currentWeaponUpgrade, int currentScore, int currentGold) {
        super(baseHp, baseDef, baseAttack, baseDmg);
        this.charSlot = charSlot;
        this.characterName = characterName;
        this.currentHp = currentHp;
        this.currentDef = currentDef;
        this.currentAttack = currentAttack;
        this.currentDmg = currentDmg;
        this.currentArmorUpgrade = currentArmorUpgrade;
        this.currentWeaponUpgrade = currentWeaponUpgrade;
        this.currentScore = currentScore;
        this.currentGold = currentGold;
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
    
}
