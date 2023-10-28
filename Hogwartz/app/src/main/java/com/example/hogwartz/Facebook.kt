package com.example.hogwartz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Facebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook)

        facebook_f()
    }

    @SuppressLint("NewApi")
    private fun facebook_f()
    {

        var w = findViewById<WebView>(R.id.web_fb)
        w.webViewClient = WebViewClient()
        var apply = w.apply {
            loadUrl("https://www.facebook.com/akshat.joshi.7509")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

        }
    }
    override fun onBackPressed() {
        var w = findViewById<WebView>(R.id.web_fb)
        if (w.canGoBack()) {
            w.goBack()
        } else {
            super.onBackPressed()
        }
    }
}