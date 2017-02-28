package edu.unc.svkathcs.mediaplayback;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Two important classses
    // MediaPlayer & AudioPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
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
