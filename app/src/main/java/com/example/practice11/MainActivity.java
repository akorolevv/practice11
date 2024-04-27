package com.example.practice11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        urlEditText = findViewById(R.id.urlEditText);
        Button loadButton = findViewById(R.id.loadButton);

        webView.setWebViewClient(new WebViewClient()); // Установка WebViewClient для webVie
        webView.getSettings().setJavaScriptEnabled(true); // Включение поддержки JavaScript для webView

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://")) { // Получение текста из urlEditText и преобразование в строку
                    url = "http://" + url;
                }
                webView.loadUrl(url); // Загрузка URL в webView
            }
        });
    }
}