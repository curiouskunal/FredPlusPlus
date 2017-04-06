package fred.plusplus;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Josh on 31/03/2017.
 */

public class Metric {

    private String name;
    private int value;
    private Texture image;
    private boolean isGood;

    public Metric(String name, int value, Texture image, boolean isGood){
        this.name = name;
        this.value = value;
        this.image = image;
        this.isGood = isGood;
    }

    public int getValue() { return value; }

    public void increment (int delta) {
        int n = value + delta;

        if (n < 0) {
            n = 0;
        }
        else if (n > 100) {
            n = 100;
        }
        else {
            value = n;
        }

    }

    public String getName(){
        return name;
    }
    public Texture getImage() { return image; }
    public boolean isGood(){ return isGood; }
}
