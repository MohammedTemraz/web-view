package com.mohammed.webview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    WebView aljabrh;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        gifImageView = findViewById(R.id.splash_logo);

        aljabrh = (WebView) findViewById(R.id.aljabrh);
        aljabrh.loadUrl("https://www.aljabrh.com.sa/");
        WebSettings webSettings = aljabrh.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aljabrh.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                Log.e("onPageFinished: ", "" + gifImageView.getDrawingTime());

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        gifImageView.setVisibility(View.GONE);

                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (aljabrh.canGoBack()){
            aljabrh.goBack();
        }else {
            super.onBackPressed();
        }
    }
}