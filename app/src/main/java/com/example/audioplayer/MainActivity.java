
package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button b1,b2,b3;
//        b1=(Button)findViewById(R.id.button1);
//        b3=(Button)findViewById(R.id.button3);
//        b2=(Button)findViewById(R.id.button2);
//        MediaPlayer media = MediaPlayer.create(this,R.raw.song);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              media.start();
//            }
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                media.pause();
//            }
//        });
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                media.reset();
//            }
//        });
    }
    public  void play(View v){
        if(player==null){
            player=MediaPlayer.create(this,R.raw.song1);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public  void pause(View v){
            if(player != null){
                player.pause();
            }
    }
    public  void stop(View v){
  stopPlayer();
    }
private void stopPlayer(){
        if(player != null){
            player.release();
            player=null;
            Toast.makeText(this,"Media player released",Toast.LENGTH_SHORT).show();
        }
}

    @Override
    protected void onStart() {
        super.onStart();
        stopPlayer();
    }
}