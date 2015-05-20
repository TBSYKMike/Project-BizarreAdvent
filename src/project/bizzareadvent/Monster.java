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
    private boolean isBurned = false;
    private String monsterType;
    
    public Monster(int baseHp, int baseDef, int baseAttack, int baseDmg, int amountScore, int amountGold, String monsterType) {
        super(baseHp, baseDef, baseAttack, baseDmg);
        this.amountScore = amountScore;
        this.amountGold = amountGold;
        this.monsterType = monsterType;
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
    public boolean getIsStunned(){
        return isStunned;
    }
    public String getMonsterType(){
        return monsterType;
    }
    public void setIsStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }
    public void setIsBurned(boolean isBurned){
        this.isBurned = isBurned;
    }
    public boolean getIsBurned(){
        return isBurned;
    }
    
}
