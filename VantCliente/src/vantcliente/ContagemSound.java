/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vantcliente;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;
/**
 *
 * @author ASUS
 */
public class ContagemSound implements Runnable{

    public ContagemSound() {
    }

    @Override
    public void run() {
        try {
         URL url = this.getClass().getClassLoader().getResource("C:\\Users\\ASUS\\Desktop\\VantCliente\\src\\sons\\countdown.mp3");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
        } catch (IOException ex) {
            Logger.getLogger(ContagemSound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ContagemSound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ContagemSound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
