package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Josh on 31/03/2017.
 */

public class Stimulus {
    String name;
    Sound sound;

    public Stimulus(String name, String sound){
        this.name = name;
        this.sound = Gdx.audio.newSound(Gdx.files.internal("Sounds//"+sound));
    }
    public Stimulus(String name){
        this.name = name;
    }
    public Sound getSound(){
        return sound;
    }
}
