/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.bizzareadvent.SaveLoad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Mike
 */
public class MusicSettings {

    private static MusicSettings instance;
    //private StringProperty previousScene = new SimpleStringProperty();

    private MusicSettings() {
    }

    public static MusicSettings getInstance() {

        if (instance == null) {
            instance = new MusicSettings();

        }

        return instance;

    }

    private Path path = Paths.get("test.txt");

    private ArrayList<MediaPlayer> musicPlayerArrList = new ArrayList<>();

    private MediaPlayer musicPlayerTEMP;

    private boolean musicOn;

    public void writeToFile() {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            boolean b = musicOn;

            dos.writeBoolean(b);

            dos.close();

        } catch (IOException ex) {

        }
    }

    private File file = new File("test111.txt");

    public void readFromFile() {

        if (file.exists()) {

            try {
                FileInputStream fis = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(fis);

                //System.out.println(dis.readBoolean());
                musicOn = dis.readBoolean();
                System.out.println(musicOn);

                dis.close();

            } catch (IOException ex) {

            }
        } else {
            musicOn = true;
        }
    }

    public void loadMusic() {
        addMusic("/Maid with the Flaxen Hair.mp3");  // main music
        addMusic("/musiconloop1.mp3");       // worldmap
        addMusic("/plains1.mp3");     // plains
        addMusic("/forest1.mp3");           // forest
        addMusic("/swamp1.mp3");       // swamp
        addMusic("/mountain1.mp3");     // mountain
        addMusic("/finalBoss.mp3");       // castle boss
        addMusic("/castleormaybenot2.mp3");       // castle
    }

    private void addMusic(String path) {
        Media audioFile = new Media(getClass().getResource(path).toString());
        try {
            musicPlayerTEMP = new MediaPlayer(audioFile);
            musicPlayerTEMP.setCycleCount(MediaPlayer.INDEFINITE);
            musicPlayerTEMP.setVolume(0.7);
            musicPlayerArrList.add(musicPlayerTEMP);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void stopAllMusic() {
        for (MediaPlayer musicPlayerArrList1 : musicPlayerArrList) {
            musicPlayerArrList1.stop();
        }
    }

    public void playMusic(String scene) {

        if (musicOn) {

            if (musicPlayerArrList.isEmpty()) {
                loadMusic();
            }
            stopAllMusic();
            if (scene.equalsIgnoreCase("main")) {
                musicPlayerArrList.get(0).play();
            } else if (scene.equalsIgnoreCase("worldmap")) {
                musicPlayerArrList.get(1).play();
            } else if (scene.equalsIgnoreCase("plains")) {
                musicPlayerArrList.get(2).play();
            } else if (scene.equalsIgnoreCase("forest")) {
                musicPlayerArrList.get(3).play();
            } else if (scene.equalsIgnoreCase("swamp")) {
                musicPlayerArrList.get(4).play();
            } else if (scene.equalsIgnoreCase("mountain")) {
                musicPlayerArrList.get(5).play();
            } else if (scene.equalsIgnoreCase("castle")) {
                int armorUpgrade = UserData.getInstance().getCharactersArrList().getCurrentArmorUpgrade();
                int weaponUpgrade = UserData.getInstance().getCharactersArrList().getCurrentWeaponUpgrade();
                if (armorUpgrade >= 10 && weaponUpgrade >= 10) {
                    musicPlayerArrList.get(6).play();
                } else {
                    musicPlayerArrList.get(7).play();
                }
            }
        } else {
            stopAllMusic();
        }
    }
    //MusicSettings.getInstance().playMusic(UserData.getInstance().getAdventurePosition());

    public boolean isMusicOn() {
        return musicOn;
    }

    public void setMusicOnOff(boolean musicOnOff) {
        this.musicOn = musicOnOff;
    }

}
