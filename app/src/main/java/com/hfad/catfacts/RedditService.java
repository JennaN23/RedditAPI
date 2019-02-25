package com.hfad.catfacts;

import android.support.annotation.RestrictTo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditService {
    @GET("search.json")
    Call<RedditResponse> searchReddit(
            @Query("q") String keyword,
            @Query("restrict_sr") int restrict);

}
