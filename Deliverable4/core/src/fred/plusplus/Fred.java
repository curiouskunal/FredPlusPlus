package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Josh on 30/03/2017.
 */

public class Fred {

    private Texture fredBase;

    private ArrayList<Metric> metrics = new ArrayList<Metric>();
    private ArrayList<System> activeSystems = new ArrayList<System>();
    private ArrayList<System> allSystems = new ArrayList<System>();
    private ArrayList<Stimulus> availableStimuli = new ArrayList<Stimulus>();

    private CardiovascularSystem cardiovascular;
    private NervousSystem nervous;
    private LocomotorSystem locomotor;
    private DigestiveSystem digestive;

    public Fred (){
        fredBase = new Texture("FredBaseTemplate.png");

        cardiovascular = new CardiovascularSystem();
        nervous = new NervousSystem();
        locomotor = new LocomotorSystem();
        digestive = new DigestiveSystem();

        allSystems.add(cardiovascular);
        allSystems.add(nervous);
        allSystems.add(locomotor);
        allSystems.add(digestive);

        updateMetrics();
    }

    public ArrayList<Metric> getMetrics (){
        return metrics;
    }

    public ArrayList<System> getActivatedSystems (){
        return activeSystems;
    }

    public ArrayList<Stimulus> getAvailableStimuli (){
        return availableStimuli;
    }

    public boolean systemIsOn(String sysName) {
        for (System sys : activeSystems) {
            if (sysName.equals(sys.getName())) return true;
        }
        return false;
    }

    public boolean hasMetric(String metricName) {
        for (Metric m : metrics) {
            if (metricName.equals(m.name)) {
                return true;
            }
        }
        return false;
    }

    public void turnOnSystem(String sysName){
        if (!systemIsOn(sysName)) {
            for (System s : allSystems) {
                if (s.getName().equals(sysName)) {
                    activeSystems.add(s);
                }
            }
        }

        updateMetrics();
    }

    public void turnOffSystem(String sysName){
        if (systemIsOn(sysName)) {
            for (System s : activeSystems) {
                if (s.getName().equals(sysName)) {
                    activeSystems.remove(s);
                }
            }
        }

        updateMetrics();
    }

    private void updateMetrics() {
        metrics = new ArrayList<Metric>();

        for (System s : activeSystems) {
            for (Metric m : s.listOfMetrics()) {
                if (! hasMetric(m.name)) {
                    metrics.add(m);
                }
            }
        }
    }

    public Texture getBaseTexture(){
        return fredBase;
    }

    public void dispose(){
        fredBase.dispose();
        for (System sys: activeSystems) {
            sys.dispose();
        }
    }

}
