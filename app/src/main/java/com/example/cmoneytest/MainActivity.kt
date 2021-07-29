package com.example.cmoneytest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var btn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById()
        setListener()
        init()
    }

    fun findViewById() {
        btn = findViewById(R.id.btn)
    }

    fun setListener() {
        btn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    fun init() {
        val metrics: DisplayMetrics = getResources().getDisplayMetrics()
        width = metrics.widthPixels/4
        height = width
    }

    companion object {
        var width: Int = 0
        var height: Int = 0
    }
}