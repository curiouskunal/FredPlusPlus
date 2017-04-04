package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        toggleListener = new ToggleSubsystemListener(fred, showListener);
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


        showListener.addButton("cardiovascular", "shownCardiovascular.png", "hiddenCardiovascular.png");
        showListener.addButton("nervous", "shownNervous.png", "hiddenNervous.png");
        showListener.addButton("locomotor", "shownLocomotor.png", "hiddenLocomotor.png");
        showListener.addButton("digestive", "shownDigestive.png", "hiddenDigestive.png");

        toggleListener.addButton("cardiovascular", "activeCardiovascular.png", "inactiveCardiovascular.png");
        toggleListener.addButton("nervous", "activeNervous.png", "inactiveNervous.png");
        toggleListener.addButton("locomotor", "activeLocomotor.png", "inactiveLocomotor.png");
        toggleListener.addButton("digestive", "activeDigestive.png", "inactiveDigestive.png");
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
        for (Button b : toggleListener.getButtons()){
            batch.draw(b.getTexture(), b.getX(), b.getY());
        }
        batch.end();
    }

    public void dispose () {
        batch.dispose();
    }
}
