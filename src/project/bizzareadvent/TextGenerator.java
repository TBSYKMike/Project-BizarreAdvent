
package project.bizzareadvent;

import java.util.Random;

public class TextGenerator {
    
    Random randomGenerator = new Random();
    private final int randomInt = randomGenerator.nextInt(100) + 1;
    
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
        String plainsText;
            if(randomInt < 50){
                plainsText = ("\n\nYou keep following the path you once started on"
                            + "\nNothing more interesting to be told here, press that continue button.");
            }
            else{
                plainsText = ("\n\nYou pass more purple rocks that has strange formations."
                            + "\nYou giggle as you pass the rocks as the formations amuse you.");
            }
        return plainsText;
    }
    
    private String forestText(){ // NEED TO ADD STORY
        String forestText;
        
        if(randomInt <= 33){
            forestText = ("\n\nYou keep following a path through the forest."
                        + "\nIt is abit quiet, almost to quiet.");
        }
        else if(randomInt > 33 && randomInt <= 66){
            forestText = ("\n\nYou stop a moment, trying to figure out which direction you should take."
                        + "\nIt all looks the same, trees there, trees over there and trees over here."
                        + "\nAfter minutes thinking you just take a direction and hope for the best.");
        }
        else{
            forestText = ("\n\nYou feel lost and scared, but not alone."
                        + "\nYou can spot eyes glowing here and there, lurking at the trees."
                        + "\nDo wonder what kind of creatures that live here in the forest of Adabûn.");
        }
        
        return forestText;
    }
    
    private String swampText(){ // NEED TO ADD STORY
        String swampText;
        
        if(randomInt <= 50){
            swampText = ("\n\nYou keep walking through swamp."
                        + "\n'Ugh this is so disgusting!'"
                        + "\nYou are wet and cold but you need to keep moving.");
        }
        else if(randomInt > 45 && randomInt <= 90){
            swampText = ("\n\nYou struggle to make your way through the swamp,"
                        + "\nstumble over what seems to be roots or fallen trees."
                        + "\nHard to tell as your vision is restricted by the fog");
            
        }
        else{
            swampText = ("\n\nAs you keep making your way through the swamp,"
                        + "\nyou hear this creepy voice over and over again."
                        + "\n'Carry on you must little noob!'"
                        + "\nWho or what might that be?"
                        + "\nYou just ignore it and keep on going.");
        }
        return swampText;
    }
    
    private String mountainText(){
        String mountainText;
        
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
        String castleText;
        
        if(randomInt <= 33){
            castleText = ("\n\nYou keep moving through a long hallway,"
                        + "\nit's lit up with torches and has a funky smell to it."
                        + "\nYou have reached the end of the hallway and proceed through a door.");
        }
        else if(randomInt > 33 && randomInt <= 66){
            castleText = ("\n\nYou have entered what seems to be a torturechamber."
                        + "\nWeird machines, devices and tools that makes your stomach turn."
                        + "\n'This is fucked up!'"
                        + "\nYou have seen enough of this room and you decide to go back through the door you came.");
        }
        else{
            castleText = ("\n\nYou enter a large room, with long tables, alot of chairs, paintings on the walls"
                        + "\nand an open fireplace."
                        + "\nIt is a dining hall!"
                        + "\nYou look around and find some food laying on the tables."
                        + "\nYou take some food and sit down next to the fireplace for abit,"
                        + "\nbefore you continue to explore more of the castle.");
        }
        return castleText;
    }
}
