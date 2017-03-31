package fred.plusplus;

import com.badlogic.gdx.InputAdapter;

/**
 * Created by Josh on 31/03/2017.
 */

public class ShowSubsystemListener extends InputAdapter {

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {
        // your touch down code here
        return true; // return true to indicate the event was handled
    }

}
