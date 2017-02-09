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
        PAGE1,
        PAGE2,
        PAGES,
        SETTINGS
    }

    public void changeFragment(FragmentScreen fScreen) {
        fragManager = SharedResources.activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, getFragment(fScreen));
        fragmentTransaction.commit();
    }
    public void changeFragmentFade(FragmentScreen fScreen) {
        fragManager = SharedResources.activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_container, getFragment(fScreen));
        fragmentTransaction.commit();
    }

    private Fragment getFragment(FragmentScreen fScreen) {
        switch (fScreen) {
            case LOGO:
                return new LogoFragment();
            case MENU:
                return new StartMenuFragment();
            case PAGE1:
                return new Page1Fragment();
            case PAGE2:
                return new Page2Fragment();
            case PAGES:
                return new PagesFragment();
            case SETTINGS:
                return new SettingsFragment();
            default:
                break;
        }
        return null;
    }
}
