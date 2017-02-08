package com.minichi.book.engine;

import android.support.v4.app.FragmentManager;

import com.minichi.book.fragments.FragmentHandler;

/**
 * Created by Niklas.bjernekull on 2017-02-01.
 */

public class BookEngine {

    private FragmentHandler fragHandler;
    private static BookEngine thisInstance;

    public BookEngine() {
        fragHandler = new FragmentHandler();
    }

    public static BookEngine getInstance() {
        if (thisInstance == null) {
            thisInstance = new BookEngine();
        }
        return thisInstance;
    }

    public void start() {
        fragHandler.changeFragmentFade(FragmentHandler.FragmentScreen.LOGO);
    }

    public void setNewFragment(FragmentHandler.FragmentScreen screen) {
        fragHandler.changeFragmentFade(screen);
    }
}
