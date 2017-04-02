package fred.plusplus;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class ShowSubsystemListener extends InputAdapter {

    FredAttributeDataStore fred;

    ArrayList<Button> buttons;

    public ShowSubsystemListener(FredAttributeDataStore fred){
        this.fred = fred;
        buttons = new ArrayList<Button>();
    }

    public void addButton(int x, int y, String onFilename, String offFilename){
        buttons.add(new Button(x, y, onFilename, offFilename));
    }

    @Override
    //ignore pointer and button, those are for mouse input (right-clicking, etc)
    public boolean touchDown (int x, int y, int pointer, int button) {

        for (Button b : buttons){
            if (b.intersects(x, y)){
                b.tap();
                return true;
            }
        }

        return false; // return true to indicate the event was handled
    }

    public ArrayList<Button> getButtons(){
        return buttons;
    }

}
