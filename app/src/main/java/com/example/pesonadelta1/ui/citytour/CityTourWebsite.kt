package com.example.pesonadelta1.ui.citytour

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.citytour_website.*

class CityTourWebsite : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.citytour_website)
        val webView = findViewById<WebView>(R.id.citytourWebsite)

        actionBar?.setDisplayHomeAsUpEnabled(false)

        var intentThatStartedThisActivity = intent

        if(intentThatStartedThisActivity.hasExtra(Intent.ACTION_WEB_SEARCH)) {
            var citytourWebsite = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_WEB_SEARCH)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = object  : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    if (view != null) {
                        view.loadUrl("javascript:alert('Load selesai')")
                    }
                }
            }
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    Toast.makeText(this@CityTourWebsite, message, Toast.LENGTH_LONG).show()
                    if (result != null) {
                        result.confirm()
                    }
                    return true
                }
            }
            webView.loadUrl(citytourWebsite)
        } else {
//            Intent has no ACTION_WEB_SEARCH
        }

    }
}