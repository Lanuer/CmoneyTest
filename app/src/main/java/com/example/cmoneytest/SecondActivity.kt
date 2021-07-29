package com.example.cmoneytest

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class SecondActivity : Activity() {

    private lateinit var rv:RecyclerView
    private lateinit var tvBack: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById()
        setListener()
        init()
    }

    fun findViewById() {
        rv = findViewById(R.id.rv)
        tvBack = findViewById(R.id.tv_back)
    }

    fun setListener() {
        tvBack.setOnClickListener {
            finish()
        }
    }

    fun init() {
        sendRequest()
    }

    fun loadData(list: List<Item>) {
        rv.layoutManager = GridLayoutManager(this, 4)
        rv.adapter = MyAdapter(this, list)
    }

    fun sendRequest() {
        val url = "https://raw.githubusercontent.com/cmmobile/NasaDataSet/main/apod.json"
        val request = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                var list = Gson().fromJson(response, Array<Item>::class.java).toList()
                loadData(list)

            },
            Response.ErrorListener { error ->
                Log.e("testlog", "error: $error")
            }
        )
        VolleySingletion.requestQueue.add(request)
    }
}