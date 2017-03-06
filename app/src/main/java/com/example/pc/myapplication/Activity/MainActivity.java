package com.example.pc.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.common.CommonActivity;
import com.example.pc.myapplication.common.Logs;

import static com.example.pc.myapplication.R.id.webView;

public class MainActivity extends CommonActivity implements View.OnClickListener {

    private WebView mWebView;
    private final Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.shop).setOnClickListener(this);
        findViewById(R.id.product).setOnClickListener(this);
        findViewById(R.id.point).setOnClickListener(this);
        findViewById(R.id.ing).setOnClickListener(this);

        mWebView = (WebView) findViewById(webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());

        final long startTime = System.currentTimeMillis();
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                long elapsedTime = System.currentTimeMillis()-startTime;
                Logs.e("페이지 로딩 타임 : " + (elapsedTime/1000));
            }
        });

        mWebView.loadUrl("http://allets.com");
    }

    private class AndroidBridge {
        public void callAndroid(final String arg) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Logs.e("arg : " + arg);
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        final int key = v.getId();
        Intent i = null;
        switch (key) {
            case R.id.home:
                mWebView.loadUrl("http://allets.com");
                break;
            case R.id.shop:

                break;
            case R.id.product:

                break;
            case R.id.point:

                break;
            case R.id.ing:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            mWebView.removeAllViews();
            mWebView.destroy();
            super.onBackPressed();
        }
    }
}
