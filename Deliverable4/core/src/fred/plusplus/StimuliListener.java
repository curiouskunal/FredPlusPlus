package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class StimuliListener extends Listener{

    public StimuliListener(FredAttributeDataStore fred) {
        this.fred = fred;
        buttons = new ArrayList<Button>();
        x = 0;
        y = 2150;
    }

    public void addButton(int x, String subSystem, String onFilename, String offFilename, Stimulus stimulus){
        Button button = new Button(this.x + x, y, subSystem, onFilename, offFilename, stimulus);
        buttons.add(button);

    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {

        for (Button b : buttons){
            if (b.intersects(x, y)){

                fred.reactToStimuli(b.getStimulus());

                return true; // return true to indicate the event was handled
            }
        }

        MainActivity.titleScreen = false;

        return false;
    }
}
