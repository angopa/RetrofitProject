package com.organicfarmer.paezand.retrofitproject.data.api;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static okhttp3.ConnectionSpec.MODERN_TLS;
import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public abstract class BaseApi {

    private static final int HTTP_TIMEOUT_SECONDS = 30;

    public abstract String getBaseUrl();

    public void customizeOkHttpClient(OkHttpClient.Builder builder) {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(BODY);

        builder.addInterceptor(httpLoggingInterceptor);
    }

    public Retrofit getConfiguredRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getConfiguredOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    protected OkHttpClient getConfiguredOkHttpClient() {
        ConnectionSpec connectionSpec = new ConnectionSpec.Builder(MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .build();

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .connectTimeout(HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .connectionSpecs(Collections.singletonList(connectionSpec));

        customizeOkHttpClient(builder);

        return builder.build();
    }
}
