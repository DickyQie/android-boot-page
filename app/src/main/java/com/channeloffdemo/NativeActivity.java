package com.channeloffdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;


import com.channeloffdemo.fragment.Fragment1;
import com.channeloffdemo.fragment.Fragment2;
import com.channeloffdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqie on 2016/11/12.
 */

public class NativeActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private List<View> listImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将屏幕设置为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ys);
        initView();
    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), showView()));
        listImg = new ArrayList<View>();
        listImg.add(findViewById(R.id.y1));
        listImg.add(findViewById(R.id.y2));
        listImg.add(findViewById(R.id.y3));
        viewPager.setOnPageChangeListener(showPageChange);
    }


    ViewPager.OnPageChangeListener showPageChange = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            for (int i = 0; i < listImg.size(); i++) {
                if (i == arg0) {
                    listImg.get(arg0).setBackgroundResource(R.drawable.y_focused);
                } else {
                    listImg.get(i).setBackgroundResource(R.drawable.y_normal);
                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    };




    private List<Fragment> showView() {
        List<Fragment> listView = new ArrayList<Fragment>();
        listView.add(new Fragment1());
        listView.add(new Fragment2());
        listView.add(new Fragment3());
        return listView;
    }
}
