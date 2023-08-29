package com.example.statusbarimage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    private var isStatusBarImageRequired: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<WebView>(R.id.testWebView).loadUrl("https://www.albertsons.com/")
        //View webview on status bar
        changeStatusBarColor(Color.TRANSPARENT, false)
        findViewById<Button>(R.id.btnColorChange).apply {
            setOnClickListener {
                isStatusBarImageRequired = if (isStatusBarImageRequired) {
                    changeStatusBarColor(Color.BLUE, true)
                    text = getString(R.string.move_webview_on_status_bar)
                    false
                } else {
                    changeStatusBarColor(Color.TRANSPARENT, false)
                    text = getString(R.string.move_webview_below_the_status_bar)
                    true
                }
            }
        }
    }

    //isNormal screen flag: if true, then window appears below status bar
    //if flag is false, the window appears above status bar
    // we can set status bar color as transparent to view the image content
    private fun changeStatusBarColor(color: Int, isNormalScreen: Boolean) {
        window.statusBarColor = color
        WindowCompat.setDecorFitsSystemWindows(this.window, isNormalScreen)
    }
}