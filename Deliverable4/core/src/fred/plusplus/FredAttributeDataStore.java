package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 30/03/2017.
 */
public class FredAttributeDataStore {

    private Texture fredBase;

    private ArrayList<Metric> metrics = new ArrayList<Metric>();
    private ArrayList<System> subSystems = new ArrayList<System>();
    private ArrayList<Stimulus> availableStimuli = new ArrayList<Stimulus>();

    private CardiovascularSystem cardiovascular;
    private NervousSystem nervous;
    private LocomotorSystem locomotor;
    private DigestiveSystem digestive;

    NetResultCalc netResultCalc;

    public FredAttributeDataStore(){
        fredBase = new Texture("FredBaseTemplate.png");

        cardiovascular = new CardiovascularSystem();
        nervous = new NervousSystem();
        locomotor = new LocomotorSystem();
        digestive = new DigestiveSystem();

        subSystems.add(locomotor);
        subSystems.add(cardiovascular);
        subSystems.add(nervous);
        subSystems.add(digestive);

        netResultCalc = new NetResultCalc(this);

        updateMetrics();
    }

    public ArrayList<Metric> getMetrics(){
        return metrics;
    }

    public ArrayList<System> getActivatedSystems(){
        ArrayList<System> active = new ArrayList<System>();

        for (System sys : subSystems){
            if (sys.getIsActivated()){
                active.add(sys);
            }
        }
        return active;
    }

    public ArrayList<System> getVisibleSystems(){
        ArrayList<System> visible = new ArrayList<System>();

        for (System sys : subSystems){
            if (sys.getIsVisible()){
                visible.add(sys);
            }
        }
        return visible;
    }

    public ArrayList<Stimulus> getAvailableStimuli(){
        return availableStimuli;
    }

    public void toggleSystem(String sysName){
        for (System sys : subSystems){
            if (sysName.equals(sys.getName())){
                sys.toggle();
            }
        }

        updateMetrics();
    }

    public void showHideSystem(String sysName){
        for (System sys : subSystems){
            if (sysName.equals(sys.getName())){
                sys.showHide();
            }
        }
    }

    public void reactToStimuli (Stimulus s) {
        netResultCalc.reactToStimuli(s);
    }

    public Texture getBaseTexture(){
        return fredBase;
    }

    public void dispose(){
        fredBase.dispose();
        for (System sys: subSystems) {
            sys.dispose();
        }
    }

    private void updateMetrics() {
        metrics = new ArrayList<Metric>();

        for (System s : getActivatedSystems()) {
            for (Metric m : s.listOfMetrics) {
                if (! hasMetric(m.getName())) {
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

}
