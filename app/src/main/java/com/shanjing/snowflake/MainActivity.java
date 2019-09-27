package com.shanjing.snowflake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    private WebView wv;
    private View cl_view;
    private FallingView fallingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl_view = findViewById(R.id.cl_view);
        StatusBarUtil.setTranslucentForImageView(MainActivity.this, 0, cl_view);

        wv = findViewById(R.id.wv);
        // 设置WebView属性，能够执行Javascript脚本
        wv.getSettings().setJavaScriptEnabled(true);
        //语言设置防止加载乱码
        wv.getSettings().setDefaultTextEncodingName("GBK");
        // 即asserts文件夹下有一个color2.html
        wv.loadUrl("file:///android_asset/index.html");


        //初始化一个雪花样式的fallObject
        FallObject.Builder builder = new FallObject.Builder(getResources().getDrawable(R.drawable.snow_flake));
        FallObject fallObject = builder
                .setSpeed(6, true)
                .setSize(40, 40, true)
                .setWind(5, true, true)
                .build();

        fallingView = findViewById(R.id.fallingView);
        fallingView.addFallObject(fallObject, 100);//添加下落物体对象
    }
}
