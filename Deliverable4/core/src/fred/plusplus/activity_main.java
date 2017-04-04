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
    private int space = 175;
    private int metricPos = 200;

    private SpriteBatch batch;

    private Texture red;
    private Texture yellow;
    private Texture green;

    private Texture bg;

    public activity_main(FredAttributeDataStore fred) {
        batch = new SpriteBatch();
        red = new Texture("Red.png");
        yellow = new Texture("Yellow.png");
        green = new Texture("Green.png");
        bg = new Texture("BG.png");

        showListener = new ShowSubsystemListener(fred);
        stimuliListener = new StimuliListener(fred);
        toggleListener = new ToggleSubsystemListener(fred, showListener, stimuliListener);

        showListener.addButton("cardiovascular", "shownCardiovascular.png", "hiddenCardiovascular.png");
        showListener.addButton("nervous", "shownNervous.png", "hiddenNervous.png");
        showListener.addButton("locomotor", "shownLocomotor.png", "hiddenLocomotor.png");
        showListener.addButton("digestive", "shownDigestive.png", "hiddenDigestive.png");

        toggleListener.addButton("cardiovascular", "activeCardiovascular.png", "inactiveCardiovascular.png");
        toggleListener.addButton("nervous", "activeNervous.png", "inactiveNervous.png");
        toggleListener.addButton("locomotor", "activeLocomotor.png", "inactiveLocomotor.png");
        toggleListener.addButton("digestive", "activeDigestive.png", "inactiveDigestive.png");

        stimuliListener.addButton(0, "cardiovascular", "activeCardiovascular.png", "inactiveCardiovascular.png", new Stimulus("exercise"));
        stimuliListener.addButton(space, "cardiovascular", "activeCardiovascular.png", "inactiveCardiovascular.png", new Stimulus("medicine"));

        stimuliListener.addButton(space*2, "digestive", "activeDigestive.png", "inactiveDigestive.png", new Stimulus("food"));
        stimuliListener.addButton(space*3, "digestive", "activeDigestive.png", "inactiveDigestive.png", new Stimulus("drink"));

        stimuliListener.addButton(space*4, "locomotor", "activeLocomotor.png", "inactiveLocomotor.png", new Stimulus("exercise"));
        stimuliListener.addButton(space*5, "locomotor", "activeLocomotor.png", "inactiveLocomotor.png", new Stimulus("bandage"));

        stimuliListener.addButton(space*6, "nervous", "activeNervous.png", "inactiveNervous.png", new Stimulus("homework"));
        stimuliListener.addButton(space*7, "nervous", "activeNervous.png", "inactiveNervous.png", new Stimulus("partying"));

        //This is how libGDX handles multiple different input listeners
        //Whenever a touch event happens, it will pass it to the first listener
        //If a listener doesn't handle it, it returns false and the event passes to the next listener
        //If a listener does handle the input, it returns true and the multiplexer stops
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(showListener);
        multiplexer.addProcessor(toggleListener);
        multiplexer.addProcessor(stimuliListener);
        Gdx.input.setInputProcessor(multiplexer);
    }


    public void drawBG(){
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.end();
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
        for (Button b : stimuliListener.getButtons()){
            batch.draw(b.getTexture(), b.getX(), b.getY());
        }
        batch.end();
    }

    public void drawMetric(Metric m){
        batch.begin();
        if (m.getValue() > 70){
            batch.draw(green, 200, metricPos, 200, 200);
        }
        else if (m.getValue() > 30){
            batch.draw(yellow, 200, metricPos, 200, 200);
        }
        else{
            batch.draw(red, 200, metricPos, 200, 200);
        }
        batch.end();
        //metricPos -= 50;
    }

    public void dispose () {
        batch.dispose();
    }
}
