package edu.unc.svkathcs.mediaplayback;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Two important classses
    // MediaPlayer & AudioPlayer
    public MediaPlayer mp;
    Button play_but = (Button) findViewById(R.id.play_but);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this.getApplicationContext(), R.raw.kw_robots);
//        mp.start();
    }

    public void play(View v) { mp.start(); }

//    public void stop(View) { mp.stop(); }

    /* ---Playing from local resource---
    MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.sound_file_1);
    mediaPlayer.start(); // good for short sounds (effects)
    */

    /* ---Playing form a local URI

     */

    /* ---Playing from an Internet URL
        String url = "http://..."; // your url here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(url); // must be progressively downloadable
        mediaPlayer.prepare(); // might take long time for buffering etc.
        //more on slides
     */

}
