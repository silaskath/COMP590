package edu.unc.svkathcs.appjan17;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import static edu.unc.svkathcs.appjan17.R.drawable.s;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int x = 10;
        Log.v("MyTAG****----", "Here is the debug message, x - " + x);
        x = 15;
        Log.v("MyTAG****----", "Here is the debug message, x - " + x);


    }

    public int clicks = 0;


    void foo(View v) {
        Intent X = new Intent(this, Activity2.class);
//        X.setData(Activity2);
        startActivity(X);
        Log.v("TAG", "You touched it.");
        TextView tv = (TextView)findViewById(R.id.text_box_2);
        tv.setText("You touched it. Count = " + clicks);
        Button bt = (Button)findViewById(R.id.touch_me);
        bt.setBackgroundResource(R.drawable.s);
        clicks++;
    }
}
