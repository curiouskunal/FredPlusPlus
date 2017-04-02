package fred.plusplus;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class ToggleSubsystemListener extends Listener {

    public ToggleSubsystemListener(FredAttributeDataStore fred){
        this.fred = fred;
        buttons = new ArrayList<Button>();
    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {

        for (Button b : buttons){
            if (b.intersects(x, y)){

                b.tap();

                fred.toggleSystem(b.getSubSystem());

                return true;
            }
        }

        return false; // return true to indicate the event was handled
    }

}
