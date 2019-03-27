package com.hfad.catfacts;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private EditText editTextKeyword;
    private String keyword;
    private Button buttonSearch;
    private Button buttonNext;
    private int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();

       buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = editTextKeyword.getText().toString();
                x = 0;
                if(keyword.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter a keyword", Toast.LENGTH_SHORT).show();
                }
                else{
                getReddit();}
            }
        });

       buttonNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               x+= 1;
               getReddit();
           }
       });

    }


    private void wireWidgets() {
        textViewTitle = findViewById(R.id.textview_activitymain_title);
        editTextKeyword = findViewById(R.id.editText_mainactivity_keyword);
        buttonSearch = findViewById(R.id.button_main_search);
        buttonNext = findViewById(R.id.button_main_next);
    }

    private void getReddit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/r/todayilearned/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditService service = retrofit.create(RedditService.class);

        keyword = editTextKeyword.getText().toString();
        Call<RedditResponse> redditResponseCall = service.searchReddit(keyword, 1);

        redditResponseCall.enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(@NonNull Call<RedditResponse> call, @NonNull Response<RedditResponse> response) {
                Reddit reddit = response.body().getData();
                List<RedditResponse> redditResponses = reddit.getChildren();
                String title = redditResponses.get(x).toString();
                int startIndex = title.indexOf("title");
                int endIndex = title.indexOf("'}}");
                textViewTitle.setText(title.substring(startIndex+7, endIndex));
                Log.d("ENQUEUE", "onResponse: " + reddit.toString());
            }

            @Override
            public void onFailure(@NonNull Call<RedditResponse> call, @NonNull Throwable t) {
                Log.d("ENQUEUE", "onResponse: " + t.getMessage());
            }
        });





    }
}
