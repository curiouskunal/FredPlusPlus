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

    private CardiovascularSystem cardiovascular = new CardiovascularSystem();
    private NervousSystem nervous = new NervousSystem();
    private LocomotorSystem locomotor = new LocomotorSystem();
    private DigestiveSystem digestive = new DigestiveSystem();

    public FredAttributeDataStore(){
        fredBase = new Texture("FredBaseTemplate.png");
        subSystems.add(cardiovascular);
        subSystems.add(nervous);
        subSystems.add(locomotor);
        subSystems.add(digestive);
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
    }

    public void showSystem(String sysName){
        for (System sys : subSystems){
            if (sysName.equals(sys.getName())){
                sys.showHide();
            }
        }
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

}
