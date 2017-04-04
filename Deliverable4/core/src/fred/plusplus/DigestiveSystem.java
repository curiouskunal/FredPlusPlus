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

        listOfMetrics.add(new Metric("hunger", 50));
        listOfMetrics.add(new Metric("thirst", 50));
        listOfMetrics.add(new Metric("pain_stomach", 0));
        listOfMetrics.add(new Metric("intoxication_level", 0));
        listOfMetrics.add(new Metric("weight", 50));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("food_unhealthy")) {
            changes.add(new MetricChange("pain_stomach", 2));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", -20));
            changes.add(new MetricChange("thirst", -5));
            changes.add(new MetricChange("weight", 5));
        }
        else if (s.name.equals("food_healthy")) {
            changes.add(new MetricChange("pain_stomach", -2));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", -10));
            changes.add(new MetricChange("thirst", -2));
            changes.add(new MetricChange("weight", 2));
        }
        else if (s.name.equals("food_spoiled")) {
            changes.add(new MetricChange("pain_stomach", 40));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", 0));
            changes.add(new MetricChange("thirst", 0));
            changes.add(new MetricChange("weight", 0));
        }
        else if (s.name.equals("drink_stimulant")) {
            changes.add(new MetricChange("pain_stomach", 2));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", 0));
            changes.add(new MetricChange("thirst", 0));
            changes.add(new MetricChange("weight", 0));
        }
        else if (s.name.equals("drink_hydration")) {
            changes.add(new MetricChange("pain_stomach", 0));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", -5));
            changes.add(new MetricChange("thirst", -50));
            changes.add(new MetricChange("weight", 0));
        }
        else if (s.name.equals("drink_depressant")) {
            changes.add(new MetricChange("pain_stomach", 0));
            changes.add(new MetricChange("intoxication_level", 25));
            changes.add(new MetricChange("hunger", 0));
            changes.add(new MetricChange("thirst", 5));
            changes.add(new MetricChange("weight", 20));
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
            changes.add(new MetricChange("pain_stomach", 10));
            changes.add(new MetricChange("intoxication_level", 0));
            changes.add(new MetricChange("hunger", 0));
            changes.add(new MetricChange("thirst", 0));
            changes.add(new MetricChange("weight", 0));

        }
        else if (s.name.equals("partying")) {

        }
        else if (s.name.equals("random_depression")) {

        }
        else if (s.name.equals("exercise_yoga")) {
        }
        else if (s.name.equals("exercise_strength")) {

        }
        else if (s.name.equals("exercise_cardio")) {

        }
        else if (s.name.equals("medicine_painkiller")) {

        }
        else if (s.name.equals("medicine_painkiller_strong")) {

        }

        return changes;
    }

}
