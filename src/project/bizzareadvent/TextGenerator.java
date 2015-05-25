
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
    
    private String plainsText(){
        String plainsText;
            if(randomInt <= 25){
                plainsText = ("\n\nYou keep following the path you once started on"
                            + "\nNothing more of interest to be told here, press that continue button.");
            }
            else if(randomInt > 25 && randomInt <= 50){
                plainsText = ("\n\nYou pass more purple rocks that has strange formations."
                            + "\nYou giggle as you pass the rocks as the formations amuse you.");
            }
            else if(randomInt > 50 && randomInt <=75){
                plainsText = ("\n\nYou take a look around."
                            + "\nNothing, there is nothing as far as your eyes can see."
                            + "\nBetter just keep moving.");
            }
            else{
                plainsText = ("\n\nYou walk through a field,"
                            + "\nfield of grains."
                            + "\n'Boy, this was a boring adventure.'"
                            + "\nWell just press that continue button and be on with it.");
            }
        return plainsText;
    }
    
    private String forestText(){
        String forestText;
        
        if(randomInt <= 20){
            forestText = ("\n\nYou keep following a path through the forest."
                        + "\nIt is abit quiet, almost to quiet.");
        }
        else if(randomInt > 20 && randomInt <= 40){
            forestText = ("\n\nYou stop a moment, trying to figure out which direction you should take."
                        + "\nIt all looks the same, trees there, trees over there and trees over here."
                        + "\nAfter minutes thinking you just take a direction and hope for the best.");
        }
        else if(randomInt > 40 && randomInt <= 60){
            forestText = ("\n\nIt is so dark it is hard for you to see anything."
                        + "\nAll of a sudden you get stuck in something,"
                        + "\nand that something is a spiderweb."
                        + "\nYou panic, trying to get loose."
                        + "\nA few seconds of struggle you are free."
                        + "\nBetter get out of here quick before anything unpleasent comes.");
        }
        else if(randomInt > 60 && randomInt <= 80){
            forestText = ("\n\nYou pass by totems and poles with human heads."
                        + "\n'Nope nope nope."
                        + "\nWithout hesitation you speed up your pace.");
        }
        else{
            forestText = ("\n\nYou feel lost and scared, but not alone."
                        + "\nYou can spot eyes glowing here and there, lurking at the trees."
                        + "\nDo wonder what kind of creatures that live here in the forest of Adabûn.");
        }
        
        return forestText;
    }
    
    private String swampText(){
        String swampText;
        
        if(randomInt <= 30){
            swampText = ("\n\nYou keep walking through swamp."
                        + "\n'Ugh this is so disgusting!'"
                        + "\nYou are wet and cold but you need to keep moving.");
        }
        else if(randomInt > 30 && randomInt <= 50){
            swampText = ("\n\nYou struggle to make your way through the swamp,"
                        + "\nstumble over what seems to be roots or fallen trees."
                        + "\nHard to tell as your vision is restricted by the fog");
            
        }
        else if(randomInt > 50 && randomInt <= 70){
            swampText = ("\n\nDead trees and rotten animal corpses,"
                        + "\nconsumed by the swamp."
                        + "\nHopefully you wont face the same faith"
                        + "\nas you travel through it.");
        }
        else if(randomInt > 70 && randomInt < 90){
            swampText = ("\n\nYou hear screams as you walk."
                        + "\nCalling for you."
                        + "\nYou think for yourself"
                        + "\n'I must help!'"
                        + "\n'Or maybe it is a trap?'"
                        + "\nYou decide it is not worth taking the risk and continue your journey.");
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
    
    private String castleText(){
        String castleText;
        
        if(randomInt <= 10){
            castleText = ("\n\nYou keep moving through a long hallway,"
                        + "\nit's lit up with torches and has a funky smell to it."
                        + "\nYou have reached the end of the hallway and proceed through a door.");
        }
        else if(randomInt > 10 && randomInt <= 20){
            castleText = ("\n\nYou have entered what seems to be a torturechamber."
                        + "\nWeird machines, devices and tools that makes your stomach turn."
                        + "\n'This is fucked up!'"
                        + "\nYou have seen enough of this room and you decide to go back through the door you came.");
        }
        else if(randomInt > 20 && randomInt <= 30){
            castleText = ("\n\nYou enter a large room, with long tables, alot of chairs, paintings on the walls"
                        + "\nand an open fireplace."
                        + "\nIt is a dining hall!"
                        + "\nYou look around and find some food laying on the tables."
                        + "\nYou take some food and sit down next to the fireplace for abit,"
                        + "\nbefore you continue to explore more of the castle.");
        }
        else if(randomInt > 30 && randomInt <= 40){
            castleText = ("\n\nYou see stairs leading up,"
                        + "\nyou decide to follow them.");
        }
        else if(randomInt > 40 && randomInt <= 50){
            castleText = ("\n\nYou see stairs leading down,"
                        + "you decide follow them.");
            
        }
        else if(randomInt > 50 && randomInt <= 60){
            castleText = ("\n\nYou enter a dark room."
                        + "\nAs you keep moving slowly further into the room,"
                        + "\nyou hear something."
                        + "\nYou stop, trying to see what it might have be."
                        + "\nAs you can't see anything you decide to walk back out of the door.");
        }
        else if(randomInt > 60 && randomInt <= 70){
            castleText = ("\n\nYou enter through a door,"
                        + "\nBeyond the door there lies a long hallway, that is lit up by torches."
                        + "\nYou walk through the hallway, on both sides there are cells,"
                        + "\nsome are completely empty and some there lies remains of humans."
                        + "\nYou proceed out at the end of the hallway.");
        }
        else if(randomInt > 70 && randomInt <= 80){
            castleText = ("\n\nYou enter what seems to be a library."
                        + "\nA lot of old dusty books that no one has touched in many years."
                        + "\nThere might be something interesting "
                        + "\nor something that can help you in these books."
                        + "\nAfter you have read a few books you decide to keep moving,"
                        + "\nsince most of the books you couldn't make any sense of,"
                        + "\nnor understand.");
        }
        else if(randomInt > 80 && randomInt <= 90){
            castleText = ("\n\nYou enter a room."
                        + "\nYou look around to see if there is something to scavenge."
                        + "\nYou find nothing and decide to keep moving.");
        }
        else{
            castleText = ("\n\nYou find a door,"
                        + "\nbut it is locked."
                        + "\nYou continue to explore the castle.");
        }
        return castleText;
    }
}
