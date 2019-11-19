package com.example.weige.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import demo.CustomVideoView;
import utils.ShareUtils;
import utils.StaticClass;
import utils.UtilTools;

//初始登录动画，即闪屏页
public class SplashActivity extends AppCompatActivity {
    /*1.延时2000s
    * 判断程序是否是第一次运行
    * 自定义字体
    * Activity全屏主题
    * */
    public static SplashActivity inst = null;
    private TextView textView;

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if (isFirst()) {
                        Intent intent;
                        intent = new Intent(SplashActivity.this, GuigeActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 全屏显示
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        inst = this;

        initView();
    }

    private void initView() {
        //设置播放时间
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,5000);
        textView=findViewById(R.id.tv_show);
        /*主要代码起始位置*/
        final CustomVideoView vv =  this.findViewById(R.id.videoView);
        final String uri = "android.resource://" + getPackageName() + "/" + R.raw.logo;
        vv.setVideoURI( Uri.parse(uri));
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
//                Intent intent = new Intent(inst, MainActivity.class);
//                startActivity(intent);
//                inst.finish();

            }

        });
        //设置字体
        UtilTools.setfonts(this,textView);
    }
    
    //判断是否程序第一次运行
    private Boolean isFirst() {
        boolean isfirst= ShareUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,true);
        if (isfirst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            return true;
        }else {
            return false;
        }
    }
}
