
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
    
    private String plainsText(){
        String plainsText;
        randomInt = randomGenerator.nextInt(100) + 1;
        
        if(randomInt < 6){
            plainsText = ("\n\n");
        }
    }
}
