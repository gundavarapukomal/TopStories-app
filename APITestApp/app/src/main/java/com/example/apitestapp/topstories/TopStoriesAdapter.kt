package com.example.apitestapp.topstories

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.apitestapp.R
import com.example.apitestapp.data.stories.TopResult
import com.example.apitestapp.detail.DetailViewActivity
import com.example.apitestapp.detail.DetailViewActivity.Companion.TOP_STORY_KEY

class TopStoriesAdapter(val travelList: ArrayList<TopResult>) :
    RecyclerView.Adapter<TopStoriesAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(travelList.get(position))

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailViewActivity::class.java)

            intent.putExtra(TOP_STORY_KEY, travelList.get(position));
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.topstories_item,
                parent,
                false
            )
        )
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(travelObj: TopResult) {
            val title = itemView.findViewById(R.id.txt_title) as TextView
            val description = itemView.findViewById(R.id.txt_abstract) as TextView
            val link = itemView.findViewById(R.id.txt_link) as TextView

            title.setText(travelObj.getTitle())
            description.setText(travelObj.abstract)
            link.setText(travelObj.url)

            Glide.with(itemView.context).load(travelObj.multimedia[0].url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.findViewById(R.id.stories_img) as ImageView)

        }
    }
}