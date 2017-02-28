package edu.unc.nirjon.plotpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static int X;
    public static int Y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        X = 20;
        Y = 20;
    }

    /**
     * Function called when Click button on the App, The circle will move
     * diagonally in the custom view.
     * @param v
     */
    public void methodWeWant(View v)
    {
        Log.v("NIRJON", "method called");
        X = X + 10;
        Y = Y + 10;
        CustomView cv = (CustomView)findViewById(R.id.funny1);
        cv.invalidate();
    }

}
