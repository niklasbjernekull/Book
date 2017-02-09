package com.minichi.book.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minichi.book.R;
import com.minichi.book.common.SharedResources;

/**
 * Created by Niklas.bjernekull on 2017-02-09.
 */

public class SettingsFragment extends Fragment {
    private ImageView homeButton;
    private ImageView soundButton;
    private TextView soundText;
    private Boolean soundIsOn = true;
    private Bitmap soundOnBmp;
    private Bitmap soundOffBmp;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public SettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);

        soundOnBmp = BitmapFactory.decodeResource(getResources(), R.drawable.toggle_on);
        soundOffBmp = BitmapFactory.decodeResource(getResources(), R.drawable.toggle_off);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/gothic.ttf");

        soundButton = (ImageView) view.findViewById(R.id.sound_switch);
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soundIsOn) {
                    soundButton.setImageBitmap(soundOffBmp);
                    soundIsOn = false;
                } else {
                    soundButton.setImageBitmap(soundOnBmp);
                    soundIsOn = true;
                }
            }
        });

        soundText = (TextView) view.findViewById(R.id.text_field_sound_setting);
        soundText.setTypeface(type);



        homeButton = (ImageView) view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.MENU);
            }
        });


        // play background music
        //Music.playBackgroundMusic();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        soundOffBmp.recycle();
        soundOnBmp.recycle();
    }
}
