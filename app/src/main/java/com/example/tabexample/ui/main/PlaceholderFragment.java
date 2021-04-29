package com.example.tabexample.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tabexample.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView title = root.findViewById(R.id.title);
        final TextView body = root.findViewById(R.id.body);
        final ImageView image = root.findViewById(R.id.image);
        pageViewModel.getTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                title.setText(Integer.parseInt(s));
            }
        });
        pageViewModel.getBody().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                body.setText(Integer.parseInt(s));
            }
        });
        pageViewModel.getImage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                image.setImageResource(Integer.parseInt(s));
            }
        });
        return root;
    }
}