package fred.plusplus;

import java.util.ArrayList;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.lang.System;
/**
 * Created by Gabriel on 02/04/2017.
 */

public class RandomEventGenerator {
    ArrayList <RandomEvent> events;
    int probabilitySize;
    int[] probabilityIntervals;


    public RandomEventGenerator(int PSize,ArrayList<RandomEvent> event){
        //this.events = new ArrayList<RandomEvent>();
        this.events = event;
        ParseEvents(PSize);

        this.probabilitySize = PSize;// out of the size of 100 normally
    }

    private void ParseEvents(int size){


            //assign probability
            this.probabilityIntervals = new int[events.size()+2];//plus one because of the 0 and probsize
            int interval = 0;
            int i = 1;
            this.probabilityIntervals[0] = 0;//lower portion of the intervals

            for(RandomEvent list: events){
                this.probabilityIntervals[i] = interval + list.getProbability();
                interval = list.getProbability();
                i++;
            }
            this.probabilityIntervals[i] = size;
    }

    public void GenerateEvent(){
        Random rand = new Random();
        int pick = rand.nextInt(this.probabilitySize);
        int i = 0;
        for(RandomEvent list: events){
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
        FredAttributeDataStore fred = new FredAttributeDataStore();
        fred.reactToStimuli(new Stimulus(events.get(e).getName()));
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
