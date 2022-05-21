package com.alie.modulepracticeutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.alie.modulepracticeutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListener()
    }

    private fun initListener() {
        binding.btn1.setOnClickListener {
            Toast.makeText(
                this,
                "net work connect ${NetworkUtil.isNetworkEnable(this)}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}