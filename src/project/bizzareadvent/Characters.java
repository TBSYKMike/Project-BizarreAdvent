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
public class Characters {
    
    private int CharSlot;
    private String Name;
    private int HPcurrent;
    private int HPbase;
    private int Attack;
    private int Defense;
    private int Damage;
    private int Upgrades;

    public Characters(int CharSlot, String Name, int HPcurrent, int HPbase, int Attack, int Defense, int Damage, int Upgrades) {
        this.Name = Name;
        this.CharSlot = CharSlot;
        this.HPcurrent = HPcurrent;
        this.HPbase = HPbase;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Damage = Damage;
        this.Upgrades = Upgrades;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCharSlot() {
        return CharSlot;
    }

    public void CharSlot(int CharSlot) {
        this.CharSlot = CharSlot;
    }
    
    public int getHPcurrent() {
        return HPcurrent;
    }

    public void setHPcurrent(int HPcurrent) {
        this.HPcurrent = HPcurrent;
    }

    public int getHPbase() {
        return HPbase;
    }

    public void setHPbase(int HPbase) {
        this.HPbase = HPbase;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public int getUpgrades() {
        return Upgrades;
    }

    public void setUpgrades(int Upgrades) {
        this.Upgrades = Upgrades;
    }
    
    
    
    
    
    
}
