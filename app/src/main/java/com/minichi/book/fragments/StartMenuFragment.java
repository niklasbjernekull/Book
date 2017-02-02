package com.minichi.book.fragments;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.minichi.book.R;

/**
 * Created by Niklas.bjernekull on 2017-02-01.
 */

public class StartMenuFragment extends Fragment {

    private ImageView title;
    private ImageView startButton;
    private ImageView startButtonLights;
    private ImageView settingsButton;
    private ImageView pagesButton;

    public static StartMenuFragment newInstance() {
        return new StartMenuFragment();
    }

    public StartMenuFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_menu_fragment, container, false);

        title = (ImageView) view.findViewById(R.id.start_menu_title);

        startButton = (ImageView) view.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "Start", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 60, 50);
                t.show();
            }
        });

        /*startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // animate title from place and navigation buttons from place
                animateAllAssetsOff(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        SharedResources.eventBus.notify(new StartEvent());
                    }
                });
            }
        });*/


        startButtonLights = (ImageView) view.findViewById(R.id.start_button_lights);


        settingsButton = (ImageView) view.findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.LEFT|Gravity.TOP, 10, 100);
                t.show();
            }
        });

        /*settingsGameButton.setSoundEffectsEnabled(false);
        settingsGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupManager.showPopupSettings();
            }
        });*/

        pagesButton = (ImageView) view.findViewById(R.id.pages_button);
        pagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "Pages", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.RIGHT|Gravity.TOP, -300, 100);
                t.show();
            }
        });

        startLightsAnimation();

        // play background music
        //Music.playBackgroundMusic();

        return view;
    }

    private void startLightsAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(startButtonLights, "rotation", 0f, 360f);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        startButtonLights.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animator.start();
    }
}
