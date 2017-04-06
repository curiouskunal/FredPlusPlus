package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class NervousSystem extends System {

    public NervousSystem(){
        img = new Texture("FredNervous.png");
        name = "nervous";

        listOfMetrics = new ArrayList<Metric>();

        listOfMetrics.add(new Metric("dizziness", 0, new Texture("Dizzy.png"), false));
        listOfMetrics.add(new Metric("happiness", 50, new Texture("Happy.png"), true));
    }

    public ArrayList<MetricChange> reactToStimuli(Stimulus s){
        ArrayList<MetricChange> changes = new ArrayList<MetricChange>();

        if (s.name.equals("deteriorate")){
            changes.add(new MetricChange("dizziness", -1));
            changes.add(new MetricChange("happiness", -1));
            for (Metric m : listOfMetrics){
                if (m.getName().equals("dizziness") && m.getValue() > 70){
                    changes.add(new MetricChange("happiness", -2));
                }
                       }
        }
        else if (s.name.equals("food")) {
            changes.add(new MetricChange("happiness", 10));
            changes.add(new MetricChange("dizziness", -5));
        }
        else if (s.name.equals("drink")) {
            changes.add(new MetricChange("dizziness", 30));
            changes.add(new MetricChange("happiness", 30));
        }
        else if (s.name.equals("homework")) {
            changes.add(new MetricChange("happiness", -20));
            changes.add(new MetricChange("dizziness", -10));

        }
        else if (s.name.equals("bandage")) {
            changes.add(new MetricChange("happiness", 5));
        }
        else if (s.name.equals("random_injury")) {
            changes.add(new MetricChange("happiness", -75));
        }
        else if (s.name.equals("partying")) {
            changes.add(new MetricChange("happiness", 35));
            changes.add(new MetricChange("dizziness", 20));
        }
        else if (s.name.equals("random_depression")) {
            changes.add(new MetricChange("happiness", -75));
        }
        else if (s.name.equals("lift_weights")) {
            changes.add(new MetricChange("happiness", 15));
        }
        else if (s.name.equals("running")) {
            changes.add(new MetricChange("happiness", 15));
        }
        else if (s.name.equals("medicine")) {
            changes.add(new MetricChange("dizziness", 10));
        }

        return changes;
    }

}
