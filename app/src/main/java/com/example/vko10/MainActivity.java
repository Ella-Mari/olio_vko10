 package com.example.vko10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    WebView web;
    TextView textField;
    EditText editField;
    TextWatcher watcher = null;
    private String oldPage;
    private String previousPage;
    private List history;

    Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webbi);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.is.fi");

        //web.getTitle(editField)
        System.out.println("HEllp");
        textField = findViewById((R.id.input));
        textField.setText("Syötä osoite");
        editField = findViewById(R.id.input);


    }
    public void search(View v) {

        String webPage = editField.getText().toString();

        oldPage = web.getUrl();
        if (webPage.contains("https://") || webPage.contains("http://")) {
            web.loadUrl(editField.getText().toString());
        } else {
        web.loadUrl("http://" + editField.getText().toString());}
    }
    public void refresh(View v){
        String pageNow = web.getUrl();
        web.loadUrl(pageNow);
    }
    public void openHTML(View v){
        web.loadUrl("file:///android_asset/index.html");
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void javaScript(View v){
        web.evaluateJavascript("javascript: shoutOut()",null);
    }
    public void back(View v){
        previousPage = web.getUrl();
        web.loadUrl(oldPage);

    }
    public void forward(View v){
        web.loadUrl(previousPage);
    }
}