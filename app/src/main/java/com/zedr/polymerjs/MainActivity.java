package com.zedr.polymerjs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zedr.polymerjs.R;

public class MainActivity extends AppCompatActivity {

    String url;
    WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web1=findViewById(R.id.web1);
        url  = this.getIntent().getExtras().getString("url");
        String pageurl="file:///android_asset/" + url;
        Log.d("india",pageurl);
        web1.loadUrl(pageurl);
        WebSettings settings=web1.getSettings();
        settings.setJavaScriptEnabled(true);

        web1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });


    }
}
