package com.alie.modulepracticewidget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class TestActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
        onWidgetWork(intent)
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        onWidgetWork(intent)
    }


    private fun onWidgetWork(intent: Intent?) {
        intent?.let {
            when (it.action) {
                this.getString(R.string.widget_action) -> {
                    it.data?.let { uri ->
                        if (uri.scheme == this.getString(R.string.widget_scheme)
                            && uri.host == this.getString(R.string.widget_host)) {
                            when(uri.port) {
                                getString(R.string.widget_port_1).toInt()-> showToast("work:${uri.port}")
                                getString(R.string.widget_port_2).toInt()-> showToast("work:${uri.port}")
                                getString(R.string.widget_port_3).toInt()-> showToast("work:${uri.port}")
                                else ->{
                                    showToast("error port")
                                }
                            }
                        }
                    }
                }
                else -> {
                    showToast("not widget Action");
                }
            }
        }
    }

    private fun showToast(tips: String) {
        Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
    }
}