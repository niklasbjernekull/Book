package com.minichi.book;

import android.app.Application;

import com.minichi.book.tools.FontLoader;

/**
 * Created by Niklas.bjernekull on 2017-01-27.
 */

public class GameApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //FontLoader.loadFonts(this);

    }
}
