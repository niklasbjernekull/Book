package com.minichi.book.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.minichi.book.R;
import com.minichi.book.common.SharedResources;

/**
 * Created by Niklas.bjernekull on 2017-02-01.
 */

public class FragmentHandler {

    private FragmentManager fragManager;

    public FragmentHandler() {
    }

    public void changeFragment() {
        fragManager = SharedResources.activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, getFragment());
        fragmentTransaction.commit();
    }

    private Fragment getFragment() {
        return new StartMenuFragment();
    }
}
