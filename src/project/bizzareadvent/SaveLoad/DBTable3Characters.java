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
public class DBTable3Characters {
    private int idNr;
    private String characterType;
    private int baseHp;
    private int baseDmg;
    private int baseDef;
    private int baseAttack;

    public DBTable3Characters(int idNr, String characterType, int baseHp, int baseDmg, int baseDef, int baseAttack) {
        this.idNr = idNr;
        this.characterType = characterType;
        this.baseHp = baseHp;
        this.baseDmg = baseDmg;
        this.baseDef = baseDef;
        this.baseAttack = baseAttack;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getIdNr() {
        return idNr;
    }

    public void setIdNr(int idNr) {
        this.idNr = idNr;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }
    
    
    
    
    
}
