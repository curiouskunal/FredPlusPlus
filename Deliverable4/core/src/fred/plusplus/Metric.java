package fred.plusplus;

/**
 * Created by Josh on 31/03/2017.
 */

public class Metric {
    String name;
    int value;

    public Metric(String name, int value){
        this.name = name;
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
