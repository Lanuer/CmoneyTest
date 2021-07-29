package com.example.cmoneytest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.example.cmoneytest.MainActivity.Companion.height
import com.example.cmoneytest.MainActivity.Companion.width

class MyAdapter(mContext: Context, list: List<Item>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var context = mContext
    var myList = list

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            val picture = itemView.findViewById<NetworkImageView>(R.id.iv_picture)
            val title = itemView.findViewById<TextView>(R.id.tv_title)

            itemView.layoutParams.let { lp ->
                lp.width = width
                lp.height = height
                itemView.layoutParams = lp
            }

            picture.setImageUrl(item.url, VolleySingletion.imageLoader)
            title.text = item.title

            itemView.setOnClickListener(View.OnClickListener {
                var intent = Intent(context, ThirdActivity::class.java)
                intent.putExtra("description", item.description)
                intent.putExtra("copyright", item.copyright)
                intent.putExtra("title", item.title)
                intent.putExtra("url", item.url)
                intent.putExtra("apodSite", item.apod_site)
                intent.putExtra("date", item.date)
                intent.putExtra("mediaType", item.media_type)
                intent.putExtra("hdUrl", item.hdurl)
                context.startActivity(intent)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_view, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount() = myList.size

}