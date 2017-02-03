package com.minichi.book.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.minichi.book.R;

/**
 * Created by Niklas.bjernekull on 2017-02-03.
 */

public class LogoFragment extends Fragment {
    private ImageView logo;
    private ImageView background;

    public static StartMenuFragment newInstance() {
        return new StartMenuFragment();
    }

    public LogoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_logo_fragment, container, false);

        logo = (ImageView) view.findViewById(R.id.splash_logo);

        background = (ImageView) view.findViewById(R.id.splash_logo_background);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "Start", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 60, 50);
                t.show();
            }
        });

        // play background music
        //Music.playBackgroundMusic();

        return view;
    }
}
