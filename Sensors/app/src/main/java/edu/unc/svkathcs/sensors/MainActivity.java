package edu.unc.svkathcs.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView res_value = (TextView) get

    private SensorManager sm;
    private Sensor light, gravity, accelerometer;
    private List<Sensor> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
//        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
//        gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, 100);
//        sm.r

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Toast.makeText(this, event.sensor.getResolution() + "", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




}
