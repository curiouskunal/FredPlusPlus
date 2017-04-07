package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class ShowSubsystemListener extends Listener {

    public ShowSubsystemListener(FredAttributeDataStore fred) {
        this.fred = fred;
        buttons = new ArrayList<Button>();
        x = 230;
        y = 20;
    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown(int x, int y, int pointer, int button) {

        for (Button b : buttons) {
            if (b.intersects(x, y)) {

                if (b.isActive()) {
                    b.tap();
                    fred.showHideSystem(b.getSubSystem());
                }
                return true;
            }
        }

        return false; // return true to indicate the event was handled
    }
}
