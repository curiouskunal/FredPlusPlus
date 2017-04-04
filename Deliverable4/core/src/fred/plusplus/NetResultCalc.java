package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class NetResultCalc {

    FredAttributeDataStore fred;

    public NetResultCalc(FredAttributeDataStore fred){
        this.fred = fred;
    }

    public void reactToStimuli(Stimulus stim) {
        for (System sys : fred.getActivatedSystems()) {
            ArrayList<MetricChange> changes = sys.reactToStimuli(stim);

            reactToStimuli(stim, sys, changes, fred.getMetrics());
        }
    }

    private void reactToStimuli(Stimulus stim, System sys, ArrayList<MetricChange> changes, ArrayList<Metric> metrics) {
        for (MetricChange mc : changes) {
            for (Metric m : metrics) {
                if (m.getName().equals(mc.metric)) {
                    m.increment(mc.delta);
                }
            }
        }
    }

}
