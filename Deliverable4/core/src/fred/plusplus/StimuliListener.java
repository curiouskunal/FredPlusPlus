package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class StimuliListener extends Listener{

    public StimuliListener(FredAttributeDataStore fred) {
        this.fred = fred;
        buttons = new ArrayList<Button>();
    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {

        for (Button b : buttons){
            if (b.intersects(x, y)){
                b.tap();

                return true; // return true to indicate the event was handled
            }
        }

        return false;
    }
}
