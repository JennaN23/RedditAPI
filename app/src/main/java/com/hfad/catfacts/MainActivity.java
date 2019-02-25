package com.hfad.catfacts;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getReddit();
    }

    private void getReddit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/r/todayilearned/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditService service = retrofit.create(RedditService.class);

        Call<RedditResponse> redditResponseCall = service.searchReddit("TIL", 1);

        redditResponseCall.enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(@NonNull Call<RedditResponse> call, @NonNull Response<RedditResponse> response) {
                Reddit reddit = response.body().getData();
                Log.d("ENQUEUE", "onResponse: " + reddit.toString());
            }

            @Override
            public void onFailure(@NonNull Call<RedditResponse> call, @NonNull Throwable t) {
                Log.d("ENQUEUE", "onResponse: " + t.getMessage());
            }
        });

    }
}
