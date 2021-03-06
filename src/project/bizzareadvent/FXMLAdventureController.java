/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.bizzareadvent.SaveLoad.MusicSettings;
import project.bizzareadvent.SaveLoad.UserData;

/**
 * FXML Controller class
 *
 * @author Minkan
 */
public class FXMLAdventureController implements Initializable {

    @FXML
    private TextArea adventureLog;
    @FXML
    private Label hpLabel;
    @FXML
    private Label attackLabel;
    @FXML
    private Label defenceLabel;
    @FXML
    private Label goldLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label dmgLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Button attackButton;
    @FXML
    private Button secondaryButton;
    @FXML
    private Button continueButton;
    @FXML
    private Button runButton;
    @FXML
    private ImageView backgroundImg;
    @FXML
    private ImageView characterImg;
    @FXML
    private ImageView monsterImg;

    File file = new File("src/spider.png");
    Image spiderImage = new Image(file.toURI().toString());

    File file1 = new File("src/slime.png");
    Image slimeImage = new Image(file1.toURI().toString());

    File file2 = new File("src/ooze.png");
    Image oozeImage = new Image(file2.toURI().toString());

    File file3 = new File("src/goblin.png");
    Image goblinImage = new Image(file3.toURI().toString());

    File file4 = new File("src/orc.png");
    Image orcImage = new Image(file4.toURI().toString());

    File file5 = new File("src/troll.png");
    Image trollImage = new Image(file5.toURI().toString());

    File file8 = new File("src/dragon.png");
    Image dragonImage = new Image(file8.toURI().toString());

    File file9 = new File("src/cyclop.png");
    Image cyclopImage = new Image(file9.toURI().toString());

    File file10 = new File("src/treeman.png");
    Image treemanImage = new Image(file10.toURI().toString());

    File file11 = new File("src/fluffy.png");
    Image fluffyImage = new Image(file11.toURI().toString());

    File file12 = new File("src/mage.png");
    Image mageImage = new Image(file12.toURI().toString());

    File file13 = new File("src/warrior.png");
    Image warriorImage = new Image(file13.toURI().toString());

    File file14 = new File("src/rogue.png");
    Image rogueImage = new Image(file14.toURI().toString());

    File file15 = new File("src/plains.png");
    Image plainsImage = new Image(file15.toURI().toString());

    File file16 = new File("src/forest.png");
    Image forestImage = new Image(file16.toURI().toString());

    File file17 = new File("src/mountain.png");
    Image mountainImage = new Image(file17.toURI().toString());

    File file18 = new File("src/swamp.png");
    Image swampImage = new Image(file18.toURI().toString());

    File file19 = new File("src/castle.png");
    Image castleImage = new Image(file19.toURI().toString());
    
    File file20 = new File("src/george.png");
    Image bossImage = new Image(file20.toURI().toString());

    private int stepCounter = 0;
    private int randomInt;
    private int cooldown = 0;
    private int stunCooldown = 0;
    private int charge = 4;

    private String position;
    private boolean run = false;
    private boolean deadCharacter = false;

    private int previousDmg;

    TextGenerator textGenerator = new TextGenerator();
    Random randomGenerator = new Random();

    ArrayList<Characters> list = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();

    @FXML
    private void handleButtonAttack(ActionEvent event) {

        randomInt = randomGenerator.nextInt(6) + 1;

        if (list.get(0).getCurrentAttack() > monsterList.get(0).getBaseDef()) {

            if (randomInt > 2) {
                monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            } else {
                adventureLog.appendText("\n\nYou miss!");
            }
        } else if (list.get(0).getCurrentAttack() == monsterList.get(0).getBaseDef()) {

            if (randomInt > 3) {
                monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            } else {
                adventureLog.appendText("\n\nYou miss!");
            }
        } else {

            if (randomInt > 4) {
                monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - list.get(0).getCurrentDmg());
                adventureLog.appendText("\n\nYou strike the monster for " + list.get(0).getCurrentDmg() + " Damage!");
            } else {
                adventureLog.appendText("\n\nYou miss!");
            }
        }

        if (monsterList.get(0).getIsBurned()) {
            int burnDamage = 3;
            monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - burnDamage);
            adventureLog.appendText("\n\nThe " + monsterList.get(0).getMonsterType() + " is burning and takes " + burnDamage + " damage!");
        }

        if(monsterList.get(0) instanceof NormalMonster){
            if (cooldown >= 5) {
                cooldown = 0;
                monsterList.get(0).setIsBurned(false);

                if (monsterList.get(0).getBaseHp() > 0) {
                    secondaryButton.setDisable(false);
                }
            } else {
                cooldown += 1;
            }

            if (stunCooldown >= 1) {
                stunCooldown = 0;
                monsterList.get(0).setIsStunned(false);
            } else {
                stunCooldown += 1;
            }
        }
        if (monsterList.get(0).getBaseHp() <= 0) {
            
            if(monsterList.get(0) instanceof SpecialMonster){
                adventureLog.appendText("\n\nYou are victorious! You have slain the Boss!");
                adventureLog.appendText("\nWhen you press continue this character will be deleted");
                adventureLog.appendText("\nand its score will be added to the High-score table.");
                UserData.getInstance().setGameClear(true);
            } else {
                adventureLog.appendText("\n\nYou are victorious! You have slain the " + monsterList.get(0).getMonsterType() + ".");
            }
                  
            monsterImg.setImage(null);

            adventureLog.appendText("\nYou add " + monsterList.get(0).getAmountGold() + " gold to your purse and");
            adventureLog.appendText("\ngain " + monsterList.get(0).getAmountScore() + " score.");

            list.get(0).setCurrentGold(list.get(0).getCurrentGold() + monsterList.get(0).getAmountGold());
            list.get(0).setCurrentScore(list.get(0).getCurrentScore() + monsterList.get(0).getAmountScore());

            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
            monsterList.remove(0);
            
        } else {
            if (monsterList.get(0) instanceof SpecialMonster){
                randomInt = randomGenerator.nextInt(100) + 1;
                
                if(randomInt < 50 || charge < 4){
                    specialMonsterAttack();
                }else{
                    monsterAttack();
                }
            }else{
                monsterAttack();
            }
        }

        showStats();
    }

    @FXML
    private void handleButtonSecondary(ActionEvent event) {

        cooldown += 1;

        if (cooldown != 0) {
            secondaryButton.setDisable(true);
        }

        if (list.get(0) instanceof Warrior) {
            secondaryAttackWarrior();
        } else if (list.get(0) instanceof Mage) {
            secondaryAttackMage();
        } else if (list.get(0) instanceof Rogue) {
            secondaryAttackAssassin();
        }

        showStats();
    }

    @FXML
    private void handleButtonRun(ActionEvent event) {

        randomInt = randomGenerator.nextInt(100);

        if (randomInt < 51) {
            run = true;
            adventureLog.appendText("\n\nYour attempt to run away was successful!");
            adventureLog.appendText("\nYou run away like the coward you are.\n");
            adventureLog.appendText("\n\nPress continue to enter the world map.");

            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
        } else {
            adventureLog.appendText("\n\nYour attempt to run away failed!");
            monsterAttack();
            run = false;
        }

        showStats();
    }

    @FXML
    private void handleButtonContinue(ActionEvent event) {

        cooldown = 0;

        if (run == true || stepCounter > 10) {
            try {
                Node node = (Node) event.getSource();
                Stage stageLogin = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWorldMap.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stageLogin.setScene(scene);
                stageLogin.show();

            } catch (IOException ex) {
                System.out.println("Scene change error1");
                ex.printStackTrace();
            }
        } else if (deadCharacter == true || UserData.getInstance().isGameClear() == true) {
            gameOver(event);
        } else {
            if (position.equals("plains")) {
                plains();
            } else if (position.equals("forest")) {
                forest();
            } else if (position.equals("mountain")) {
                mountains();
            } else if (position.equals("swamp")) {
                swamp();
            } else {
                castle();
            }
        }

        showStats();
    }

    public void plains() {

        randomInt = randomGenerator.nextInt(100) + 1;

        if (stepCounter == 0) {
            adventureLog.appendText("\n\nYou arrive at the plain of eehh... how does one even pronounce that?!");
            adventureLog.appendText("\n'Nevermind.. get on with it!'");
            adventureLog.appendText("\nTo the east you spot a crag of purple rocks in a strange formation,");
            adventureLog.appendText("\nto the west a field of grains stretches far and wide.");
            adventureLog.appendText("\nIn front of you a path leads the way, time to go exploring!\n\n");
        } else if (stepCounter >= 10) {
            adventureLog.appendText("\n\nYou have reached the end of this path, there seem to be nothing more to explore.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        } else {
            if (randomInt <= 20) {
                generateTreasure();
            } else if (randomInt > 20 && randomInt < 40) {
                adventureLog.appendText(textGenerator.generateText(position));
            } else if (randomInt >= 40) {
                monsterList.add(new MonsterGenerator().generateMonster(position));
                monsterImages();

                adventureLog.appendText("\n\nYou encounter a " + monsterList.get(0).getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");

                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();

        stepCounter++;
    }

    public void mountains() {

        randomInt = randomGenerator.nextInt(100) + 1;

        if (stepCounter == 0) {
            adventureLog.appendText("\n\nYou have reached the foot of the mountain called Humpelberry.");
            adventureLog.appendText("\nThe mountain goes up beyond the clouds and you think to yourself.");
            adventureLog.appendText("\n'Fuck this I ain't going to climb that shit!'");
            adventureLog.appendText("\nYou look to your left and right and see no other way to continue your journey,");
            adventureLog.appendText("\nexcept to climb over Humpelberry.");
        } else if (stepCounter >= 10) {
            adventureLog.appendText("\n\nYou have reached the top of the mountain.");
            adventureLog.appendText("\n'YES, I AM THE BEST!'");
            adventureLog.appendText("\nYou soon realize that you are only halfway done,");
            adventureLog.appendText("\nyou must now climb down from Humpelberry.");
            adventureLog.appendText("\n'FUCK!'");
            adventureLog.appendText("\nYou look around and spot a dwarf standing next to you.");
            adventureLog.appendText("\n'Ello there human, would ye like to take the elevator down from Humpelberry?'");
            adventureLog.appendText("\n'What the fuck?!?!'");
            adventureLog.appendText("\n'Did ye climb all the way up?'");
            adventureLog.appendText("\n'Yes, I did.'");
            adventureLog.appendText("\n'Well ye could 'ave taken the elevator up, would 'ave been much easier hehehe'.");
            adventureLog.appendText("\nYou fall down onto your knees and start to cry.");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        } else {
            if (randomInt <= 30) {
                generateTreasure();
            } else if (randomInt > 30 && randomInt < 60) {
                adventureLog.appendText(textGenerator.generateText(position));
            } else if (randomInt >= 60) {
                monsterList.add(new MonsterGenerator().generateMonster(position));
                monsterImages();

                adventureLog.appendText("\n\nYou encounter a " + monsterList.get(0).getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");

                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();

        stepCounter++;
    }

    public void forest() {

        randomInt = randomGenerator.nextInt(100) + 1;

        if (stepCounter == 0) {
            adventureLog.appendText("\n\nYou enter the dark, dark forest of Adabûn.");
            adventureLog.appendText("\nStrangely shaped trees grow tall as mountains and wide as rivers.");
            adventureLog.appendText("\nYou see nothing but the trees and a small path leading into the center of the forest.");
            adventureLog.appendText("\nThe feeling from you get from this place is very unpleasant.");
            adventureLog.appendText("\nAnywho, you follow the dark path into the forest to continue your journey.\n\n");
        } else if (stepCounter >= 10) {
            adventureLog.appendText("\n\nYou have made it through the forest alive, there seems to be nothing more to explore.");
            adventureLog.appendText("\n'Oh well.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        } else {
            if (randomInt <= 20) {
                generateTreasure();
            } else if (randomInt > 20 && randomInt < 60) {
                adventureLog.appendText(textGenerator.generateText(position));
            } else if (randomInt >= 60) {
                monsterList.add(new MonsterGenerator().generateMonster(position));
                //monsterList.add(new NormalMonster(2000000, 1, 1, 0, 1, 1, "testmonster")); //Testmonster
                monsterImages();

                adventureLog.appendText("\n\nYou encounter a " + monsterList.get(0).getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");

                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();

        stepCounter++;
    }

    public void swamp() {

        randomInt = randomGenerator.nextInt(100) + 1;

        if (stepCounter == 0) {
            adventureLog.appendText("\n\nYou have reached the swamp called the Deep Sorrows.");
            adventureLog.appendText("\nIt is hard to describe the environment as the fog");
            adventureLog.appendText("\nlies thick over the swamp.");
            adventureLog.appendText("\nYou have heard stories about people that have journeyed into");
            adventureLog.appendText("\nthe swamp never to return. Prepare yourself for the challange ahead!");
        } else if (stepCounter >= 10) {
            adventureLog.appendText("\n\nYou have made it through the Deep Sorrows alive.");
            adventureLog.appendText("\nWere you just lucky or were the stories just old wives tales?");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        } else {
            if (randomInt <= 20) {
                generateTreasure();
            } else if (randomInt > 20 && randomInt < 60) {
                adventureLog.appendText(textGenerator.generateText(position));
            } else if (randomInt >= 60) {
                monsterList.add(new MonsterGenerator().generateMonster(position));
                monsterImages();

                adventureLog.appendText("\n\nYou encounter a " + monsterList.get(0).getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");

                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();

        stepCounter++;
    }

    public void castle() {

        randomInt = randomGenerator.nextInt(100) + 1;

        if (stepCounter == 0) {
            adventureLog.appendText("\n\nYou find yourself standing in front of a huge, dark castle.");
            adventureLog.appendText("\n'Wow!'");
            adventureLog.appendText("\nMany a brave adventurer has tried to best this behemoth of a building.");
            adventureLog.appendText("\nDare you enter this fortress of eternal doom, pain and sorrow?");
        } else if (stepCounter >= 10) {
            adventureLog.appendText("\n\nYou have reached the end of this path, there seems to be nothing more to explore in the castle.");
            adventureLog.appendText("\n'How boring.'");
            adventureLog.appendText("\n\nPress the continue button again to return to the world map.");
        }else if (list.get(0).getCurrentArmorUpgrade() >= 10 && list.get(0).getCurrentWeaponUpgrade() >= 10){
            monsterList.add(new SpecialMonster(2000,105,110,10,5000,0,"George"));
            monsterImages();
            
            adventureLog.appendText("\n\nYou have encountered the final boss, George!");
            adventureLog.appendText("\nThis is it, now your mettle shall truly be tested.");
            adventureLog.appendText("\nThe boss is immune to your secondary attack.");
            adventureLog.appendText("\nThere is no way to run, your only chance is to fight!");

            attackButton.setDisable(false);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(true);
        } else {
            if (randomInt <= 20) {
                generateTreasure();
            } else if (randomInt > 20 && randomInt < 60) {
                adventureLog.appendText(textGenerator.generateText(position));
            } else if (randomInt >= 60) {
                monsterList.add(new MonsterGenerator().generateMonster(position));
                monsterImages();

                adventureLog.appendText("\n\nYou encounter a " + monsterList.get(0).getMonsterType());
                adventureLog.appendText("\nIf you wish to fight the monster press the attack button or");
                adventureLog.appendText("\npress the run button to attempt to run away.");

                attackButton.setDisable(false);
                secondaryButton.setDisable(false);
                runButton.setDisable(false);
                continueButton.setDisable(true);
            }
        }
        showStats();

        stepCounter++;
    }

    public void generateTreasure() {
        //generate treasure and add it to the character//
        //under construction//

        int gold = 0;
        randomInt = randomGenerator.nextInt(100) + 1;

        if (randomInt <= 15) {
            gold = 50;

            adventureLog.appendText("\n\nYou stumble upon a chest hidden behind some rocks,");
            adventureLog.appendText("\nYou open it and find a mustash made of the purest gold.");
            adventureLog.appendText("\n'It must be worth a fortune!'");
            adventureLog.appendText("\nYou add " + gold + " gold to your purse.");

        } else if (randomInt > 15 && randomInt <= 40) {
            gold = 20;

            adventureLog.appendText("\n\nYou trip over something and start to curse.");
            adventureLog.appendText("\nYou look behind you to see it was a small jewel encrusted box.");
            adventureLog.appendText("\n'Hot damn!'");
            adventureLog.appendText("\nYou open it to find that it is empty.");
            adventureLog.appendText("\nYou take it anyway and add " + gold + " gold to your purse.");
        } else if (randomInt > 40 && randomInt <= 65) {
            gold = 20;

            adventureLog.appendText("\n\nYou see something shining in the distance.");
            adventureLog.appendText("\nYou start to run towards it and find a small pile of gold pieces.");
            adventureLog.appendText("\n'WOHO!'");
            adventureLog.appendText("\nYou add " + gold + " gold to your purse.");
        } else if (randomInt > 65 && randomInt <= 85) {
            gold = 30;

            adventureLog.appendText("\n\nYou are walking around admiring the enviroment,");
            adventureLog.appendText("\nwhen all of a sudden something drops on your head.");
            adventureLog.appendText("\n'WTF!'");
            adventureLog.appendText("\nYou look around to see what hit you in the head to find a goldnugget");
            adventureLog.appendText("\n'Ohhh nice!'");
            adventureLog.appendText("\nYou add " + gold + " gold to your purse.");
        } else if (randomInt > 85 && randomInt <= 95) {
            gold = 50;

            adventureLog.appendText("\n\nYou hear someone moaning.");
            adventureLog.appendText("\nYou look around and see an old, fragile and weak man sitting with a bag of gold under his arm.");
            adventureLog.appendText("\n'That looks heavy old man, you need help with that?'");
            adventureLog.appendText("\nThe old man looks up to you with an angry look on his face");
            adventureLog.appendText("\n'PISS OFF YOU SILLY CUNT, IT'S MINE, MY OWN, MY PRECIOUS'");
            adventureLog.appendText("\nWithout hesitation you suckerpunch the old man and steal his bag of gold");
            adventureLog.appendText("\nYou add " + gold + " gold to your purse.");
        } else if (randomInt >= 96) {
            gold = -100;

            adventureLog.appendText("\n\nAn ugly dwarf jumps you from behind and kicks you");
            adventureLog.appendText("\nin the groin and steals some of your gold.");
            adventureLog.appendText("\n'Get rekt noob!'");
            adventureLog.appendText("\nYou lose " + gold + " gold.");

        }

        list.get(0).setCurrentGold(list.get(0).getCurrentGold() + gold);
    }

    public void secondaryAttackMage() {

        previousDmg = list.get(0).getCurrentDmg();

        if (((Mage) list.get(0)).castFlameBurst()) {
            monsterList.get(0).setIsBurned(true);

            monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - list.get(0).getCurrentDmg());

            if (monsterList.get(0).getBaseHp() <= 0) {

                monsterImg.setImage(null);

                adventureLog.appendText("\n\nYou are victorious! You have slain the " + monsterList.get(0).getMonsterType() + ".");
                adventureLog.appendText("\nYou add " + monsterList.get(0).getAmountGold() + " gold to your purse and");
                adventureLog.appendText("\ngain " + monsterList.get(0).getAmountScore() + " score.");

                list.get(0).setCurrentGold(list.get(0).getCurrentGold() + monsterList.get(0).getAmountGold());
                list.get(0).setCurrentScore(list.get(0).getCurrentScore() + monsterList.get(0).getAmountScore());

                attackButton.setDisable(true);
                secondaryButton.setDisable(true);
                runButton.setDisable(true);
                continueButton.setDisable(false);
                monsterList.remove(0);
            } else {

                adventureLog.appendText("\n\nYou cast flame burst and it succesfully hits the " + monsterList.get(0).getMonsterType() + "!");
                adventureLog.appendText("\nIt deals " + list.get(0).getCurrentDmg() + " damage and applies a periodical burn effect.");
                monsterAttack();
            }
        } else {
            adventureLog.appendText("\n\nYour flame burst misses!");
            monsterAttack();
        }
        list.get(0).setCurrentDmg(previousDmg);
        showStats();

    }

    public void secondaryAttackWarrior() {

        previousDmg = list.get(0).getCurrentDmg();

        if (((Warrior) list.get(0)).castShieldBash()) {
            monsterList.get(0).setIsStunned(true);

            monsterList.get(0).setBaseHp(monsterList.get(0).getBaseHp() - list.get(0).getCurrentDmg());

            if (monsterList.get(0).getBaseHp() <= 0) {

                monsterImg.setImage(null);

                adventureLog.appendText("\n\nYou are victorious! You have slain the " + monsterList.get(0).getMonsterType() + ".");
                adventureLog.appendText("\nYou add " + monsterList.get(0).getAmountGold() + " gold to your purse and");
                adventureLog.appendText("\ngain " + monsterList.get(0).getAmountScore() + " score.");

                list.get(0).setCurrentGold(list.get(0).getCurrentGold() + monsterList.get(0).getAmountGold());
                list.get(0).setCurrentScore(list.get(0).getCurrentScore() + monsterList.get(0).getAmountScore());

                attackButton.setDisable(true);
                secondaryButton.setDisable(true);
                runButton.setDisable(true);
                continueButton.setDisable(false);
                monsterList.remove(0);
            } else {

                adventureLog.appendText("\n\nYou bash your shield in the " + monsterList.get(0).getMonsterType() + "s face!");
                adventureLog.appendText("\nIt takes " + list.get(0).getCurrentDmg() + " damage and is momentarily stunned.");
                monsterAttack();
            }
        } else {
            adventureLog.appendText("\n\nYour shield bash misses!");
            monsterAttack();
        }

        list.get(0).setCurrentDmg(previousDmg);
        showStats();
    }

    public void secondaryAttackAssassin() {

        int unbuffedDef = list.get(0).getCurrentDef();

        if (((Rogue) list.get(0)).castAssassinate()) {
            monsterList.get(0).setBaseHp(0);

            monsterImg.setImage(null);

            adventureLog.appendText("\n\nYou strike a mighty blow aimed att a vital point, the monster falls over dead!");
            adventureLog.appendText("\nYou add " + monsterList.get(0).getAmountGold() + " gold to your purse and");
            adventureLog.appendText("\ngain " + monsterList.get(0).getAmountScore() + " score.");

            list.get(0).setCurrentGold(list.get(0).getCurrentGold() + monsterList.get(0).getAmountGold());
            list.get(0).setCurrentScore(list.get(0).getCurrentScore() + monsterList.get(0).getAmountScore());

            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);
            monsterList.remove(0);

        } else {
            adventureLog.appendText("\n\nThe monster dodges your attack!");
            monsterAttack();
        }

        list.get(0).setCurrentDef(unbuffedDef);
        showStats();
    }

    public void monsterAttack() {

        randomInt = randomGenerator.nextInt(6) + 1;

        if (!monsterList.get(0).getIsStunned()) {
            if (monsterList.get(0).getBaseAttack() > list.get(0).getCurrentDef()) {

                if (randomInt > 2) {
                    list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monsterList.get(0).getBaseDmg());
                    adventureLog.appendText("\n\nThe monster strikes you for " + monsterList.get(0).getBaseDmg() + " Damage!");
                } else {
                    adventureLog.appendText("\n\nThe monster misses!");
                }
            } else if (monsterList.get(0).getBaseAttack() == list.get(0).getCurrentDef()) {

                if (randomInt > 3) {
                    list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monsterList.get(0).getBaseDmg());
                    adventureLog.appendText("\n\nThe monster strikes you for " + monsterList.get(0).getBaseDmg() + " Damage!");
                } else {
                    adventureLog.appendText("\n\nThe monster misses!");
                }
            } else {

                if (randomInt > 4) {
                    list.get(0).setCurrentHp(list.get(0).getCurrentHp() - monsterList.get(0).getBaseDmg());
                    adventureLog.appendText("\n\nThe monster strikes you for " + monsterList.get(0).getBaseDmg() + " Damage!");
                } else {
                    adventureLog.appendText("\n\nThe monster misses!");
                }
            }
        } else {
            adventureLog.appendText("\n\nThe monster is stunned and unable to retaliate!");
        }

        if (list.get(0).getCurrentHp() <= 0) {

            deadCharacter = true;

            attackButton.setDisable(true);
            secondaryButton.setDisable(true);
            runButton.setDisable(true);
            continueButton.setDisable(false);

            adventureLog.appendText("\n\nYou have died. As your spirit leaves your body you can see your enemy");
            adventureLog.appendText("\nrip your lifeless body limb from limb.");
            adventureLog.appendText("\nMaybe it will fashion a nice hat from your body.");
            adventureLog.appendText("\n\nWhen you press continue this character will be deleted");
            adventureLog.appendText("\nand its score will be added to the High-score table.");
        } else {

            showStats();
        }
    }
    
    public void specialMonsterAttack(){
        
        if (charge <= 0){
            int specialDamage = ((SpecialMonster) monsterList.get(0)).specialAttack(list.get(0).getCurrentHp());
            list.get(0).setCurrentHp(list.get(0).getCurrentHp() - specialDamage);
            adventureLog.appendText("\n\nYou are hit for " + specialDamage + " damage!" );
            charge = 4;
        } 
        else if(charge == 4) {
            adventureLog.appendText("\n\nGeorge charges his devastating special attack!");
            charge--;
        }else{
            adventureLog.appendText("\n\n" + charge +"..");
            charge--;
        }
    }

    public void gameOver(ActionEvent event) {

        try {
            Node node = (Node) event.getSource();
            Stage stageLogin = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGameOver.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageLogin.setScene(scene);
            stageLogin.show();
                //UserData.getInstance().setRememeberLastClass(this.getClass().getName());

        } catch (IOException ex) {
            System.out.println("Scene change error1rrr");
        }
    }

    public void showStats() {

        attackLabel.setText(Integer.toString(list.get(0).getCurrentAttack()));
        defenceLabel.setText(Integer.toString(list.get(0).getCurrentDef()));
        hpLabel.setText(Integer.toString(list.get(0).getCurrentHp()));
        goldLabel.setText(Integer.toString(list.get(0).getCurrentGold()));
        scoreLabel.setText(Integer.toString(list.get(0).getCurrentScore()));
        dmgLabel.setText(Integer.toString(list.get(0).getCurrentDmg()));
        nameLabel.setText(list.get(0).getCharacterName());
    }

    public void monsterImages() {
        if (monsterList.get(0).getMonsterType().equals("Spider")) {

            monsterImg.setImage(spiderImage);
        } else if (monsterList.get(0).getMonsterType().equals("giant Spider")) {

            monsterImg.setImage(spiderImage);
        } else if (monsterList.get(0).getMonsterType().equals("Slime")) {

            monsterImg.setImage(slimeImage);
        } else if (monsterList.get(0).getMonsterType().equals("Ooze")) {

            monsterImg.setImage(oozeImage);
        } else if (monsterList.get(0).getMonsterType().equals("giant Goblin")) {

            monsterImg.setImage(goblinImage);
        } else if (monsterList.get(0).getMonsterType().equals("giant Hobgoblin")) {

            monsterImg.setImage(goblinImage);
        } else if (monsterList.get(0).getMonsterType().equals("giant Goblin knight")) {

            monsterImg.setImage(goblinImage);
        } else if (monsterList.get(0).getMonsterType().equals("Orc")) {

            monsterImg.setImage(orcImage);
        } else if (monsterList.get(0).getMonsterType().equals("Orc berserker")) {

            monsterImg.setImage(orcImage);
        } else if (monsterList.get(0).getMonsterType().equals("Orc knight")) {

            monsterImg.setImage(orcImage);
        } else if (monsterList.get(0).getMonsterType().equals("Troll")) {

            monsterImg.setImage(trollImage);
        } else if (monsterList.get(0).getMonsterType().equals("Dragon")) {

            monsterImg.setImage(dragonImage);
        } else if (monsterList.get(0).getMonsterType().equals("Cyclops")) {

            monsterImg.setImage(cyclopImage);
        } else if (monsterList.get(0).getMonsterType().equals("Treeman")) {

            monsterImg.setImage(treemanImage);
        } else if (monsterList.get(0).getMonsterType().equals("Fluffy")) {

            monsterImg.setImage(fluffyImage);
        } else if (monsterList.get(0).getMonsterType().equals("George")) {

            monsterImg.setImage(bossImage);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        backgroundImg.setPreserveRatio(false);
        MusicSettings.getInstance().playMusic(UserData.getInstance().getAdventurePosition());

        position = UserData.getInstance().getAdventurePosition();

        if (position.equals("plains")) {
            backgroundImg.setImage(plainsImage);
        } else if (position.equals("forest")) {
            backgroundImg.setImage(forestImage);
        } else if (position.equals("mountain")) {
            backgroundImg.setImage(mountainImage);  
        } else if (position.equals("swamp")) {
            backgroundImg.setImage(swampImage);
        } else {
            backgroundImg.setImage(castleImage);
        }

        Characters player = UserData.getInstance().getCharactersArrList();

        if (player instanceof Warrior) {
            Warrior hero = (Warrior) player;
            characterImg.setImage(warriorImage);
            list.add(hero);
        } else if (player instanceof Mage) {
            Mage hero = (Mage) player;
            characterImg.setImage(mageImage);
            list.add(hero);
        } else if (player instanceof Rogue) {
            Rogue hero = (Rogue) player;
            characterImg.setImage(rogueImage);
            list.add(hero);
        }

        attackButton.setDisable(true);
        secondaryButton.setDisable(true);
        runButton.setDisable(true);
        continueButton.setDisable(false);

        System.out.println(list.get(0).getCharacterName());

        showStats();
    }
}
