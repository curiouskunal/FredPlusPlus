package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public abstract class System {

    protected Texture img;
    protected String name;
    //protected Rect
    protected boolean isActivated = true;
    protected boolean isVisible = true;
    protected ArrayList<Metric> listOfMetrics;

    abstract ArrayList<MetricChange> reactToStimuli(Stimulus s);

    public Texture getTexture(){
        return img;
    }

    public String getName(){ return name; }

    public boolean getIsActivated(){
        return isActivated;
    }

    public boolean getIsVisible(){
        return isVisible;
    }

    public void activate(){
        isActivated = true;
    }

    public void deactivate(){
        isActivated = false;
    }

    public void show(){
        isVisible = true;
    }

    public void hide(){
        isVisible = false;
    }

    public void dispose(){
        img.dispose();
    }

}
