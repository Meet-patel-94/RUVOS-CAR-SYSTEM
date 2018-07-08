
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Radio extends E_System{
    String musicFile = "copy_of_a.mp3"; 

    //Media sound = new Media(new File(musicFile).toURI().toString());
    //MediaPlayer player = new MediaPlayer(sound);
    private boolean isOn;
   
            
            public Radio(){
                super();
                isOn=false;
            }
            
            public boolean isOn(){
                return isOn;
            }
            
            public void turnOn(){
                isOn=true;
                //player.play();
            }
            
            public void turnOff(){
              //player.pause();
               isOn=false;
            }
            public String toString(){
                if(isOn){
                return super.toString()+musicFile;
                }
                else{
                    return "Paused: "+musicFile;
                }
            }
            
            
    
}
