package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class DigestiveSystem extends System {

    public DigestiveSystem(){
        img = new Texture("FredSkeleton.png");
        name = "digestive";
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        return new ArrayList<MetricChange>();
    }

}
