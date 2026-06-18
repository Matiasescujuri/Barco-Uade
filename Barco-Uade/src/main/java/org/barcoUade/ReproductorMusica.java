package main.java.org.barcoUade;

import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusica {

    private Clip clip;

    public void reproducir() {
        try {
            File archivo = new File(
                    "Barco-Uade/src/sounds/Walen-Aura-Power-_freetouse.com_.wav"
            );

            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}