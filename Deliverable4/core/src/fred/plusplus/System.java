package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public abstract class System {

    protected Texture img;
    protected String name;
    protected ArrayList<Metric> listOfMetrics;

    abstract ArrayList<MetricChange> reactToStimuli(Stimulus s);

    public Texture getTexture(){
        return img;
    }
    public String getName(){ return name; }

    public ArrayList<Metric> listOfMetrics() { return listOfMetrics; }

    public void dispose(){
        img.dispose();
    }

}
