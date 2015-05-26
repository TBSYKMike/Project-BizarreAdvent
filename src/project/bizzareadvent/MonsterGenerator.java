/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.util.Random;
import project.bizzareadvent.SaveLoad.UserData;

/**
 *
 * @author Minkan
 */
public class MonsterGenerator {
    
    
    
    Random randomGenerator = new Random();
 
    private int randomInt;
        
    
    public NormalMonster generateMonster(String position){
        
        NormalMonster generatedMonster;
        
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
        randomInt = randomGenerator.nextInt(100) +1;
        
        if(randomInt <= 18){
            plainsMonster = new NormalMonster(30,5,6,10,20,20,"Spider");
        }
        else if(randomInt > 18 && randomInt <= 36){
            plainsMonster = new NormalMonster(20,5,4,10,5,0,"Slime");
        }
        else if(randomInt > 36 && randomInt <= 54){
            plainsMonster = new NormalMonster(25,6,6,8,10,5,"giant Goblin");
        }
        else if(randomInt > 54 && randomInt <= 72){
            plainsMonster = new NormalMonster(45,10,10,13,40,20,"Orc");
        }
        else if(randomInt > 72 && randomInt <= 90){
            plainsMonster = new NormalMonster(55,5,5,15,10,60,"Troll");
        }
        else{
            plainsMonster = new NormalMonster(300,30,30,30,10000,10000,"Fluffy");
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
            forestMonster = new NormalMonster(35,5,6,6,30,20,"giant Spider");
        }
        else if(randomInt == 2){
            forestMonster = new NormalMonster(25,6,6,8,10,5,"giant Goblin");
        }
        else if(randomInt == 3){
            forestMonster = new NormalMonster(45,10,10,13,40,20,"Orc");
        }
        else if(randomInt == 4){
            forestMonster = new NormalMonster(55,7,8,20,50,60,"Troll");
        }
        else{
            forestMonster = new NormalMonster(70,5,14,10,40,70,"Treeman");
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
            swampMonster = new NormalMonster(20,5,4,10,5,0,"Slime");
        }
        else if(randomInt == 2){
            swampMonster = new NormalMonster(21,5,4,10,5,5,"Ooze");
        }
        else if(randomInt == 3){
            swampMonster = new NormalMonster(55,7,8,20,50,60,"Troll");
        }
        else if(randomInt == 4){
            swampMonster = new NormalMonster(80,5,5,10,20,30,"Troll");
        }
        else{
            swampMonster = new NormalMonster(150,5,5,15,30,100,"Dragon");
        }
        
        return swampMonster;
    }
    
    private NormalMonster mountainMonsters(){
        
        NormalMonster mountainMonster;
        randomInt = randomGenerator.nextInt(6);
        
        if(randomInt == 0){
            mountainMonster = new NormalMonster(25,6,6,8,10,5,"giant Goblin");
        }
        else if(randomInt == 1){
            mountainMonster = new NormalMonster(25,6,6,8,10,5,"giant Goblin");
        }
        else if(randomInt == 2){
            mountainMonster = new NormalMonster(30,6,6,10,8,10,"giant Hobgoblin");
        }
        else if(randomInt == 3){
            mountainMonster = new NormalMonster(45,10,10,13,40,20,"Orc");
        }
        else if(randomInt == 4){
            mountainMonster = new NormalMonster(50,14,7,16,10,50,"Orc berserker");
        }
        else{
            mountainMonster = new NormalMonster(80,6,6,25,50,50,"Cyclops");
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
                castleMonster = new NormalMonster(35,8,8,12,30,20,"giant Goblin knight");
            }
            else if(randomInt == 2){
                castleMonster = new NormalMonster(35,8,8,12,30,20,"giant Goblin knight");
            }
            else if(randomInt == 3){
                castleMonster = new NormalMonster(45,10,10,13,40,20,"Orc");
            }
            else if(randomInt == 4){
                castleMonster = new NormalMonster(70,10,20,20,50,60,"Orc knight");
            }
            else{
                castleMonster = new NormalMonster(250,30,30,30,500,300,"Dragon");
            }
            
            return castleMonster;
    }
}
