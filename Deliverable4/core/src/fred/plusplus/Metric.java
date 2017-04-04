package fred.plusplus;

/**
 * Created by Josh on 31/03/2017.
 */

public class Metric {

    private String name;
    private int value;

    public Metric(String name, int value){
        this.name = name;
        this.value = value;
    }

    public int value() { return value; }

    public void increment (int delta) {
        int n = value + delta;

        if (n < 0) n = 0;
        if (n > 100) n = 100;

        value = 100;
    }

    public String getName(){
        return name;
    }

}
