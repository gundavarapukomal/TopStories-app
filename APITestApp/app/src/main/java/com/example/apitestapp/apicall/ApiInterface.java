package com.example.apitestapp.apicall;

import com.example.apitestapp.data.stories.TopStories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("home.json?")
    Call<TopStories> getTopStories(@Query("api-key") String apiKey);


}
