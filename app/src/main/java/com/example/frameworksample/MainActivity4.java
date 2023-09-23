package com.example.frameworksample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    private WebView wv1;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();


        String str1 = intent.getStringExtra("message_key");

        wv1=(WebView)findViewById(R.id.webview123);


        wv1.setWebViewClient(
                new SSLTolerentWebViewClient()
        );
        wv1.getSettings().setBuiltInZoomControls(true);
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebSettings settings = wv1.getSettings();
        settings.setAllowFileAccess(true);
        wv1.setInitialScale(150);
        wv1.loadUrl(str1);

        wv1.clearCache(true);


    }


    private static class SSLTolerentWebViewClient extends WebViewClient {

        @SuppressLint("WebViewClientOnReceivedSslError")
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }


}