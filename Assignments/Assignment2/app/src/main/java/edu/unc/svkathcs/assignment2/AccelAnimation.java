package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccelAnimation extends AppCompatActivity implements SensorEventListener{

    ImageView imv;
    private SensorManager sm;
    private Sensor current_sensor;
    private long last_printed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel_animation);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        current_sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, current_sensor, 1000000);

        imv = (ImageView) findViewById(R.id.imv);
        imv.setBackgroundResource(R.drawable.mylist);


    }

    public void advance() {
        ((AnimationDrawable)imv.getBackground()).run();
    }
    public void reset() {
        ((AnimationDrawable) imv.getBackground()).stop();
        ((AnimationDrawable) imv.getBackground()).run();
        ((AnimationDrawable) imv.getBackground()).stop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.timestamp - last_printed >= 1e8) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];
            double data = Math.sqrt(x * x + y * y + z * z);
            if(data > 11d)
                advance();
            else
                reset();
            last_printed = event.timestamp;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
