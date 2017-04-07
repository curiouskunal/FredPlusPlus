package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vic on 2017-04-07.
 */

public class RandomEventRunner implements Runnable {

    private FredAttributeDataStore fred;
    private RandomEventGenerator gen;

    public RandomEventRunner(FredAttributeDataStore fred) {
        this.fred = fred;

        ArrayList<RandomEvent> list = new ArrayList<RandomEvent>(Arrays.asList(
                new RandomEvent("car_crash", 5),
                new RandomEvent("fall_down_stairs", 8),
                new RandomEvent("panic_attack", 10),
                new RandomEvent("burst_of_motivation", 10),
                new RandomEvent("ebola", 1),
                new RandomEvent("acid_reflex", 10),
                new RandomEvent("puberty", 8),
                new RandomEvent("twisted_ankle", 10),
                new RandomEvent("slowed_motabolism", 10),
                new RandomEvent("slept_on_neck", 15)));

        gen = new RandomEventGenerator(90, list, fred);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);

            while (true) {
                gen.ApplyEvent(0);

                Thread.sleep(30000);
            }

        } catch (InterruptedException e) {
            Gdx.app.log("RandomEventRunner.java", "Interrupted Exception");
        }
    }

}
