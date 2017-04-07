package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 30/03/2017.
 */
public class FredAttributeDataStore {

    private Texture fredBase;
    private Texture fredExterior;

    private ArrayList<Metric> metrics = new ArrayList<Metric>();
    private ArrayList<System> subSystems = new ArrayList<System>();
    private ArrayList<Stimulus> availableStimuli = new ArrayList<Stimulus>();

    private int count = 0;

    private CardiovascularSystem cardiovascular;
    private NervousSystem nervous;
    private LocomotorSystem locomotor;
    private DigestiveSystem digestive;

    private boolean dead = false;

    NetResultCalc netResultCalc;

    public FredAttributeDataStore() {
        fredBase = new Texture("FredBaseTemplate.png");
        fredExterior = new Texture("FredExterior.png");

        nervous = new NervousSystem();
        cardiovascular = new CardiovascularSystem();
        digestive = new DigestiveSystem();
        locomotor = new LocomotorSystem();

        subSystems.add(nervous);
        subSystems.add(locomotor);
        subSystems.add(cardiovascular);
        subSystems.add(digestive);

        netResultCalc = new NetResultCalc(this);

        updateMetrics();
    }

    public ArrayList<Metric> getMetrics() {
        return metrics;
    }

    public ArrayList<System> getActivatedSystems() {
        ArrayList<System> active = new ArrayList<System>();

        for (System sys : subSystems) {
            if (sys.getIsActivated()) {
                active.add(sys);
            }
        }
        return active;
    }

    public void reactToStimuli(Stimulus s) {
        netResultCalc.reactToStimuli(s);
    }

    public ArrayList<System> getVisibleSystems() {
        ArrayList<System> visible = new ArrayList<System>();

        for (System sys : subSystems) {
            if (sys.getIsVisible()) {
                visible.add(sys);
            }
        }
        return visible;
    }

    public void toggleSystem(String sysName) {
        for (System sys : subSystems) {
            if (sysName.equals(sys.getName())) {
                sys.toggle();
            }
        }

        updateMetrics();
    }

    public void showHideSystem(String sysName) {
        for (System sys : subSystems) {
            if (sysName.equals(sys.getName())) {
                sys.showHide();
            }
        }
    }

    public Texture getBaseTexture() {
        return fredBase;
    }

    public Texture getExteriorTexture() {
        return fredExterior;
    }

    public void dispose() {
        fredBase.dispose();
        for (System sys : subSystems) {
            sys.dispose();
        }
    }

    private void updateMetrics() {
        metrics = new ArrayList<Metric>();

        for (System s : getActivatedSystems()) {
            for (Metric m : s.listOfMetrics) {
                if (!hasMetric(m.getName())) {
                    metrics.add(m);
                }
            }
        }
    }

    public boolean hasMetric(String metricName) {
        for (Metric m : metrics) {
            if (metricName.equals(m.getName())) {
                return true;
            }
        }
        return false;
    }


    public void deteriorate() {
        if (count >= 50) {
            reactToStimuli(new Stimulus("deteriorate"));
            count = 0;
        }
        count++;
    }

    public void signalDeath() {
        dead = true;
    }

    public boolean dead() {
        return dead;
    }

}
