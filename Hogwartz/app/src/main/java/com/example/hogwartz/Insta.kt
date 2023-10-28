package com.example.hogwartz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Insta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta)
        instagram_f()
    }
    @SuppressLint("NewApi")
    private fun instagram_f()
    {
        var w = findViewById<WebView>(R.id.web_insta)
        w.webViewClient = WebViewClient()
        var apply = w.apply {
            loadUrl("https://www.instagram.com/akshat_btk/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        var w = findViewById<WebView>(R.id.web_insta)
        if (w.canGoBack()) {
            w.goBack()
        } else {
            super.onBackPressed()
        }
    }
}