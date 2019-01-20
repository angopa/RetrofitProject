package com.organicfarmer.paezand.retrofitproject.ui.main;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.organicfarmer.paezand.retrofitproject.R;
import com.organicfarmer.paezand.retrofitproject.data.api.RetrofitApi;
import com.organicfarmer.paezand.retrofitproject.data.model.Pixabay;

public class MainActivity extends MvpActivity<IMainView, IMainPresenter> implements IMainView {

    @BindView(R.id.text_view)
    protected TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public IMainPresenter createPresenter() {
        return new MainPresenter(RetrofitApi.getSharedInstance());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void displayResult(Pixabay result) {
        textView.setText(result.getTotalHits().toString());
    }

    @Override
    public void displayErrorMessage(String message) {
        textView.setText(message);
    }
}
