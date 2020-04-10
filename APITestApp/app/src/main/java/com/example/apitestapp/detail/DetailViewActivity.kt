package com.example.apitestapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.apitestapp.R
import com.example.apitestapp.data.stories.TopResult
import kotlinx.android.synthetic.main.activity_detail_view.*

class DetailViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.your_title1);
        setContentView(R.layout.activity_detail_view)
        if (intent != null) {

            val topResult: TopResult = intent.getSerializableExtra(TOP_STORY_KEY) as TopResult
            txt_title.setText(topResult.title)
            txt_abstract.setText(topResult.abstract)
            txt_url.setText(topResult.url)

            Glide.with(applicationContext).load(topResult.multimedia[0].url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img_story);
        }
    }

    companion object {
        val TOP_STORY_KEY: String? = "TOP_STORY_KEY"

    }
}
