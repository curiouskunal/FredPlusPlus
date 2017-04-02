package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class LocomotorSystem extends System {

    public LocomotorSystem(){
        img = new Texture("FredLocomotor.png");
        name = "locomotor";
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        return new ArrayList<MetricChange>();
    }

}
