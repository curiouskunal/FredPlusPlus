package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Josh on 31/03/2017.
 */

public abstract class System {

    Texture img;

    public Texture getTexture(){
        return img;
    }

    public void dispose(){
        img.dispose();
    }

}
