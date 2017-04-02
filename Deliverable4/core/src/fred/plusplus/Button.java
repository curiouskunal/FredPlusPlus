package fred.plusplus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Josh on 01/04/2017.
 */

public class Button {

    private int x;
    private int y;
    private int width;
    private int height;
    private Texture onImage;
    private Texture offImage;
    private boolean isOn;
    private boolean isActive;
    private String subSystem;


    public Button(int x, int y, String subSystem, String onFileName, String offFileName){
        this.x = x;
        this.y = y;
        this.subSystem = subSystem;
        onImage = new Texture(onFileName);
        offImage = new Texture(offFileName);
        width = onImage.getWidth();
        height = onImage.getHeight();
        isOn = true;
        isActive = true;
    }

    public int getX(){return x;}
    public int getY(){return Gdx.graphics.getHeight() - height - y;}

    public boolean isOn(){
        return isOn;
    }

    public void activate(){
        isActive = true;
    }
    public void deactivate(){
        isActive = false;
    }

    public String getSubSystem(){
        return subSystem;
    }

    public Texture getTexture(){
        if (isOn){
            return onImage;
        }
        else{
            return offImage;
        }
    }


    public boolean intersects(int tapX, int tapY){
        return (tapX >= x) && (tapX <= x + width) && (tapY >= y) && (tapY <= y + height);
    }

    public void tap(){
        if (isActive){
            isOn = !isOn;
        }
    }

}
