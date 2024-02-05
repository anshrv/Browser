 package com.nadershamma.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

     private WebView web;
     ImageButton searchBtn;
     AutoCompleteTextView inputUrl;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         inputUrl = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
         searchBtn = (ImageButton) findViewById(R.id.goBtn);
         web = (WebView) findViewById(R.id.WebView);
         WebSettings ws = web.getSettings();
         ws.setJavaScriptEnabled(true);
         web.loadUrl("https://ya.ru");
         web.setWebViewClient(new WebViewClient());

         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
         searchBtn.setOnClickListener((v) -> {
             String url = inputUrl.getText().toString();
             if(url.startsWith("http") == true){
                 web.loadUrl(url);
             } else {
                 url = "https://yandex.ru/search/?text=" + url.replace(" ","+") + "&lr=50";
                 web.loadUrl(url);
             }
             InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
             inputMethodManager.hideSoftInputFromWindow(web.getWindowToken(),0);
         });
     }
 }