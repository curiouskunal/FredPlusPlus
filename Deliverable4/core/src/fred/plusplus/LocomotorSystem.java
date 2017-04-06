package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class LocomotorSystem extends System {

    public LocomotorSystem(){
        img = new Texture("FredLocomotor.png");
        name = "locomotor";

        listOfMetrics = new ArrayList<Metric>();

        listOfMetrics.add(new Metric("strength", 50, new Texture("Strength.png"), true));
        listOfMetrics.add(new Metric("pain_body", 0, new Texture("Pain.png"), false));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("deteriorate")) {
            changes.add(new MetricChange("strength", -1));
        }
        else if (s.name.equals("food")) {
        }
        else if (s.name.equals("drink")) {

        }
        else if (s.name.equals("homework")) {

        }
        else if (s.name.equals("bandage")) {
            changes.add(new MetricChange("pain_body", -10));
        }
        else if (s.name.equals("random_injury")) {
            changes.add(new MetricChange("pain_body", 100));
        }
        else if (s.name.equals("partying")) {

        }
        else if (s.name.equals("random_depression")) {

        }
        else if (s.name.equals("lift_weights")) {
            changes.add(new MetricChange("strength", 10));
            changes.add(new MetricChange("pain_body", 20));
        }
        else if (s.name.equals("running")) {
            changes.add(new MetricChange("strength", 3));
            changes.add(new MetricChange("pain_body", 10));
        }
        else if (s.name.equals("medicine")) {
            changes.add(new MetricChange("strength", 0));
            changes.add(new MetricChange("pain_body", -10));
        }
        else if (s.name.equals("slept_on_neck")) {
            changes.add(new MetricChange("pain_body", 20));
        }
        else if (s.name.equals("puberty")) {
            changes.add(new MetricChange("strength", 15));
        }
        else if (s.name.equals("twisted_ankle")) {
            changes.add(new MetricChange("pain_body", 5));
        }
        else if (s.name.equals("fall_down_stairs")) {
            changes.add(new MetricChange("pain_body", 5));
        }
        else if (s.name.equals("car_crash")) {
            changes.add(new MetricChange("pain_body", 25));
        }


        return changes;
    }

}
