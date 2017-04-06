package fred.plusplus;

import com.badlogic.gdx.Gdx;

import sun.rmi.runtime.Log;

/**
 * Created by vicve on 4/6/2017.
 */

public class FredPoller implements Runnable {

    private FredAttributeDataStore fred;

    public FredPoller(FredAttributeDataStore fred) {
        this.fred = fred;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);

            while (true) {
                check();

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Gdx.app.error("FredPoller.java", "Interrupted Exception");
        }
    }

    private void check() {
        for (Metric m : fred.getMetrics()) {
            if (m.getName().equals("overall_health") && m.getValue() == 0) {
                fred.signalDeath();
            }
        }
    }

}
