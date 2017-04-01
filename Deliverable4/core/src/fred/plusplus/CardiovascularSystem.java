package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class CardiovascularSystem extends System {

    public CardiovascularSystem(){
        img = new Texture("FredSkeleton.png");
        name = "cardiovascular";
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        return changes;
    }

}
