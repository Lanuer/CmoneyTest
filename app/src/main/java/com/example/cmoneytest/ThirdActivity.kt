package com.example.cmoneytest

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import java.text.SimpleDateFormat
import java.util.*

class ThirdActivity : Activity() {

    //參數名稱
    private lateinit var description: String
    private lateinit var copyright: String
    private lateinit var title: String
    private lateinit var url: String
    private lateinit var apodSite: String
    private lateinit var date: String
    private lateinit var mediaType: String
    private lateinit var hdUrl: String

    //View
    private lateinit var tvDate: TextView
    private lateinit var ivHdurl: NetworkImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvCopyright: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvBack: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        findViewById()
        setListener()
        init()
    }

    fun findViewById() {
        tvDate = findViewById(R.id.tv_date)
        ivHdurl = findViewById(R.id.iv_hdurl)
        tvTitle = findViewById(R.id.tv_title)
        tvCopyright = findViewById(R.id.tv_copyright)
        tvDescription = findViewById(R.id.tv_description)
        tvBack = findViewById(R.id.tv_back)
    }

    fun setListener() {
        tvBack.setOnClickListener {
            finish()
        }
    }

    fun init() {
        getData()
    }

    fun getData() {
        description = intent.getStringExtra("description").toString()
        copyright = intent.getStringExtra("copyright").toString()
        title = intent.getStringExtra("title").toString()
        url = intent.getStringExtra("url").toString()
        apodSite = intent.getStringExtra("apodSite").toString()
        date = intent.getStringExtra("date").toString()
        mediaType = intent.getStringExtra("mediaType").toString()
        hdUrl = intent.getStringExtra("hdUrl").toString()

        tvDate.text = getTime4String(date)
        ivHdurl.setImageUrl(hdUrl, VolleySingletion.imageLoader)
        tvTitle.text = title
        tvCopyright.text = copyright
        tvDescription.text = description
    }

    fun getTime4String(time: String): String {
        var oldSdf = SimpleDateFormat("yyyy-MM-dd")
        var newSdf = SimpleDateFormat("yyyy MMM.dd", Locale.US)
        var date = oldSdf.parse(time)
        return newSdf.format(date)
    }

}