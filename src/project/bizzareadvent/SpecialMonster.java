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
public class SpecialMonster extends Monster {

    public SpecialMonster(int baseHp, int baseDef, int baseAttack, int baseDmg, int amountScore, int amountGold, String monsterType) {
        super(baseHp, baseDef, baseAttack, baseDmg, amountScore, amountGold, monsterType);
    }

    public int specialAttack(int characterHP){
        int damage;
        
        damage = characterHP / 2;
        
        return damage;
    }
}
    

