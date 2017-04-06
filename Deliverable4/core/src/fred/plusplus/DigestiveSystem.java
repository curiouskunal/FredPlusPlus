package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class DigestiveSystem extends System {

    public DigestiveSystem(){
        img = new Texture("FredDigestive.png");
        name = "digestive";

        listOfMetrics = new ArrayList<Metric>();

        listOfMetrics.add(new Metric("hunger", 50, new Texture("Hunger.png"), true));
        listOfMetrics.add(new Metric("thirst", 50, new Texture("Thirst.png"), true));
        listOfMetrics.add(new Metric("intoxication_level", 0, new Texture("StimuliButton_Beer.png"), false));
        listOfMetrics.add(new Metric("weight", 50, new Texture("activeDigestive.png"), false));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("deteriorate")){
            changes.add(new MetricChange("intoxication_level", -1));
            changes.add(new MetricChange("hunger", -1));
            changes.add(new MetricChange("thirst", -1));
            for (Metric m : listOfMetrics){
                if (m.getName().equals("hunger") && m.getValue() < 30){
                    changes.add(new MetricChange("weight", -1));
                }
                else if (m.getName().equals("hunger") && m.getValue() > 90){
                    changes.add(new MetricChange("weight", 1));
                }
            }
        }
        else if (s.name.equals("food")) {
            changes.add(new MetricChange("intoxication_level", -5));
            changes.add(new MetricChange("hunger", 15));
            changes.add(new MetricChange("thirst", -2));
            changes.add(new MetricChange("weight", 5));
        }
        else if (s.name.equals("drink")) {
            changes.add(new MetricChange("intoxication_level", 25));
            changes.add(new MetricChange("hunger", 5));
            changes.add(new MetricChange("thirst", 25));
            changes.add(new MetricChange("weight", 2));
        }
        else if (s.name.equals("random_injury")) {
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", 0));
            changes.add(new MetricChange("thirst", 0));
            changes.add(new MetricChange("weight", 0));

        }
        else if (s.name.equals("partying")) {
            changes.add(new MetricChange("intoxication_level", 30));
            changes.add(new MetricChange("hunger", 15));
            changes.add(new MetricChange("thirst", 15));
            changes.add(new MetricChange("weight", 5));
        }
        else if (s.name.equals("lift_weights")) {
            changes.add(new MetricChange("weight", -5));
            changes.add(new MetricChange("hunger", -10));
        }
        else if (s.name.equals("running")) {
            changes.add(new MetricChange("weight", -10));
            changes.add(new MetricChange("hunger", -10));
        }

        return changes;
    }

}
