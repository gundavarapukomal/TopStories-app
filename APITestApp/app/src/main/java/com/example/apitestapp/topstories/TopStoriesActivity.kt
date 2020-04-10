package com.example.apitestapp.topstories

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apitestapp.R
import com.example.apitestapp.data.stories.TopResult
import kotlinx.android.synthetic.main.activity_top_stories.*


class TopStoriesActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle(R.string.your_title);
        setContentView(R.layout.activity_top_stories)
        val model =
            ViewModelProviders.of(this).get<TopStoriesViewModel>(TopStoriesViewModel::class.java)

        model.setContext(applicationContext)
        model.getTopStoriesEvent()?.observe(this, Observer {
            setTopStoriesAdapter(it)

        })

        model.getErrorEvent()?.observe(this, Observer {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        })
    }


    private fun setTopStoriesAdapter(results: List<TopResult>?) {

        viewManager = LinearLayoutManager(applicationContext)
        viewAdapter = TopStoriesAdapter(results as ArrayList<TopResult>)

        list_details.apply {
            layoutManager = viewManager
            addItemDecoration(
                DividerItemDecoration(
                    applicationContext,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = viewAdapter
        }
    }

}
