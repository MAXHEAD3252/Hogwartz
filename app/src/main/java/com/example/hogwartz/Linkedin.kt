package com.example.hogwartz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient


class Linkedin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linkedin)

        internet()
    }
    @SuppressLint("NewApi")
    private fun internet()
    {
        var w = findViewById<WebView>(R.id.web)
        w.webViewClient= WebViewClient()
        w.apply {
            loadUrl("https://www.linkedin.com/in/akshat-joshi-b08231200")
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
    }

    override fun onBackPressed() {
        var w = findViewById<WebView>(R.id.web)
        if(w.canGoBack())
        {
            w.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
    }
