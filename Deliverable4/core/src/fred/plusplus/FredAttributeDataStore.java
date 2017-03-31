package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 30/03/2017.
 */

public class FredAttributeDataStore {

    private Texture fredBase;

    private ArrayList<System> enabledSystems = new ArrayList<System>();
    private CardiovascularSystem cardio = new CardiovascularSystem();

    public FredAttributeDataStore(){
        fredBase = new Texture("FredBaseTemplate.png");
        enabledSystems.add(cardio);
    }

    public ArrayList<System> getEnabledSystems(){
        return enabledSystems;
    }

    public Texture getBaseTexture(){
        return fredBase;
    }

    public void dispose(){
        fredBase.dispose();
        for (System sys: enabledSystems) {
            sys.dispose();
        }
    }

}
