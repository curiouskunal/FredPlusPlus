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

        listOfMetrics.add(new Metric("overall_health", 80, new Texture("Health.png"), true));
        //listOfMetrics.add(new Metric("blood_pressure", 50, new Texture("activeCardiovascular.png"), false));
        listOfMetrics.add(new Metric("resting_heart_rate", 40, new Texture("HeartRate.png"), false));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("deteriorate")){

            changes.add(new MetricChange("resting_heart_rate", 1));

            for (Metric m : listOfMetrics){
                if (m.getName().equals("resting_heart_rate") && m.getValue() < 30){
                    changes.add(new MetricChange("overall_health", 1));
                }
                else if (m.getName().equals("resting_heart_rate")){
                    changes.add(new MetricChange("overall_health", -1));
                }
            }
        }
        else if (s.name.equals("food")) {
            //changes.add(new MetricChange("blood_pressure", 10));
            changes.add(new MetricChange("resting_heart_rate", 15));
            changes.add(new MetricChange("overall_health", -5));
        }
        else if (s.name.equals("drink")) {
            changes.add(new MetricChange("resting_heart_rate", -10));
            changes.add(new MetricChange("overall_health", -10));
        }
        else if (s.name.equals("random_injury")) {
            //changes.add(new MetricChange("blood_pressure", 30));
            changes.add(new MetricChange("resting_heart_rate", 30));
            changes.add(new MetricChange("overall_health", -50));
        }
        else if (s.name.equals("partying")) {
            //changes.add(new MetricChange("blood_pressure", 5));
            changes.add(new MetricChange("resting_heart_rate", 15));
            changes.add(new MetricChange("overall_health", -10));
        }
        else if (s.name.equals("random_depression")) {

        }
        else if (s.name.equals("lift_weights")) {
            //changes.add(new MetricChange("blood_pressure", -5));
            changes.add(new MetricChange("resting_heart_rate", -5));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("running")) {
            //changes.add(new MetricChange("blood_pressure", -10));
            changes.add(new MetricChange("resting_heart_rate", -10));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("medicine")) {
            changes.add(new MetricChange("resting_heart_rate", -10));
            changes.add(new MetricChange("overall_health", 5));
        }
        else if (s.name.equals("ebola")) {
            changes.add(new MetricChange("resting_heart_rate", 15));
            changes.add(new MetricChange("overall_health", -20));
        }
        else if (s.name.equals("panic_attack")) {
            changes.add(new MetricChange("resting_heart_rate", 10));
        }
        else if (s.name.equals("fall_down_stairs")) {
            changes.add(new MetricChange("overall_health", -10));
        }
        else if (s.name.equals("car_crash")) {
            changes.add(new MetricChange("resting_heart_rate", -15));
            changes.add(new MetricChange("overall_health", -30));
        }

        return changes;
    }

}
