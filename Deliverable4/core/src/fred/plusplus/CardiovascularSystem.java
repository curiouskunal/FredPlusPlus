package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class CardiovascularSystem extends System {

    public CardiovascularSystem(){
        img = new Texture("FredCardiovascular.png");
        name = "cardiovascular";

        listOfMetrics = new ArrayList<Metric>();

        listOfMetrics.add(new Metric("blood_pressure", 50));
        listOfMetrics.add(new Metric("resting_heart_rate", 100));
        listOfMetrics.add(new Metric("overall_health", 50));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("deteriorate")){
            changes.add(new MetricChange("blood_pressure", -1));
            changes.add(new MetricChange("resting heart rate", -1));
        }
        else if (s.name.equals("food_unhealthy")) {
            changes.add(new MetricChange("blood_pressure", 10));
            changes.add(new MetricChange("resting_heart_rate", 1));
            changes.add(new MetricChange("overall_health", -1));
        }
        else if (s.name.equals("food_healthy")) {
            changes.add(new MetricChange("blood_pressure", 2));
            changes.add(new MetricChange("resting_heart_rate", 0));
            changes.add(new MetricChange("overall_health", 1));
        }
        else if (s.name.equals("food_spoiled")) {
            changes.add(new MetricChange("resting_heart_rate", 4));
            changes.add(new MetricChange("overall_health", -15));
        }
        else if (s.name.equals("drink_stimulant")) {
            changes.add(new MetricChange("blood_pressure", 20));
            changes.add(new MetricChange("resting_heart_rate", 15));
            changes.add(new MetricChange("overall_health", -20));
        }
        else if (s.name.equals("drink_hydration")) {
            changes.add(new MetricChange("overall_health", 3));
        }
        else if (s.name.equals("drink_depressant")) {
            changes.add(new MetricChange("resting_heart_rate", -15));
            changes.add(new MetricChange("overall_health", -5));
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
            changes.add(new MetricChange("blood_pressure", 30));
            changes.add(new MetricChange("resting_heart_rate", 30));
            changes.add(new MetricChange("overall_health", -50));
        }
        else if (s.name.equals("partying")) {
            changes.add(new MetricChange("blood_pressure", 5));
            changes.add(new MetricChange("resting_heart_rate", 15));
            changes.add(new MetricChange("overall_health", -5));
        }
        else if (s.name.equals("random_depression")) {

        }
        else if (s.name.equals("exercise_yoga")) {
            changes.add(new MetricChange("blood_pressure", -10));
            changes.add(new MetricChange("resting_heart_rate", -5));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("exercise_strength")) {
            changes.add(new MetricChange("blood_pressure", -5));
            changes.add(new MetricChange("resting_heart_rate", -5));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("exercise_cardio")) {
            changes.add(new MetricChange("blood_pressure", -10));
            changes.add(new MetricChange("resting_heart_rate", -5));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("medicine_painkiller")) {

        }
        else if (s.name.equals("medicine_painkiller_strong")) {

        }

        return changes;
    }

}
