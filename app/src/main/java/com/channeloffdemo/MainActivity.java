package com.channeloffdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/***
 * 用本地网页加载实现引导页
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(MainActivity.this,NativeActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this,WebBootPageActivity.class));
                break;
        }
    }
}
