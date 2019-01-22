package com.organicfarmer.paezand.retrofitproject.ui.main;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.organicfarmer.paezand.retrofitproject.data.api.IRetrofitApi;
import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends MvpBasePresenter<IMainView> implements IMainPresenter {

    private final IRetrofitApi retrofitApi;

    public MainPresenter(final IRetrofitApi retrofitApi) {
        this.retrofitApi = retrofitApi;
    }

    @Override
    public void start() {
        retrofitApi.getResultFor("volkswagen", new Callback<Pixabay>() {
            @Override
            public void onResponse(Call<Pixabay> call, Response<Pixabay> response) {
                if (isViewAttached()) {
                    getView().displayResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Pixabay> call, Throwable t) {
                if (isViewAttached()) {
                    getView().displayErrorMessage(t.getMessage());
                }
            }
        });
    }
}
