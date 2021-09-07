package com.example.qrcode

import android.os.Bundle

import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class ViewQR : AppCompatActivity() {
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_qr);
        webView = findViewById<View>(R.id.viewQR) as WebView
        webView!!.webViewClient = WebViewClient();
        //wvv!!.webChromeClient = WebChromeClient()
        val QRurl = intent.extras!!.getString("QRurl")
        webView!!.loadUrl(QRurl!!);

        //wvv!!.loadUrl(QRurl!!)
        val webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}