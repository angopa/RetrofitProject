package com.organicfarmer.paezand.retrofitproject.ui.main;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.organicfarmer.paezand.retrofitproject.R;
import com.organicfarmer.paezand.retrofitproject.data.api.RetrofitApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        RetrofitApi.getSharedInstance().getResultFor("volkswagen+car", new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Timber.tag(LOG).d(response.toString());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Timber.tag(LOG).d(t.getMessage());
            }
        });
    }
}
