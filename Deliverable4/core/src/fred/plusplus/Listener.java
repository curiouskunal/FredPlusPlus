package fred.plusplus;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

/**
 * Created by Josh on 02/04/2017.
 */

public abstract class Listener extends InputAdapter {

    FredAttributeDataStore fred;

    ArrayList<Button> buttons;

    protected int x;
    protected int y;

    public ArrayList<Button> getButtons(){
        return buttons;
    }

    public void addButton(String subSystem, String onFilename, String offFilename){
        buttons.add(new Button(x, y, subSystem, onFilename, offFilename));
        y += 200;
    }

}
