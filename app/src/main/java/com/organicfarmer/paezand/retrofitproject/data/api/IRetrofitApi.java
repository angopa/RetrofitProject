package com.organicfarmer.paezand.retrofitproject.data.api;

import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;
import retrofit2.Callback;

interface IRetrofitApi {
    void getResultFor(String query, Callback<Pixabay> callback);
}
