package edu.unc.svkathcs.assignment2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;
    private Sensor accel, light, mag, current_sensor;
    private int sampling_rate;
    private long last_printed = 0;

    PlotView plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        current_sensor = sm.getDefaultSensor(b.getInt("sensor"));
        sampling_rate = current_sensor.getMaxDelay();
        sm.registerListener(this, current_sensor, sampling_rate);
        plot = (PlotView)findViewById(R.id.plot);
        plot.initTime();
    }

    public void backToMain(View v) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.timestamp - last_printed >= 1e8) {
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];
            double data = Math.sqrt(x * x + y * y + z * z);
            plot.addSensorValue(data);
            last_printed = event.timestamp;
//            plot.invalidate();

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}