
package project.bizzareadvent;

import java.util.Random;

public class TextGenerator {
    
    Random randomGenerator = new Random();
    private int randomInt;
    
    public String generateText(String position){
        String generateText;
        
        if(position.equals("plains")){
            generateText = plainsText();
        }
        else if(position.equals("forest")){
            generateText = forestText();
        }
        else if(position.equals("mountain")){
            generateText = mountainText();
        }
        else if(position.equals("swamp")){
            generateText = swampText();
        }
        else{
            generateText = castleText();
        }
        return generateText;
    }
    
    private String plainsText(){ // NEED TO ADD STORY
        String plainsText = "lol";
        
        return plainsText;
    }
    
    private String forestText(){ // NEED TO ADD STORY
        String forestText = "lol";
        
        return forestText;
    }
    
    private String swampText(){ // NEED TO ADD STORY
        String swampText = "lol";
        
        return swampText;
    }
    
    private String mountainText(){
        String mountainText;
        randomInt = randomGenerator.nextInt(100) + 1;
        
        if(randomInt < 6){
            mountainText = ("\n\nYou climb and climb, it seems to be no end to this mountain"
                        + "\n'I don't want to climb anymore!'"
                        + "\nYou have to continue."
                        + "\n'I'm not going to climb one millimeter more!'"
                        + "\nYou must if you want to finish your adventure."
                        + "\n'Fuck you narrator you don't decide over me!'"
                        + "\nAs it so happens I do."
                        + "\nThe pathetic adventurer starts to lose the grip of the mountain."
                        + "\n'NO WHAT ARE YOU DOING!'"
                        + "\nAre you going to continue?"
                        + "\n'YES YES I WILL CONTINUE PLEASE DON'T KILL ME'"
                        + "\nVery well then.");
        }
        else if(randomInt > 6 && randomInt <= 20){
            mountainText = ("\n\nYou keep climbing, nothing more interesting to be told here.");
        }
        else if(randomInt > 20 && randomInt <= 40){
            mountainText = ("\n\nYou find what looks to be a cave."
                        + "\nYou enter it and decide to rest here for a bit,"
                        + "\nbefore you continue your journey.");
        }
        else if(randomInt > 40 && randomInt <= 60){
            mountainText = ("\n\nYou stop to catch your breath."
                        + "\nYou take out a snack from you backpack and admire the view,"
                        + "\nbefore you continue your journey.");
        }
        else if(randomInt > 60 && randomInt <= 80){
            mountainText = ("\n\nYou find a opening ahead and proceed to investigate it."
                        + "\nIt seems to be a tunnel that goes deep into the mountain,"
                        + "\nand you hope this leads you to the other side of Humpelberry."
                        + "\nNot far into the tunnel you start to hear something growling,"
                        + "\nyou stop and feel a chill down your spin."
                        + "\nYou decide not to continue further into the tunnel,"
                        + "\ninstead you start to run back out fomr the tunnel, crying like a baby.");
        }
        else{
            mountainText = ("\n\nYou follow a small path on the side of the mountain,"
                        + "\nyou try not to look down in fear to lose your balance."
                        + "\nThe path ends and you stop to gather courage to continue.");
        }
        return mountainText;
    }
    
    private String castleText(){ // NEED TO ADD STORY
        String castleText = "lol";
        
        return castleText;
    }
}
