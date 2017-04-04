package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class NervousSystem extends System {

    public NervousSystem(){
        img = new Texture("FredSkeleton.png");
        name = "nervous";

        listOfMetrics.add(new Metric("pain_head", 0));
        listOfMetrics.add(new Metric("dizziness", 0));
        listOfMetrics.add(new Metric("happiness", 50));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("food_unhealthy")) {
        }
        else if (s.name.equals("food_healthy")) {
        }
        else if (s.name.equals("food_spoiled")) {
            changes.add(new MetricChange("pain_head", 0));
            changes.add(new MetricChange("dizziness", 20));
            changes.add(new MetricChange("happiness", -20));
        }
        else if (s.name.equals("drink_stimulant")) {
            changes.add(new MetricChange("pain_head", 0));
            changes.add(new MetricChange("dizziness", 10));
            changes.add(new MetricChange("happiness", 15));
        }
        else if (s.name.equals("drink_hydration")) {
            changes.add(new MetricChange("pain_head", 0));
            changes.add(new MetricChange("dizziness", -10));
            changes.add(new MetricChange("happiness", 5));
        }
        else if (s.name.equals("drink_depressant")) {
            changes.add(new MetricChange("pain_head", 0));
            changes.add(new MetricChange("dizziness", 30));
            changes.add(new MetricChange("happiness", 30));
        }
        else if (s.name.equals("homework_elective")) {
            changes.add(new MetricChange("happiness", -30));
        }
        else if (s.name.equals("homework_core")) {
            changes.add(new MetricChange("happiness", -20));
        }
        else if (s.name.equals("homework_socsci")) {
            changes.add(new MetricChange("happiness", -50));
        }
        else if (s.name.equals("bandage")) {

        }
        else if (s.name.equals("random_injury")) {
            changes.add(new MetricChange("happiness", -75));
        }
        else if (s.name.equals("partying")) {
            changes.add(new MetricChange("happiness", 35));
        }
        else if (s.name.equals("random_depression")) {
            changes.add(new MetricChange("happiness", -75));
        }
        else if (s.name.equals("exercise_yoga")) {
            changes.add(new MetricChange("happiness", 25));
        }
        else if (s.name.equals("exercise_strength")) {
            changes.add(new MetricChange("happiness", 25));
        }
        else if (s.name.equals("exercise_cardio")) {
            changes.add(new MetricChange("pain_head", 0));
            changes.add(new MetricChange("dizziness", 2));
        }
        else if (s.name.equals("medicine_painkiller")) {
            changes.add(new MetricChange("pain_head", -30));
            changes.add(new MetricChange("dizziness", 0));
        }
        else if (s.name.equals("medicine_painkiller_strong")) {
            changes.add(new MetricChange("pain_head", -50));
            changes.add(new MetricChange("dizziness", 0));
        }

        return changes;
    }

}
