package com.androidappcoding.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    public static String webview2 = "";
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        progressbar = findViewById(R.id.progressbar);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(webview2);
        webView.setWebViewClient(new WebViewClient());


        WebSettings webSettings = webView.getSettings();
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAllowContentAccess(true);
        webSettings.setDomStorageEnabled(true);

        webSettings.setSaveFormData(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setEnableSmoothTransition(true);

        webView.getSettings().setBlockNetworkLoads(false);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.clearCache(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressbar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressbar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        webView.setInitialScale(1);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);


    }

    @Override
    public void onBackPressed() {
       if (webView.canGoBack()){
           webView.goBack();
       }else {
           super.onBackPressed();
       }
    }
}