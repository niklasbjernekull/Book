package com.minichi.book.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
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
 * Created by Niklas.bjernekull on 2017-02-03.
 */

public class PagesFragment extends Fragment  {
    private ImageView homeButton;
    private ImageView page1i;
    private TextView page1t;
    private ImageView page2i;
    private TextView page2t;
    private ImageView page3i;
    private ImageView page4i;

    public static PagesFragment newInstance() {
        return new PagesFragment();
    }

    public PagesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pages_fragment, container, false);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/gothic.ttf");

        page1i = (ImageView) view.findViewById(R.id.page_image_row1_left);
        page1i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.PAGE1);
            }
        });

        page1t = (TextView) view.findViewById(R.id.text_field_row1_left);
        page1t.setTypeface(type);
        page1t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.PAGE1);
            }
        });

        page2i = (ImageView) view.findViewById(R.id.page_image_row1_center);
        page2i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.PAGE2);
            }
        });

        page2t = (TextView) view.findViewById(R.id.text_field_row1_center);
        page2t.setTypeface(type);
        page2t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.PAGE2);
            }
        });



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
}
