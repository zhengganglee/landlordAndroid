package com.justlee.landlord;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        // 横向显示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 横向显示，但是基于设备传感器
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        WebView webView = findViewById(R.id.webView);
        initWebView(webView);
        webView.loadUrl("http://106.12.203.202");
    }

    private void initWebView(WebView webView) {
        // 声明WebSettings子类
        WebSettings webSettings = webView.getSettings();
        // 如果访问的页面中要与Javascript交互，则webView必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 支持Storage
        webSettings.setDomStorageEnabled(true);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {

        });
    }
}
