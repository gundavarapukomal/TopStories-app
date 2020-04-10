package com.example.apitestapp.topstories

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apitestapp.apicall.ApiClient
import com.example.apitestapp.apicall.ApiInterface
import com.example.apitestapp.data.stories.TopResult
import com.example.apitestapp.data.stories.TopStories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopStoriesViewModel : ViewModel() {
    private val key = "QxuimvZdtsFa6awFXrqV5fU7MwDFIkbC"
    lateinit var applicationContext: Context;
    private val topResultList: MutableLiveData<List<TopResult>> =
        MutableLiveData<List<TopResult>>();
    private val errorEvent: MutableLiveData<String> = MutableLiveData<String>();

    fun setContext(contxt: Context) {
        applicationContext = contxt;
        topStoriesApicall()
    }

    fun getTopStoriesEvent(): MutableLiveData<List<TopResult>>? {
        return topResultList
    }

    fun getErrorEvent(): MutableLiveData<String>? {
        return errorEvent
    }

    private fun topStoriesApicall() {
        val call: Call<TopStories> =
            ApiClient.getClient().create(ApiInterface::class.java).getTopStories(key)

        call.enqueue(object : Callback<TopStories> {
            override fun onFailure(call: Call<TopStories>?, t: Throwable?) {
                errorEvent.value = "error " + t.toString()
            }

            override fun onResponse(call: Call<TopStories>?, response: Response<TopStories>?) {
                val results = response?.body()?.results;
                topResultList.setValue(results)
            }
        })
    }

}
