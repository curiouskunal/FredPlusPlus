package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.lang.System;

/**
 * Created by Gabriel on 02/04/2017.
 */

public class RandomEventGenerator {

    ArrayList<RandomEvent> events;
    int probabilitySize;
    int[] probabilityIntervals;

    FredAttributeDataStore fred;

    Sound sound0;
    Sound sound1;

    public RandomEventGenerator(int PSize, ArrayList<RandomEvent> event, FredAttributeDataStore fred) {
        this.events = event;
        ParseEvents(PSize);

        this.fred = fred;

        this.probabilitySize = PSize;

        sound0 = Gdx.audio.newSound(Gdx.files.internal("Sounds//" + "Crash.mp3"));
        sound1 = Gdx.audio.newSound(Gdx.files.internal("Sounds//" + "Crash.mp3"));
    }

    private void ParseEvents(int size) {
        //assign probability
        this.probabilityIntervals = new int[events.size() + 2];//plus one because of the 0 and probsize
        int interval = 0;
        int i = 1;
        this.probabilityIntervals[0] = 0;//lower portion of the intervals

        for (RandomEvent list : events) {
            this.probabilityIntervals[i] = interval + list.getProbability();
            interval = list.getProbability();
            i++;
        }

        this.probabilityIntervals[i] = size;
    }

    public void GenerateEvent() {
        Random rand = new Random();
        int pick = rand.nextInt(this.probabilitySize);
        int i = 0;
        for (RandomEvent list : events) {
            if (checkInterval(pick, this.probabilityIntervals[i], this.probabilityIntervals[i + 1]) &&
                    this.probabilityIntervals[i + 1] != probabilitySize) {
                ApplyEvent(i);//return the event that has the probabilty
            }
            i++;
        }
        // nothing happens
    }

    /*ApplyEvent(e)
    * e - the index of the event that is being applied
    * This method iterates through the list of MetricChanges that are tied to the desired event and
    * applies them
     */
    public void ApplyEvent(int e) {
        fred.reactToStimuli(new Stimulus(events.get(e).getName()));

        if (e == 0) {
            sound0.play();
        } if (e == 1) {
            sound1.play();
        }
    }

    /*  checkInterval(b,lower,higher)
    * b - the index of the number the program desires
    * lower - the lower portion of the index
    * higher - the higher portion of the index
    * This bool quickly checks to see if the index is inside of the interval. When the random
    * number is sent to this method, the lower half is included, thus why the lower is >=
     */
    private boolean checkInterval(int b, int lower, int higher) {
        if (b >= lower && b < higher) {
            return true;
        } else {
            return false;
        }

    }

}
