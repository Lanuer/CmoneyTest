package com.example.cmoneytest

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

object VolleySingletion {

    private lateinit var context: Context

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }

    val imageLoader: ImageLoader by lazy {
        ImageLoader(requestQueue, LruBtimapCache())
    }

    fun initConfi(context: Context) {
        this.context = context.applicationContext
    }

}