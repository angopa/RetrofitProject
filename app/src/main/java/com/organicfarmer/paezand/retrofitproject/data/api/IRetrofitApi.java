package com.organicfarmer.paezand.retrofitproject.data.api;

import retrofit2.Callback;

interface IRetrofitApi {
    void getResultFor(String query, Callback<Void> callback);
}
