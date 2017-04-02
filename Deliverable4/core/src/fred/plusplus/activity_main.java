package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class activity_main {

    private ShowSubsystemListener showListener;
    private ToggleSubsystemListener toggleListener;
    private StimuliListener stimuliListener;
    private InputMultiplexer multiplexer;

    private SpriteBatch batch;

    public activity_main(FredAttributeDataStore fred){
        batch = new SpriteBatch();
        showListener = new ShowSubsystemListener(fred);
        toggleListener = new ToggleSubsystemListener(fred);
        stimuliListener = new StimuliListener(fred);

        //This is how libGDX handles multiple different input listeners
        //Whenever a touch event happens, it will pass it to the first listener
        //If a listener doesn't handle it, it returns false and the event passes to the next listener
        //If a listener does handle the input, it returns true and the multiplexer stops
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(showListener);
        multiplexer.addProcessor(toggleListener);
        multiplexer.addProcessor(stimuliListener);
        Gdx.input.setInputProcessor(multiplexer);


        showListener.addButton(100, 200, "cardiovascular", "showCardioOn.png", "showCardioOff.png");
        showListener.addButton(100, 300, "nervous", "showCardioOn.png", "showCardioOff.png");
        showListener.addButton(100, 400, "locomotor", "showCardioOn.png", "showCardioOff.png");
        showListener.addButton(100, 500, "digestive", "showCardioOn.png", "showCardioOff.png");

        //toggleListener.add

    }

    public void draw(Texture texture, int x, int y){
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }

    public void drawSubSystems(ArrayList<System> systems){
        batch.begin();
        for (System sys : systems) {
            batch.draw(sys.getTexture(), 0, 0);
        }
        batch.end();
    }

    public void drawButtons(){
        batch.begin();
        for (Button b : showListener.getButtons()){
            batch.draw(b.getTexture(), b.getX(), b.getY());
        }
        batch.end();
    }

    public void dispose () {
        batch.dispose();
    }
}
