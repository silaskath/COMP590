package edu.unc.svkathcs.cameraintent;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void startTheCam(View any) {
        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent x) {
        ImageView img;
        {
            Bundle extras = x.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img = (ImageView) findViewById(R.id.imview);
            img.setImageBitmap(imageBitmap);
        }
    }


}
//Hint for assignment 1