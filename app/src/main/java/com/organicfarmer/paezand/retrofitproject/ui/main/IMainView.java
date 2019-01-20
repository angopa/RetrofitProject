package com.organicfarmer.paezand.retrofitproject.ui.main;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;

public interface IMainView extends MvpView {
    void displayResult(Pixabay result);

    void displayErrorMessage(String message);
}
