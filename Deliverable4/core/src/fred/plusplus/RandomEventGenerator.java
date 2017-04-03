package fred.plusplus;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
/**
 * Created by Gabriel on 02/04/2017.
 */

public class RandomEventGenerator {
    ArrayList <RandomEvent> events;
    int probabilitySize;
    int[] probabilityIntervals;


    public RandomEventGenerator(int PSize){
        ParseEvents();
        this.probabilitySize = PSize;// out of the size of 100
        ProbabilityAssign();
    }
    private void ParseEvents(){
        try {
            FileReader input = new FileReader("../data/RandomEvents.txt");
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;
            ArrayList<RandomEvent> Randomevents = new ArrayList<RandomEvent>();
            while ((myLine = bufRead.readLine()) != null) {
                String[] array1 = myLine.split(":");
                String[] array2 = array1[1].split(",");
                // check to make sure you have valid data
                String EventName = array2[0];
                ArrayList<MetricChange> changes = new ArrayList<MetricChange>();
                int probabilityNum = Integer.parseInt(array2[array2.length - 1]);
                for (int i = 0; i < array2.length - 1; i = i + 2) {
                    changes.add(new MetricChange(new Metric(array2[i],10/*temp*/),Integer.parseInt(array2[i+1])));
                }
                Randomevents.add(new RandomEvent(changes, EventName, probabilityNum));
            }
        this.events = Randomevents;
        }catch (IOException ex){
        }
    }

    private void ProbabilityAssign(){
        probabilityIntervals = new int[this.events.size()+2];//plus one because of the 0 and probsize
        int interval = 0;
        int i = 1;
        probabilityIntervals[0] = 0;//lower portion of the intervals
        for(RandomEvent list: this.events){
            this.probabilityIntervals[i] = interval + list.getProbability();
            i++;
        }
        probabilityIntervals[i]=probabilitySize;//highest portion of the intervals
    }
    private void GenerateEvent(){
        Random rand = new Random();
        int pick = rand.nextInt(this.probabilitySize);
        int i = 0;
        for(RandomEvent list: this.events){
            if(checkInterval(pick,this.probabilityIntervals[i],this.probabilityIntervals[i+1])&&
                    this.probabilityIntervals[i+1]!=probabilitySize) {
            ApplyEvent(i);//return the event that has the probabilty
            }
            i++;
        }
        //nothing happens
    }
    /*ApplyEvent(e)
    * e - the index of the event that is being applied
    * This method iterates through the list of MetricChanges that are tied to the desired event and
    * applies them
     */
    private void ApplyEvent(int e){
        for(MetricChange list: this.events.get(e).getEffects()){
            //apply MetricChange
        }
    }
    /*  checkInterval(b,lower,higher)
    * b - the index of the number the program desires
    * lower - the lower portion of the index
    * higher - the higher portion of the index
    * This bool quickly checks to see if the index is inside of the interval. When the random
    * number is sent to this method, the lower half is included, thus why the lower is >=
     */
    private boolean checkInterval(int b, int lower,int higher){
        if(b >= lower && b < higher){
            return true;
        }else{
            return false;
        }

    }

}
