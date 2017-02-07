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

    public static enum FragmentScreen {
        LOGO,
        MENU,
        PAGE,
        SETTINGS
    }

    public void changeFragment(FragmentScreen fScreen) {
        fragManager = SharedResources.activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_container, getFragment(fScreen));
        fragmentTransaction.commit();
    }

    private Fragment getFragment(FragmentScreen fScreen) {
        switch (fScreen) {
            case LOGO:
                return new LogoFragment();
            case MENU:
                return new StartMenuFragment();
            default:
                break;
        }
        return null;
    }
}
