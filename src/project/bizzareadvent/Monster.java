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
public abstract class Monster extends Creature {
    private int amountScore;                                                    //How much score they will give
    private int amountGold;                                                     //How much gold they will give
    private boolean isStunned = false;
    
    public Monster(int baseHp, int baseDef, int baseAttack, int baseDmg, int amountScore, int amountGold) {
        super(baseHp, baseDef, baseAttack, baseDmg);
        this.amountScore = amountScore;
        this.amountGold = amountGold;
    }
    public void setAmountScore(int amountScore){
        this.amountScore = amountScore;
    }
    public int getAmountScore(){
        return amountScore;
    }
    public void setAmountGold(int amountGold){
        this.amountGold = amountGold;
    }
    public int getAmountGold(){
        return amountGold;
    }

    public boolean isIsStunned() {
        return isStunned;
    }

    public void setIsStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }
   
}
