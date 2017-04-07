package fred.plusplus;

import com.badlogic.gdx.Gdx;

/**
 * Created by vicve on 4/6/2017.
 */

public class DeteriorateController implements Runnable {

    private FredAttributeDataStore fred;

    public DeteriorateController(FredAttributeDataStore fred) {
        this.fred = fred;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

            while (true) {
                fred.deteriorate();

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Gdx.app.error("RandomEventController.java", "Interrupted Exception");
        }
    }

}