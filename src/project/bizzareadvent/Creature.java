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
    private int hp;
    private int def;
    private int attack;
    private int dmg;
    
    public Creature(int hp, int def, int attack, int dmg){
        this.hp = hp;
        this.def = def;
        this.attack = attack;
        this.dmg = dmg;
        
    }
    public int getHp(){
        return hp;
    }
    public int getDef(){
        return def;
    }
    public int getAttack(){
        return attack;
    }
    public int getDmg(){
        return dmg;
    }
    
}
