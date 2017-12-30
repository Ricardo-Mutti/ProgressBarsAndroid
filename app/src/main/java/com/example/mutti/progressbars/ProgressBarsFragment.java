package com.example.mutti.progressbars;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ProgressBarsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewpage = inflater.inflate(R.layout.fragment_progress_bars, container, false);

        View ProgressBar_inderterminated = inflater.inflate(R.layout.fragment_progress_bar_indeterminate, container, false);
        View ProgressBar_image = inflater.inflate(R.layout.fragment_progress_bar_standard, container, false);

        Bundle bundle = getArguments();
        int page = bundle.getInt("count");

        switch (page) {//Aqui ele infla esse fragmento com uma view especifica

            case 3:

                return ProgressBar_inderterminated;

            case 4:

                return ProgressBar_image;

            default:
                return viewpage;
        }


    }


}
