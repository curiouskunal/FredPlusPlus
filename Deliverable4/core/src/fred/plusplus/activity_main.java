package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class activity_main {

    SpriteBatch batch;

    public activity_main(){
        batch = new SpriteBatch();
    }

    public void draw(Texture texture, int x, int y){
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }

    public void drawSubSystems(ArrayList<System> systems){
        batch.begin();
        for (System sys : systems) {
            batch.draw(sys.getTexture(), 0, 0);
        }
        batch.end();
    }

    public void dispose () {
        batch.dispose();
    }
}
