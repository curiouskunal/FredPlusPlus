package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class RandomEvent {
    ArrayList<MetricChange> effects;
    String name;
    int probability;

    public RandomEvent(ArrayList<MetricChange> effects, String name, int probability){
        this.effects = effects;
        this.name = name;
        this.probability = probability;
    }

}
