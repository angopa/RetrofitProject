package com.organicfarmer.paezand.retrofitproject.data.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {
    @GET("api")
    Call<Void> getForecast(@Query("key") String key,
                     @Query("q") String query,
                     @Query("image_type") String imageType);
}
