package team9.a3a04.fredplusplus;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Raw images
        Drawable d1 = ResourcesCompat.getDrawable(getResources(), R.drawable.base, null);
        Drawable d2 = ResourcesCompat.getDrawable(getResources(), R.drawable.skeleton, null);

        Drawable [] drawables = {d1, d2};

        // Image box to display the final result
        ImageView i = (ImageView) findViewById(R.id.layerview);
        LayerDrawable d = (LayerDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.layers, null);

        LayerDrawable layers = new LayerDrawable(drawables);

        // Hide
        layers.setDrawable(0, null);

        // Show
        layers.setDrawable(0, drawables [0]);

        // Update
        i.setImageDrawable(d);

        Button testButton = (Button) findViewById(R.id.testButton);

        testButton.setOnClickListener(new StimulusClickListener("test button"));
    }

    // Could make this it's own class... Or not.
    class StimulusClickListener implements View.OnClickListener {

        String info;

        public StimulusClickListener(String info) {
            this.info = info;
        }

        @Override
        public void onClick(View v) {
            // Send a message or something
        }
    }

}
