/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

/**
 *
 * @author Jocke
 */
public class Warrior extends Characters {
    private int buffedDef;
    private int reducedDmg;
    
    public Warrior(int baseHp, int baseDef, int baseAttack, int baseDmg, int charSlot, String characterName, int currentHp, int currentDef, int currentAttack, int currentDmg, int currentArmorUpgrade, int currentWeaponUpgrade, int currentScore, int currentGold) {
        super(baseHp, baseDef, baseAttack, baseDmg, charSlot, characterName, currentHp, currentDef, currentAttack, currentDmg, currentArmorUpgrade, currentWeaponUpgrade, currentScore, currentGold);
    }
    public void castShieldBash(){
        buffedDef = super.getBaseDef() + super.getBaseDef()/2;
        reducedDmg = super.getBaseDmg()/2;
        
        super.setCurrentDef(buffedDef);
        super.setCurrentDmg(reducedDmg);
        
    }
}
