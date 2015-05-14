/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.util.Random;

/**
 *
 * @author Minkan
 */
public class MonsterGenerator {
    
    
    
    Random randomGenerator = new Random();
 
    private int randomInt;
        
    
    public NormalMonster generateMonster(String position){
        
        NormalMonster generatedMonster = new NormalMonster(0,0,0,0,0,0,"");
        
        if(position.equals("plains")){
            generatedMonster = plainsMonsters();
        }
        else if(position.equals("forest")){
            generatedMonster = forestMonsters();
        }
        else if(position.equals("mountain")){
            generatedMonster = mountainMonsters();
        }
        else if(position.equals("swamp")){
            generatedMonster = swampMonsters();
        }else{
            generatedMonster = castleMonsters();
        }
        
        return generatedMonster;
    }
    
    private NormalMonster plainsMonsters(){
        
        NormalMonster plainsMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            plainsMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 1){
            plainsMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 2){
            plainsMonster = new NormalMonster(30,5,6,5,30,20,"Goblin");
        }
        else if(randomInt == 3){
            plainsMonster = new NormalMonster(40,5,8,6,40,20,"Orc");
        }
        else if(randomInt == 4){
            plainsMonster = new NormalMonster(50,5,8,8,50,30,"Savannah Lion");
        }
        else{
            plainsMonster = new NormalMonster(50,6,9,10,50,50,"Gigantic Spider");
        }
        
        return plainsMonster;
    }
    
    private NormalMonster forestMonsters(){
        
        NormalMonster forestMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            forestMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 1){
            forestMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 2){
            forestMonster = new NormalMonster(30,5,6,5,30,20,"Goblin");
        }
        else if(randomInt == 3){
            forestMonster = new NormalMonster(40,5,8,6,40,20,"Orc");
        }
        else if(randomInt == 4){
            forestMonster = new NormalMonster(50,5,8,8,50,30,"Savannah Lion");
        }
        else{
            forestMonster = new NormalMonster(50,6,9,10,50,50,"Gigantic Spider");
        }
        
        return forestMonster;
    }
    
    private NormalMonster swampMonsters(){
        
        NormalMonster swampMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            swampMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 1){
            swampMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 2){
            swampMonster = new NormalMonster(30,5,6,5,30,20,"Goblin");
        }
        else if(randomInt == 3){
            swampMonster = new NormalMonster(40,5,8,6,40,20,"Orc");
        }
        else if(randomInt == 4){
            swampMonster = new NormalMonster(50,5,8,8,50,30,"Savannah Lion");
        }
        else{
            swampMonster = new NormalMonster(50,6,9,10,50,50,"Gigantic Spider");
        }
        
        return swampMonster;
    }
    
    private NormalMonster mountainMonsters(){
        
        NormalMonster mountainMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            mountainMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 1){
            mountainMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 2){
            mountainMonster = new NormalMonster(30,5,6,5,30,20,"Goblin");
        }
        else if(randomInt == 3){
            mountainMonster = new NormalMonster(40,5,8,6,40,20,"Orc");
        }
        else if(randomInt == 4){
            mountainMonster = new NormalMonster(50,5,8,8,50,30,"Savannah Lion");
        }
        else{
            mountainMonster = new NormalMonster(50,6,9,10,50,50,"Gigantic Spider");
        }
        
        return mountainMonster;
    }
    
    private NormalMonster castleMonsters(){
        
        NormalMonster castleMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            castleMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 1){
            castleMonster = new NormalMonster(30,4,6,5,30,20,"Spider");
        }
        else if(randomInt == 2){
            castleMonster = new NormalMonster(30,5,6,5,30,20,"Goblin");
        }
        else if(randomInt == 3){
            castleMonster = new NormalMonster(40,5,8,6,40,20,"Orc");
        }
        else if(randomInt == 4){
            castleMonster = new NormalMonster(50,5,8,8,50,30,"Savannah Lion");
        }
        else{
            castleMonster = new NormalMonster(50,6,9,10,50,50,"Gigantic Spider");
        }
        
        return castleMonster;
    }
}
