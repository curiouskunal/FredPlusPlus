package fred.plusplus;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

/**
 * Created by Josh on 02/04/2017.
 */

public abstract class Listener extends InputAdapter {

    FredAttributeDataStore fred;

    ArrayList<Button> buttons;

    public ArrayList<Button> getButtons(){
        return buttons;
    }

    public void addButton(int x, int y, String subSystem, String onFilename, String offFilename){
        buttons.add(new Button(x, y, subSystem, onFilename, offFilename));
    }

}
