package com.example.tabexample.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.tabexample.R;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private Tip[] tips = {
            new Tip(R.string.tip_1_title, R.string.tip_1_body, R.drawable.git),
            new Tip(R.string.tip_2_title, R.string.tip_2_body, R.drawable.github),
            new Tip(R.string.tip_3_title, R.string.tip_3_body, R.drawable.clean_code),
    };

    private LiveData<String> title = Transformations.map(mIndex, new Function<Integer, String>() {

        @Override
        public String apply(Integer input) {
            return String.valueOf(tips[input - 1].title);
        }
    });

    private LiveData<String> body = Transformations.map(mIndex, new Function<Integer, String>() {

        @Override
        public String apply(Integer input) {
            return String.valueOf(tips[input - 1].body);
        }
    });

    private LiveData<String> image = Transformations.map(mIndex, new Function<Integer, String>() {

        @Override
        public String apply(Integer input) {
            return String.valueOf(tips[input - 1].image);
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getTitle() {
        return title;
    }
    public LiveData<String> getBody() {
        return body;
    }
    public LiveData<String> getImage() {
        return image;
    }
}