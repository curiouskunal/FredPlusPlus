package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class RandomEvent {
    String name;
    int probability;

    public RandomEvent(String name, int probability) {

        this.name = name;
        this.probability = probability;
    }

    public int getProbability() {
        return this.probability;
    }

    public String getName() {
        return this.name;
    }

}
