package com.organicfarmer.paezand.retrofitproject.data.api;

import androidx.annotation.NonNull;
import retrofit2.Callback;

public class RetrofitApi extends BaseApi implements IRetrofitApi {

    private static RetrofitApi sharedInstance;

    @NonNull
    public static RetrofitApi getSharedInstance() {
        synchronized (RetrofitApi.class) {
            if (sharedInstance == null) {
                sharedInstance = new RetrofitApi();
            }

            return sharedInstance;
        }
    }

    private static final String KEY = "6636610-01cefc60a1b5ae099e5fca2f0";

    @NonNull
    private final RetrofitClient client;

    public RetrofitApi() {
        this.client = getConfiguredRetrofitInstance().create(RetrofitClient.class);
    }

    @Override
    public String getBaseUrl() {
        return "https://pixabay.com/";
    }

    @Override
    public void getResultFor(String query, Callback<Void> callback) {
        client.getForecast(KEY, query, "photo").enqueue(callback);
    }
}
