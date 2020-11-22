package com.example.weige.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

//动画界面，即三页介绍页面
public class GuigeActivity extends AppCompatActivity  {


    private ViewPager viewPager;
    private int[]images={R.drawable.b1,R.drawable.b2,R.drawable.b3};
    //用来存放几个imageview的实例
    private List<VideoView>videoViews;
    private List<ImageView> imageViews;
    private LinearLayout li;
    private RelativeLayout rl;
    private ImageView black_color;
    private int left;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guige2);

        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter());
        li =  findViewById(R.id.linear);
        rl =  findViewById(R.id.rl);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( GuigeActivity.this,MainActivity.class );
                startActivity( intent );
                finish();
            }
        });
        //图片：
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);

            imageView.setScaleType( ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);

            ImageView white_color = new ImageView(this);
            white_color.setImageResource(R.drawable.white_circle);

            //使用LayoutParams改变控件的位置
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            }
            white_color.setLayoutParams(layoutParams);
            li.addView(white_color);
        }
        black_color = new ImageView(this);
        black_color.setImageResource(R.drawable.black_circle);
        rl.addView(black_color);

        //示图树
        //关于圆点
        black_color.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    //该方法就是在界面全面绘制结束之后回调
                    @Override
                    public void onGlobalLayout() {
                        // TODO Auto-generated method stub
                        //求距离
                        left = li.getChildAt(1).getLeft() - li.getChildAt(0).getLeft();
                        System.out.println("leftΪ" + left);
                        black_color.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                if (position == images.length - 1) {
                    btn.setVisibility(View.VISIBLE);
                } else {
                    btn.setVisibility(View.GONE);
                }
            }
            //滑动的时候
            @Override
            public void onPageScrolled(int position, float posionOffset, int arg2) {
                // TODO Auto-generated method stub
                System.out.println(posionOffset);//滑动的百分比
                Log.d("viewpager:", String.valueOf(posionOffset));
                RelativeLayout.LayoutParams layoutParams =
                        (RelativeLayout.LayoutParams) black_color.getLayoutParams();
                layoutParams.leftMargin = (int) (left * posionOffset + position * left);
                black_color.setLayoutParams(layoutParams);

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub

            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View)object);
        }
    }
}
