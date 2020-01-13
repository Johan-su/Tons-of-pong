import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MySound {
	    public static final File hitSound = new File("Sound/pop.wav");
	    public static float volume = -20.0f;
	    public static synchronized void playSound() {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(hitSound);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	            gainControl.setValue(volume);
	            clip.start();
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    }

}
