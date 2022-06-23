import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer implements LineListener {
    boolean playCompleted;
    Clip audioClip;
    void play(String audioFilePath){
        File audiofile = new File(audioFilePath);

        try{    //try looping or adding two songs!*
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audiofile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            
            audioClip.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }
    public void loop(){
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        audioClip.stop();
    }
    public boolean hasClip() {
        if(audioClip != null)
            return true;
        return false;
    }
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if(type == LineEvent.Type.START) {
            System.out.println("Playback started");
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
}