package com.hfad.catfacts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditService {
    @GET("api/")
    Call<RedditResponse> searchReddit(0
            @Query("i") String keyword);
}
