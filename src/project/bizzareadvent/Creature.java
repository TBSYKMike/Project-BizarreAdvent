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
public abstract class Creature {
    private int baseHp;
    private int baseDef;
    private int baseAttack;
    private int baseDmg;
    
    public Creature(int baseHp, int baseDef, int baseAttack, int baseDmg){
        this.baseHp = baseHp;
        this.baseDef = baseDef;
        this.baseAttack = baseAttack;
        this.baseDmg = baseDmg;
        
    }
    public int getBaseHp(){
        return baseHp;
    }
    public int getBaseDef(){
        return baseDef;
    }
    public int getBaseAttack(){
        return baseAttack;
    }
    public int getBaseDmg(){
        return baseDmg;
    }
    
}
