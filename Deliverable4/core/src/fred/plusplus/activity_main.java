package fred.plusplus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Josh on 31/03/2017.
 */

public class activity_main {

    SpriteBatch batch;

    public activity_main(){
        batch = new SpriteBatch();
    }

    public void draw(FredAttributeDataStore fred){
        batch.begin();
        //Draw each of Fred's enabled SubSystems
        batch.draw(fred.getBaseTexture(), 0, 0);
        for (System sys: fred.getEnabledSystems()){
            batch.draw(sys.getTexture(), 0, 0);
        }

        batch.end();
    }

    public void dispose () {
        batch.dispose();
    }
}
