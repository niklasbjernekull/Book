package com.minichi.book.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.minichi.book.R;
import com.minichi.book.common.SharedResources;

/**
 * Created by Niklas.bjernekull on 2017-02-03.
 */

public class Page2Fragment extends Fragment  {
    private TextView textField;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private ImageView homeButton;
    private ImageView character;

    public static Page2Fragment newInstance() {
        return new Page2Fragment();
    }

    public Page2Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_2_fragment, container, false);

        textField = (TextView) view.findViewById(R.id.text_field);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/grobold.ttf");
        textField.setTypeface(type);

        textField.setText("A wild strange thing appeared!\nGo away!");


        homeButton = (ImageView) view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.MENU);
            }
        });

        arrowLeft = (ImageView) view.findViewById(R.id.left_button);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.PAGE1);
            }
        });

        arrowRight = (ImageView) view.findViewById(R.id.right_button);
        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedResources.engine.setNewFragment(FragmentHandler.FragmentScreen.MENU);
            }
        });

        character = (ImageView) view.findViewById(R.id.character);
        Activity a = getActivity();
        final MediaPlayer mp = MediaPlayer.create(a.getApplicationContext(), R.raw.pika);
        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                characterAnimation();
            }
        });


        // play background music
        //Music.playBackgroundMusic();

        return view;
    }

    private void characterAnimation() {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(character, "scaleY", 0.7f);
        scaleY.setDuration(200);
        scaleY.setRepeatCount(1);
        ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(character, "scaleY", 1f);
        scaleYBack.setDuration(500);
        scaleYBack.setInterpolator(new BounceInterpolator());
        scaleYBack.setRepeatCount(1);
        final AnimatorSet animatorSet = new AnimatorSet();
        //animatorSet.setStartDelay(1000);
        animatorSet.playSequentially(scaleY, scaleYBack);
        /*animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //animatorSet.setStartDelay(2000);
                animatorSet.start();
            }
        });*/
        //animatorSet.setDuration(scaleY.getDuration()+scaleYBack.getDuration());
        character.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();
    }
}
