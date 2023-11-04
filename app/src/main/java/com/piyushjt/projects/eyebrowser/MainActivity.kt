package com.piyushjt.projects.eyebrowser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import android.widget.ImageView
import com.piyushjt.projects.eyebrowser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        val urlTxt= findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.url)
        val srchBtn= findViewById<ImageView>(R.id.searchBtn)
        srchBtn.setOnClickListener {

            var url = urlTxt.text.toString()

            binding.webView.loadUrl(url)
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebViewClient()
        }

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}