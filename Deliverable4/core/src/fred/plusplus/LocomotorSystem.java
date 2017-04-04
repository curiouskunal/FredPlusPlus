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

        listOfMetrics.add(new Metric("strength", 50));
        listOfMetrics.add(new Metric("pain_body", 0));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("food_unhealthy")) {
        }
        else if (s.name.equals("food_healthy")) {

        }
        else if (s.name.equals("food_spoiled")) {
            changes.add(new MetricChange("strength", 0));
            changes.add(new MetricChange("pain_body", 2));
        }
        else if (s.name.equals("drink_stimulant")) {

        }
        else if (s.name.equals("drink_hydration")) {

        }
        else if (s.name.equals("drink_depressant")) {

        }
        else if (s.name.equals("homework_elective")) {

        }
        else if (s.name.equals("homework_core")) {

        }
        else if (s.name.equals("homework_socsci")) {

        }
        else if (s.name.equals("bandage")) {

        }
        else if (s.name.equals("random_injury")) {

        }
        else if (s.name.equals("partying")) {

        }
        else if (s.name.equals("random_depression")) {

        }
        else if (s.name.equals("exercise_yoga")) {
            changes.add(new MetricChange("strength", 3));
            changes.add(new MetricChange("pain_body", 0));
        }
        else if (s.name.equals("exercise_strength")) {
            changes.add(new MetricChange("strength", 10));
            changes.add(new MetricChange("pain_body", 0));
        }
        else if (s.name.equals("exercise_cardio")) {
            changes.add(new MetricChange("strength", 3));
            changes.add(new MetricChange("pain_body", 0));
        }
        else if (s.name.equals("medicine_painkiller")) {
            changes.add(new MetricChange("strength", 0));
            changes.add(new MetricChange("pain_body", -10));
        }
        else if (s.name.equals("medicine_painkiller_strong")) {
            changes.add(new MetricChange("strength", 0));
            changes.add(new MetricChange("pain_body", -25));
        }

        return changes;
    }

}
