package com.example.weige.UI;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import demo.CustomVideoView;


public class videoview extends AppCompatActivity {

    public static videoview inst = null;
    private Timer timer;
    private TimerTask timerTask;
    Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inst = this;
        // 全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_pager);
        /*主要代码起始位置*/
        final CustomVideoView vv = (CustomVideoView) this.findViewById(R.id.videoView);
        final String uri = "android.resource://" + getPackageName() + "/" + R.drawable.logo;
        vv.setVideoURI(Uri.parse(uri));
        vv.start();
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {


            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(false);
            }
        });
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(inst, MainActivity.class);
                startActivity(intent);
                inst.finish();

            }

        });
        final Button button = (Button) findViewById(R.id.pass);
        handler=new Handler();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                button.setVisibility(View.VISIBLE);
            }
        };
        handler.postDelayed(timerTask, 3000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(videoview.this, MainActivity.class);
                startActivity(intent);
                videoview.this.finish();
            }
        });

        /*主要代码结束位置*/

    }

    protected void onDestroy() {

        //当Activity销毁的时候 终止计时器

        timerTask.cancel();

        super.onDestroy();


    }
}

