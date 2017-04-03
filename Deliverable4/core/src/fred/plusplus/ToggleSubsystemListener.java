package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class ToggleSubsystemListener extends Listener {

    private ShowSubsystemListener show;

    public ToggleSubsystemListener(FredAttributeDataStore fred, ShowSubsystemListener show){
        this.fred = fred;
        buttons = new ArrayList<Button>();
        x = 20;
        y = 20;
        this.show = show;
    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {

        for (Button b : buttons){
            if (b.intersects(x, y)){

                b.tap();

                fred.toggleSystem(b.getSubSystem());
                for (Button b2 : show.getButtons()){
                    if (b2.getSubSystem().equals(b.getSubSystem())){
                        if (b2.isOn()) {
                            b2.tap();
                        }
                        b2.toggleActivate();
                    }
                }

                return true; // return true to indicate the event was handled
            }
        }

        return false;
    }

}
