package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Josh on 31/03/2017.
 */

public class Metric {

    private String name;
    private int value;
    private Texture image;

    public Metric(String name, int value){
        this.name = name;
        this.value = value;
       // this.image = image;
    }

    public int getValue() { return value; }

    public void increment (int delta) {
        int n = value + delta;

        if (n < 0) n = 0;
        if (n > 100) n = 100;

        value = n;
    }

    public String getName(){
        return name;
    }

}
