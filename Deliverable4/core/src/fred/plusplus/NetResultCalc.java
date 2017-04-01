package fred.plusplus;

import java.util.ArrayList;

/**
 * Created by Josh on 31/03/2017.
 */

public class NetResultCalc {

    Fred fred;

    public NetResultCalc(Fred fred){
        this.fred = fred;
    }

    void reactToStimuli(Stimulus stim) {
        ArrayList<Metric> metrics = fred.getMetrics();

        for (System sys : fred.getActivatedSystems()) {
            ArrayList<MetricChange> changes = sys.reactToStimuli(stim);

            for (MetricChange mc : changes) {
                for (Metric m : metrics) {
                    if (m.name.equals(mc.metric)) {
                        m.value += mc.delta;
                    }
                }
            }
        }
    }

}
