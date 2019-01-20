package com.organicfarmer.paezand.retrofitproject.data.api;

import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {
    @GET("api")
    Call<Pixabay> getForecast(@Query("key") String key,
                              @Query("q") String query,
                              @Query("image_type") String imageType);
}
