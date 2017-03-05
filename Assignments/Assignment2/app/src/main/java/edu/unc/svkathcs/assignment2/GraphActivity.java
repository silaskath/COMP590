package edu.unc.svkathcs.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GraphActivity extends AppCompatActivity {
    PlotView plot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
    }

    public void backToMain(View v) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
//        double d = MainActivity.getAverage();
    }
}
