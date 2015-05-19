/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.util.Random;

/**
 *
 * @author Jocke
 */
public class Rogue extends Characters {
    
    private int buffedDef;
    private int randInt;
    Random randGenerator = new Random();
    
    public Rogue(int baseHp, int baseDef, int baseAttack, int baseDmg, int charSlot, String characterName, int currentHp, int currentDef, int currentAttack, int currentDmg, int currentArmorUpgrade, int currentWeaponUpgrade, int currentScore, int currentGold) {
        super(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold);
    }
    
    public boolean castAssassinate(){
        
        buffedDef = super.getCurrentDef() * 2;
        super.setCurrentDef(buffedDef);
 
        randInt = randGenerator.nextInt(100) + 1;
        
        if(randInt <= 10){
            return true;
        }else{
            return false;
        }
    }
}
