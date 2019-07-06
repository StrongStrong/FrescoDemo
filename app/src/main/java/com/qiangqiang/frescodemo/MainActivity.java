package com.qiangqiang.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrescoUtil util;
    String imgUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543313023590&di=bb9e255302ef13884e5f6db603e5329a&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F5121d1be65259.jpg";
    String gifUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559239992865&di=fde37602ff2d88e80006919163dde337&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201502%2F08%2F20150208174544_t3ZZA.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image);
        findViewById(R.id.showStaticMap).setOnClickListener(this);
        findViewById(R.id.showGifMap).setOnClickListener(this);
        findViewById(R.id.setGaussianblur).setOnClickListener(this);
        findViewById(R.id.setRound).setOnClickListener(this);
        findViewById(R.id.setRounded).setOnClickListener(this);
        util = new FrescoUtil(this);
    }

    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse("");
        switch (view.getId()) {
            case R.id.showStaticMap:
                util.setView(R.id.image).setUri(imgUrl).showStaticMap();
                break;
            case R.id.showGifMap:
                util.setView(R.id.image).setUri(gifUrl).showGifMap(true);
                break;
            case R.id.setGaussianblur:
                util.setView(R.id.image).setUri(imgUrl).showStaticMap().setGaussianblur(10,10);
                break;
            case R.id.setRound:
                util.setView(R.id.image).setUri(imgUrl).setRound().showStaticMap();
                break;
            case R.id.setRounded:
                util.setView(R.id.image).setUri(imgUrl).setRounded(50).showStaticMap();
                break;


        }
    }
}
