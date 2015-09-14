package grocerystoresimulator;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sean and Jacob
 */
public class SoundClip {
    
    AudioInputStream audioInputStream;
    Clip clip;
    FloatControl gainControl;
    
    public SoundClip(String soundName) 
            throws UnsupportedAudioFileException, LineUnavailableException
        {
        try
        {
            audioInputStream = 
                    AudioSystem.getAudioInputStream(
                            new File(soundName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
            gainControl = 
                 (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch (UnsupportedAudioFileException e)
        {
            e.printStackTrace();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }   
    }
    /**
     * Plays a specific sound clip.
     */
    public void play()
    {
        clip.start();
    }
    /**
     * Loops the audio clip and reduces the volume of the clip as well.
     */
    public void loopCont()
    {
        gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
